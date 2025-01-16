package in.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.main.entities.ImageUpload;

@Repository
public interface ImageUploadRepo extends JpaRepository<ImageUpload, Long> {

}
