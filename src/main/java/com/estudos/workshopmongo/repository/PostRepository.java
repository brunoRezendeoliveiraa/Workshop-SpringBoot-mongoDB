package com.estudos.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.estudos.workshopmongo.domain.Post;

@Repository
//Com isso seremos capazes de realizar o CRUD no mongorepository
public interface PostRepository extends MongoRepository<Post, String> {

	//Função não utilizada por conta do @Query abaixo.
	List<Post> findByTitleContainingIgnoreCase(String text);
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
}
