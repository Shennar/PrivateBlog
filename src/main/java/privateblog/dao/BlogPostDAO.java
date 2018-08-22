package privateblog.dao;

import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
import privateblog.entity.BlogPost;

@Repository
public interface BlogPostDAO extends CrudRepository <BlogPost, Long>{}