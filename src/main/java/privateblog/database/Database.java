package privateblog.database;

import privateblog.domain.BlogPost;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface Database {
    void addPost(BlogPost blogPost);

    Optional<BlogPost> sortByDate(Date postDate);

    boolean deletePost(BlogPost blogPost);

    void updatePost(BlogPost blogPost);

    List<BlogPost> getAllPosts();

    BlogPost getSelectedPost(Long id);
}
