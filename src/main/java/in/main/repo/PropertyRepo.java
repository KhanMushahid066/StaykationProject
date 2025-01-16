package in.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.main.entities.Property;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Long> {

}
