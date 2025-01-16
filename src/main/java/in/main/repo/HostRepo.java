package in.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import in.main.entities.Host;

@Repository
public interface HostRepo extends JpaRepository<Host, Long> {

}
