package in.main.config;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import in.main.entities.Host;
import in.main.repo.HostRepo;

@Component
public class CutomeUserDetailsService implements UserDetailsService {

	@Autowired
	private HostRepo hostRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Host host = hostRepo.findByName(username);
		return new User(host.getUserName(),host.getPassword(),new ArrayList<>());
	}

}
