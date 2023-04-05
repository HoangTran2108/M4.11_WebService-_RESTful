package com.example.bt.service.posts;


import com.example.bt.model.Category;
import com.example.bt.model.Post;
import com.example.bt.repository.IPortsRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PostService implements IPostsService {
    @Autowired
    private IPortsRepository portsRepository;
    @Override
    public Iterable<Post> findAll() {
        return portsRepository.findAll();
    }

    @Override
    public Optional<Post> findById(Long id) {
        return portsRepository.findById(id);
    }

    @Override
    public Post save(Post post) {
        return portsRepository.save(post);
    }

    @Override
    public void remove(Long id) {
        portsRepository.deleteById(id);
    }

    @Override
    public Iterable<Post> findAllByCategory(Category category) {
        return portsRepository.findAllByCategory(category);
    }
}
