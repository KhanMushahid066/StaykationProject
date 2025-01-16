package in.main.dtos;

public class HostDto {

	private String userName;
	private String password;
	private String emailId;
	private String contactNumber;
	private String bankName;
	private Long bankAccountNumber;
	private String ifscCode;
	
//	private String addressProof;
//	private String idProof;
	
	public HostDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public HostDto(String userName, String password, String emailId, String contactNumber, String bankName,
			Long bankAccountNumber, String ifscCode) {
		super();
		this.userName = userName;
		this.password = password;
		this.emailId = emailId;
		this.contactNumber = contactNumber;
		this.bankName = bankName;
		this.bankAccountNumber = bankAccountNumber;
		this.ifscCode = ifscCode;
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
