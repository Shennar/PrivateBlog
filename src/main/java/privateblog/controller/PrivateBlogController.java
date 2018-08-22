package privateblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import privateblog.dao.BlogPostDAO;
import privateblog.entity.BlogPost;
import privateblog.form.BlogPostForm;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class PrivateBlogController{
	@Autowired
	private BlogPostDAO blogPostDAO;

	@RequestMapping(value={"/","/index"}, method = RequestMethod.GET)
	public String index(){

	    return "index";
	}
	@RequestMapping(value={"/showAllPosts"}, method = RequestMethod.GET)
	public String showAllPosts(Model model){
        List<BlogPost> allBlogPosts = new ArrayList<>();
		blogPostDAO.findAll().forEach(b -> allBlogPosts.add(b));
        allBlogPosts.stream().collect(Collectors.toList());
		model.addAttribute("allBlogPosts", allBlogPosts);
		return "showAllPosts";
	}
	@RequestMapping(value={"/addPost"}, method = RequestMethod.GET)
	public String addNewPostForm(Model model){
		BlogPostForm blogPostForm = new BlogPostForm();
		model.addAttribute("blogPostForm", blogPostForm);
		return "addPost";
	}
	@RequestMapping(value={"/addPost"}, method = RequestMethod.POST)
	public String addNewPost(Model model, @ModelAttribute("blogPostForm")
	BlogPostForm blogPostForm){
		String postText = blogPostForm.getPostText();
			BlogPost bp = new BlogPost();
			bp.setPostText(postText);
			bp.setPostDate(LocalDate.now());
            blogPostDAO.save(bp);
			return "redirect:/index";
    }
	@RequestMapping(value={"/sortPostsByDate"}, method = RequestMethod.GET)
	public String showPostsSortedByDate(Model model){
		List<BlogPost> sortedPosts = new ArrayList<>();
                blogPostDAO.findAll().forEach(b -> sortedPosts.add(b));
        List<BlogPost> sortedPosts1 = sortedPosts.stream()
				.sorted((b1,b2) -> b1.getPostDate().compareTo(b2.getPostDate()))
				.collect(Collectors.toList());
		model.addAttribute("blogPosts", sortedPosts1);
		return "sortPostsByDate";
	}
	@RequestMapping(value={"/selectedPost"}, method = RequestMethod.GET)
	public String showSelectedPost(Model model, @RequestParam Long id){
		BlogPost bp = blogPostDAO.findById(id).get();
		model.addAttribute("post",bp);
		return "selectedPost";
	}
	@RequestMapping(value={"/deletePost"}, method = RequestMethod.POST)
	public String deletePost(@RequestParam Long id){
		blogPostDAO.deleteById(id);
		return "deletePost";
	}
	@RequestMapping(value={"/updatePost"}, method = RequestMethod.GET)
	public String showPostToUpdate(Model model, @RequestParam Long id){
		BlogPostForm blogPostForm = new BlogPostForm();
		BlogPost bp = blogPostDAO.findById(id).get();
		blogPostForm.setPostText(bp.getPostText());
		blogPostForm.setPostDate(bp.getPostDate());
		model.addAttribute("blogPostForm", blogPostForm);
		return "updatePost";
	}
	@RequestMapping(value={"/updatePost"}, method = RequestMethod.POST)
	public String updatePost(Model model, @ModelAttribute ("blogPostForm") 
		BlogPostForm blogPostForm, @RequestParam Long id){
			String postText = blogPostForm.getPostText();
				BlogPost bp = new BlogPost();
				bp.setPostText(postText);
				bp.setId(id);
				bp.setPostDate(blogPostDAO.findById(id).get().getPostDate());
				blogPostDAO.save(bp);
				return "redirect:/index";
    }
}