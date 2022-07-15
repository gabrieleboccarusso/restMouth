package boccarusso.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import boccarusso.repository.AppliedTagRepository;
import boccarusso.table.AppliedTag;

@RestController
public class AppliedTagController {
	private final AppliedTagRepository repository;
	
	AppliedTagController(AppliedTagRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/appliedTag")
	Iterable<AppliedTag> all() {
		return repository.findAll();
	}

}
