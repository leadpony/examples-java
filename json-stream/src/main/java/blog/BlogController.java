package blog;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BlogController {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @RequestMapping("/blog")
    public Blog index() {
        List<BlogPost> posts = jdbcTemplate.query(
                "SELECT * FROM blog_post",
                BlogController::toPost
                );
        return new Blog(posts);
    }

    private static BlogPost toPost(ResultSet rs, int rowNum) throws SQLException {
        return new BlogPost(
            rs.getInt("id"),
            rs.getString("author"),
            rs.getString("title"),
            rs.getString("content"),
            rs.getTimestamp("posted").toLocalDateTime()
        );
    }
}
