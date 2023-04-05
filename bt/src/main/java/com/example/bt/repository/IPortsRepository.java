package com.example.bt.repository;

import com.example.bt.model.Category;
import com.example.bt.model.Post;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPortsRepository extends PagingAndSortingRepository<Post, Long> {
    Iterable<Post> findAllByCategory (Category category);
}
