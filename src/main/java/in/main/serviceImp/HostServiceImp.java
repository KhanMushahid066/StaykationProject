package in.main.serviceImp;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import in.main.config.SecurityConfig;
import in.main.dtos.HostDto;
import in.main.entities.Host;
import in.main.repo.HostRepo;
import in.main.service.HostService;

@Service
public class HostServiceImp implements HostService {

	@Autowired
	private HostRepo hostRepo;
	
	@Autowired
	private PasswordEncoder encoder;
	@Override
	public Host createHost(HostDto hostdto) {		
	
		

		
		Host host = new Host();
		System.out.println("++++++++++++++++++++++++++ host dto +++++++++++++++++++++++++");
		System.out.println("dto AccountNumber ACNO:  "+ hostdto.getBankAccountNumber());
		System.out.println("dto BankName:  "+hostdto.getBankName());
		System.out.println("dto ContactNumber:  "+hostdto.getContactNumber());
		System.out.println("dto EmailId:  "+hostdto.getEmailId());
		System.out.println("dto getIfscCode:  "+hostdto.getIfscCode());
		System.out.println("dto tUserName:  "+hostdto.getUserName());
		System.out.println("dto Password:  "+hostdto.getPassword());
		
		
		
		
		
		System.out.println("+++++++++++++++++++ setting value to host entity++++++++++++");
		host.setBankAccountNumber(hostdto.getBankAccountNumber());//1
		host.setBankName(hostdto.getBankName());//2
		host.setContactNumber(hostdto.getContactNumber());//3
		host.setEmailId(hostdto.getEmailId());//4
		host.setIfscCode(hostdto.getIfscCode());//5
		host.setUserName(hostdto.getUserName());//6
//		host.setPassword(hostdto.getPassword());//7
		host.setPassword(encoder.encode(hostdto.getPassword()));//7
		host.setAcountCreateDate(new Date());//8
		
		System.out.println("++++++++++++++++++++++++++ host entity +++++++++++++++++++++++++");
		System.out.println("Id: "+host.getHostId());
		System.out.println(" AccountNumber:  "+ host.getBankAccountNumber());
		System.out.println(" BankName:  "+host.getBankName());
		System.out.println(" ContactNumber:  "+host.getContactNumber());
		System.out.println(" EmailId:  "+host.getEmailId());
		System.out.println(" getIfscCode:  "+host.getIfscCode());
		System.out.println(" tUserName:  "+host.getUserName());
		System.out.println(" Password:  "+host.getPassword());
		System.out.println(host.getAcountCreateDate());
		
		
		
//		System.out.println(host.getBankAccountNumber());
//		System.out.println(host.getBankName());
//		System.out.println(host.getContactNumber());
//		System.out.println(host.getEmailId());
//		System.out.println(host.getIfscCode());
//		System.out.println(host.getUserName());
//		System.out.println(host.getPassword());
		
		
		hostRepo.save(host);
		return host;
	}

}
