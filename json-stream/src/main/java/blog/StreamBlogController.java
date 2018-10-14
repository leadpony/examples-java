package blog;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;

/**
 * The controller returning all blog posts.
 */
@Controller
public class StreamBlogController {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final String FIND_POSTS = "SELECT * FROM blog_post ORDER BY id";
    private static final String COUNT_POSTS = "SELECT count(*) FROM blog_post";
    private final JsonFactory jsonFactory = new JsonFactory();
    
    @RequestMapping("/blog2")
    public void index(HttpServletResponse response) {
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        try (JsonGenerator g = jsonFactory.createGenerator(
                    response.getOutputStream(), JsonEncoding.UTF8)) {
            g.writeStartObject();
            g.writeFieldName("posts");
            g.writeStartArray();
            jdbcTemplate.query(
                    StreamBlogController::createPreparedStatement, 
                    new BlockPostProcessor(g));
            g.writeEndArray();
            g.writeNumberField("numberOfPosts", countPosts());
            g.writeEndObject();
        } catch (IOException | UncheckedIOException e) {
        }
    }
    
    private static PreparedStatement createPreparedStatement(Connection conn) throws SQLException {
        PreparedStatement s = conn.prepareStatement(FIND_POSTS, 
                ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
        s.setFetchSize(Integer.MIN_VALUE);
        return s;
    }
    
    private int countPosts() {
        return jdbcTemplate.queryForObject(COUNT_POSTS, Integer.class);
    }
    
    private static class BlockPostProcessor implements RowCallbackHandler {
        
        private final JsonGenerator g;
        
        BlockPostProcessor(JsonGenerator g) {
            this.g = g;
        }

        @Override
        public void processRow(ResultSet rs) throws SQLException {
            try {
                LocalDateTime posted = rs.getTimestamp("posted").toLocalDateTime();
                g.writeStartObject();
                g.writeStringField("author", rs.getString("author"));
                g.writeStringField("title", rs.getString("title"));
                g.writeStringField("content", rs.getString("content"));
                g.writeStringField("posted", posted.format(DateTimeFormatter.ISO_DATE_TIME));
                g.writeEndObject();
                g.flush();
            } catch (IOException e) {
                throw new UncheckedIOException(e);
            }
        }
    }
}
