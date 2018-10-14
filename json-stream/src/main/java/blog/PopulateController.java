package blog;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PopulateController {
    
    private static final Log log = LogFactory.getLog(PopulateController.class);

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @RequestMapping("/populate")
    @ResponseBody
    public String post() {
        new Thread(this::populate).start();
        return "Populating posts";
    }
    
    private void populate() {
        int count = 0;
        while (count++ < 10000) {
            String author = RandomStringUtils.randomAlphanumeric(100);
            String title = RandomStringUtils.randomAlphanumeric(1000);
            String content = RandomStringUtils.randomAlphanumeric(10000);
            jdbcTemplate.update(
                    "INSERT INTO blog_post(author, title, content) VALUES(?, ?, ?)",
                    author, title, content);
            if ((count % 1000) == 0) {
                log.info("Added " + count + " posts");
            }
        }
    }
}
