package com.estudos.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.workshopmongo.domain.Post;
import com.estudos.workshopmongo.repository.PostRepository;
import com.estudos.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	// Injeção de dependência automática do spring
	@Autowired
	private PostRepository repo;

	public Post findById(String id) {
		Optional<Post> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado."));
	}

	public List<Post> findByTitle(String text) {
		return repo.searchTitle(text);
	}
	
	public List<Post> fullsearch(String text, Date minDate, Date maxDate){
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repo.fullsearch(text, minDate, maxDate);
	}
}
