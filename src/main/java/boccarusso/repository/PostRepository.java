package boccarusso.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import boccarusso.table.Post;

public interface PostRepository extends JpaRepository<Post, Integer>{
	Iterable<Post> findByIdBetweenOrderByIdDesc(int end, int begin);
	
	@Query("SELECT max(id) FROM Post")
	public Long findMaxId();
}
