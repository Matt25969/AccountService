package com.qa.transfer.DTO;

public class Account {

	private Integer accountID;
	
	private String accountNumber;
	private String firstName;
	private String lastName;
	private String prize;

	public Account() {

	};

	public Integer getAccountID() {
		return accountID;
	}



	public void setAccountID(Integer accountID) {
		this.accountID = accountID;
	}

	
	public String getPrize() {
		return prize;
	}

	public void setPrize(String prize) {
		this.prize = prize;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	@Override
	public String toString() {
		return "Account [accountID=" + accountID + ", accountNumber=" + accountNumber + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", prize=" + prize + "]";
	}

}
