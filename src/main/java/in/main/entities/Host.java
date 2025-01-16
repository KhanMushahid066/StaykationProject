package in.main.entities;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "host_info")
public class Host {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hostId;

	private String userName;
	private String password; // use bcryption
	private String emailId; // validate emailId
	private String contactNumber; // validate contact number
	private Date acountCreateDate;

	private String bankName;
	private Long bankAccountNumber;
	private String ifscCode;

//	private String addressProof; //use img
//	private String idProof; //use img 
//	private Long userId;
	public Host() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Host(Long hostId, String userName, String password, String emailId, String contactNumber,
			Date acountCreateDate, String bankName, Long bankAccountNumber, String ifscCode) {
		super();
		this.hostId = hostId;
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.acountCreateDate = acountCreateDate;
		this.bankName = bankName;
		this.bankAccountNumber = bankAccountNumber;
		this.ifscCode = ifscCode;
	}

	public Long getHostId() {
		return hostId;
	}

	public void setHostId(Long hostId) {
		this.hostId = hostId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public Date getAcountCreateDate() {
		return acountCreateDate;
	}

	public void setAcountCreateDate(Date acountCreateDate) {
		this.acountCreateDate = acountCreateDate;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public Long getBankAccountNumber() {
		return bankAccountNumber;
	}

	public void setBankAccountNumber(Long bankAccountNumber) {
		this.bankAccountNumber = bankAccountNumber;
	}

	public String getIfscCode() {
		return ifscCode;
	}

	public void setIfscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}

}
