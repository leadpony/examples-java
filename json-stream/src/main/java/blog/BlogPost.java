package blog;

import java.time.LocalDateTime;

/**
 * An entry of blog.
 */
public class BlogPost {
    
    private final int id;
    private final String author;
    private final String title;
    private final String content;
    private final LocalDateTime posted;
    
    public BlogPost(int id, String author, String title, String content, LocalDateTime posted) {
        this.id = id;
        this.author = author;
        this.title = title;
        this.content = content;
        this.posted = posted;
    }
    
    public int getId() {
        return id;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
    
    public LocalDateTime getPosted() {
        return posted;
    }
}
