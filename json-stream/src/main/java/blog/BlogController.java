package blog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The controller returning all blog posts.
 */
@RestController
public class BlogController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    private static final String SQL = "SELECT * FROM blog_post ORDER BY id";
    
    @RequestMapping("/blog")
    public Blog index() {
        List<BlogPost> posts = jdbcTemplate.query(SQL, BlogController::mapRowToPost);
        return new Blog(posts);
    }

    private static BlogPost mapRowToPost(ResultSet rs, int rowNum) throws SQLException {
        return new BlogPost(
            rs.getInt("id"),
            rs.getString("author"),
            rs.getString("title"),
            rs.getString("content"),
            rs.getTimestamp("posted").toLocalDateTime()
        );
    }
}
