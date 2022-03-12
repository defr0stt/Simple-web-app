package ua.lpnu.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BlogController
{
    //getMapping - link to page
    @GetMapping("/blog")
    public String blogMain(@RequestParam(name="blog", required=false, defaultValue="Blog-main") String name, Model model){
        model.addAttribute("blog",name);
        // returned value = name of view
        return "blog-main";
    }
}