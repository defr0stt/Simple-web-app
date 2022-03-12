package ua.lpnu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lpnu.models.Post;
import ua.lpnu.repo.PostRepository;

@Controller
public class BlogController
{
    // посилання
    @Autowired
    private PostRepository postRepository;

    //getMapping - link to page
    @GetMapping("/blog")
    public String blogMain(@RequestParam(name="blog", required=false, defaultValue="Blog-main") String name, Model model){
        model.addAttribute("blog",name);
        Iterable<Post> posts = postRepository.findAll();
        model.addAttribute("posts",posts);
        // returned value = name of view
        return "blog-main";
    }
}