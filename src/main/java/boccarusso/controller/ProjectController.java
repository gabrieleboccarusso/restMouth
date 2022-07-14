package boccarusso.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import boccarusso.repository.ProjectRepository;
import boccarusso.table.Project;

@RestController
public class ProjectController {
	private final ProjectRepository repository;
	ProjectController(ProjectRepository repository) {
		this.repository = repository;
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/projects")
	Iterable<Project> all() {
		return repository.findAll();
	}
	
	@CrossOrigin(origins = "*")
	@GetMapping("/projectsDescending")
	Iterable<Project> allDesc() {
		return repository.findAllByOrderByIdDesc();
	}
}
