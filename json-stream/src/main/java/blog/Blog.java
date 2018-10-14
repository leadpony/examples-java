package blog;

import java.util.List;

/**
 * Blog containing all posts.
 */
public class Blog {

    private final List<BlogPost> posts;
    
    public Blog(List<BlogPost> posts) {
        this.posts = posts;
    }
    
    public int getNumberOfPosts() {
        return posts.size();
    }
    
    public List<BlogPost> getPosts() {
        return posts;
    }
}
