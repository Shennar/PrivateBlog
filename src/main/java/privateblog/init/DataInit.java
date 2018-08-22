package privateblog.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import privateblog.dao.BlogPostDAO;
import privateblog.entity.BlogPost;

import java.time.LocalDate;

@Component
public class DataInit implements ApplicationRunner {
	private BlogPostDAO blogPostDAO;
	@Autowired
	public DataInit (BlogPostDAO blogPostDAO){
		this.blogPostDAO=blogPostDAO;
	}
	@Override
	public void run(ApplicationArguments args) throws Exception{
		long count = blogPostDAO.count();
		if (count==0){
			BlogPost bp = new BlogPost();
			for (int i=0;i<5;i++){
				bp.setPostDate(LocalDate.of(2018,i+1,2*i+1));
				bp.setPostText("This is the post #"+i+"!");
				blogPostDAO.save(bp);
			}
		}
	}
}
		