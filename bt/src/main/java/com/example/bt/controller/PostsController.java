package com.example.bt.controller;
import com.example.bt.model.Category;
import com.example.bt.model.Post;
import com.example.bt.service.category.ICategoryService;
import com.example.bt.service.posts.IPostsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/posts")
public class PostsController {
    @Autowired
    private IPostsService postsService;
    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("category")
    public Iterable<Category>findAllCategory(){
        return categoryService.findAll();
    }

    @GetMapping()
    public ResponseEntity<Iterable<Post>> findAllPost(){
        List<Post> posts = (List<Post>) postsService.findAll();
        if(posts.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> findPostById(@PathVariable Long id){
        Optional<Post>post = postsService.findById(id);
        if(!post.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(post.get(), HttpStatus.OK);
    }

    @PostMapping("/savePost")
    public ResponseEntity<Post> savePost(@RequestBody Post post){
        return new ResponseEntity<>(postsService.save(post), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Long id, @RequestBody Post post){
        Optional<Post> post1 = postsService.findById(id);
        if(!post1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        post.setpId(post1.get().getpId());
        return new ResponseEntity<>(postsService.save(post), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable Long id){
        Optional<Post> post1 = postsService.findById(id);
        if(!post1.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        postsService.remove(id);
        return new ResponseEntity<>(post1.get(), HttpStatus.NO_CONTENT);
    }
}
