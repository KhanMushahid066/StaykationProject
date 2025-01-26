package in.main.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.main.dtos.HostDto;
import in.main.entities.Host;
import in.main.service.HostService;

@RestController
@RequestMapping("/apiHost")
public class HostController {

	@Autowired
	private HostService hostService;
	
	@GetMapping("/test")
	public String test() {
		return "all set and every thing works perfetly.";
	}
	
	@PostMapping("/createHost")
	public Host createHost(@RequestBody HostDto hostDto) {
		
//		private String userName;  khan
//		private String password; khan1234
//		private String emailId; khan@gmail.com
//		private String contactNumber; +9199999
//		private String bankName; xyz
//		private Long bankAccountNumber; 12243435342
//		private String ifscCode; hfsc023
		
		return hostService.createHost(hostDto);
	}
}
