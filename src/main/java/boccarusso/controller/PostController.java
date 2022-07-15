package boccarusso.controller;

import boccarusso.repository.PostRepository;
import boccarusso.table.Post;

import java.util.LinkedList;
import java.util.Optional;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {
	private final PostRepository repository;
	
	PostController(PostRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/posts")
	Iterable<Post> all() {
		return repository.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/posts/maxId")
	Long MaxPostId() {
		return repository.findMaxId();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/posts/between/{end}/{begin}")
	Iterable<Post> postsBetween(@PathVariable int end, @PathVariable int begin) {
		return repository.findByIdBetweenOrderByIdDesc(end, begin);
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/posts/getByTag/{tag}")
	LinkedList<Optional<Post>> name(@PathVariable String tag){
		LinkedList<Optional<Post>> posts = new LinkedList<>();
		Iterable<Integer> ids = repository.getIdsWithTag(tag);
		for(Integer id : ids) {
			Optional<Post> p = repository.findById(id);
			posts.add(p);
		}
		return posts;
	}
}