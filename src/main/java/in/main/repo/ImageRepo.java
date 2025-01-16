package in.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.main.entities.Image;

@Repository
public interface ImageRepo extends JpaRepository<Image, Long>{

	
}
