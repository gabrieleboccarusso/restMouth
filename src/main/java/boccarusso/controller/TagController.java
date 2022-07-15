package boccarusso.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import boccarusso.repository.TagRepository;
import boccarusso.table.Tag;

@RestController
public class TagController {
	private final TagRepository repository;
	
	TagController(TagRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/tags")
	Iterable<Tag> all() {
		return repository.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/tags/tagName/{name}")
	Iterable<Tag> findByName(@PathVariable String name) {
		return repository.findByNameLike(name);
	}
}
