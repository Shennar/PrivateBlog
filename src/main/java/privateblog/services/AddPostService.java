package privateblog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import privateblog.database.Database;
import privateblog.domain.BlogPost;

import java.time.LocalDate;

@Component
public class AddPostService {

    @Autowired private Database database;

    public Long addProduct(String postText) {

        BlogPost blogPost = new BlogPost();
        blogPost.setPostText(postText);
        blogPost.setPostDate(LocalDate.now());

        database.addPost(blogPost);

        return blogPost.getId();
    }

}
