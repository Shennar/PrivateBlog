package privateblog.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import privateblog.domain.BlogPost;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogController {

    private static List<BlogPost> persons = new ArrayList<BlogPost>();
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = {"/addNewPost"}, method = RequestMethod.GET)
    public String addNewPost(Model model) {

        model.addAttribute("persons", persons);

        return "personList";
    }

    @RequestMapping(value = {"/deletePost"}, method = RequestMethod.GET)
    public String deletePost(Model model) {

        model.addAttribute("persons", persons);

        return "personList";
    }

    @RequestMapping(value = {"/selectPost"}, method = RequestMethod.GET)
    public String selectPost(Model model) {

        model.addAttribute("persons", persons);

        return "personList";
    }

    @RequestMapping(value = {"/updatePost"}, method = RequestMethod.GET)
    public String updatePost(Model model) {

        model.addAttribute("persons", persons);

        return "personList";
    }

    @RequestMapping(value = {"/sortPostByDate"}, method = RequestMethod.GET)
    public String sortPostByDate(Model model) {

        model.addAttribute("persons", persons);

        return "personList";
    }
}

