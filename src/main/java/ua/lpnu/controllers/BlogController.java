package ua.lpnu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.lpnu.models.Post;
import ua.lpnu.repo.PostRepository;

import java.util.ArrayList;
import java.util.Optional;

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

    @GetMapping("/blog/add")
    public String blogAdd(Model model){
        return "blog-add";
    }

    @PostMapping("/blog/add")
    public String blogPostAdd(@RequestParam String title, @RequestParam String anons,
                              @RequestParam String fullText, Model model){
        Post post = new Post(title, anons, fullText);
        postRepository.save(post);
        return "redirect:/blog";
    }

    @GetMapping("/blog/{id}")
    public String blogDetails(@PathVariable(value = "id") long  id, Model model){

        if(!postRepository.existsById(id)){
            return "redirect:/blog";
        }

        Optional<Post> post = postRepository.findById(id);
        ArrayList<Post> res = new ArrayList<>();
        post.ifPresent(res::add);
        model.addAttribute("post", res);
        return "blog-info";
    }
}