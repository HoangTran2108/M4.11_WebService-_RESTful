package com.example.bt.controller;

import com.example.bt.model.Category;
import com.example.bt.model.Post;
import com.example.bt.service.category.ICategoryService;
import com.example.bt.service.posts.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    private IPostsService postsService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping()
    public ResponseEntity<Iterable<Category>> findAllCate(){
        List<Category> categories = (List<Category>) categoryService.findAll();
        if(categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<Iterable<Post>> listPostByCate(@PathVariable Long id){
        Optional<Category> category = categoryService.findById(id);
        Iterable<Post> posts = postsService.findAllByCategory(category.get());
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }
}
