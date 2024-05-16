package com.julioceno.workshopspringbootmongodb.repositories;

import com.julioceno.workshopspringbootmongodb.domain.Post;
import com.julioceno.workshopspringbootmongodb.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {

}
