package boccarusso.controller;

import boccarusso.repository.PostRepository;
import boccarusso.table.Post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

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
}