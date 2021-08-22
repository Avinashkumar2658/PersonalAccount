package com.myaccount.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.TableGenerator;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
	@TableGenerator(name = "table-generator", table = "user_ids", pkColumnName = "seq_id", valueColumnName = "seq_value")
	private Long userId;
	@Column(unique = true)
	private String userName;
	private String password;
	@Column(unique = true)
	private String recoveryEmail;
	private String name;
	private String address;
	private Long mobileNo;
	private boolean isAdmin;
	@Lob
	private byte[] profile_photo;
	private float totalAmount;

	public User() {
		userName = new String();
		password = new String();
		recoveryEmail = new String();
		profile_photo = new byte[0];
	}

	public User(Long userId, String userName, String password, String recoveryEmail, String name, String address,
			Long mobileNo) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.recoveryEmail = recoveryEmail;
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
	}

	public User(Long userId, String userName, String password, String recoveryEmail, String name, String address,
			Long mobileNo, boolean isAdmin, float totalAmount) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.recoveryEmail = recoveryEmail;
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.isAdmin = isAdmin;
		this.totalAmount = totalAmount;
	}

	public User(Long userId, String userName, String password, String recoveryEmail, String name, String address,
			Long mobileNo, boolean isAdmin, byte[] profile_photo, float totalAmount) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.recoveryEmail = recoveryEmail;
		this.name = name;
		this.address = address;
		this.mobileNo = mobileNo;
		this.isAdmin = isAdmin;
		this.profile_photo = profile_photo;
		this.totalAmount = totalAmount;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
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

	public String getRecoveryEmail() {
		return recoveryEmail;
	}

	public void setRecoveryEmail(String recoveryEmail) {
		this.recoveryEmail = recoveryEmail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Long getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(Long mobileNo) {
		this.mobileNo = mobileNo;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	public byte[] getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(byte[] profile_photo) {
		this.profile_photo = profile_photo;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", password=" + password + ", recoveryEmail="
				+ recoveryEmail + ", name=" + name + ", address=" + address + ", mobileNo=" + mobileNo + ", isAdmin="
				+ isAdmin + ", totalAmount=" + totalAmount + "]";
	}

}
