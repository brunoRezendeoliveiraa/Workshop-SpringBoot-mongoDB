package com.estudos.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.estudos.workshopmongo.domain.Post;

@Repository
//Com isso seremos capazes de realizar o CRUD no mongorepository
public interface PostRepository extends MongoRepository<Post, String> {

}
