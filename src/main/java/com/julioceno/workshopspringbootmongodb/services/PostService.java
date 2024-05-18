package com.julioceno.workshopspringbootmongodb.services;

import com.julioceno.workshopspringbootmongodb.domain.Post;
import com.julioceno.workshopspringbootmongodb.domain.User;
import com.julioceno.workshopspringbootmongodb.dto.UserDTO;
import com.julioceno.workshopspringbootmongodb.repositories.PostRepository;
import com.julioceno.workshopspringbootmongodb.repositories.UserRepository;
import com.julioceno.workshopspringbootmongodb.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository;

    public Post findById(String id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) {
            throw new ObjectNotFoundException("Post not found");
        }

        return post.get();
    }

    public List<Post> findByTitle(String text) {
        return postRepository.searchTitle(text);
    }

    public List<Post> fullSearch(String text, Date minDate, Date maxDate) {
        maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
        return postRepository.fullSearch(text, minDate, maxDate);
    }
}
