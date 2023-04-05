package com.example.bt.service.posts;

import com.example.bt.model.Category;
import com.example.bt.model.Post;
import com.example.bt.service.IGeneralService;

public interface IPostsService extends IGeneralService<Post> {
    Iterable<Post> findAllByCategory (Category category);
}
