package com.bookmybus.Bookmybus.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class ChangepasswordDTO {

	@NotBlank(message = "Old password should not blank")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Invalid password!")
	private String oldpassword;
	
	@NotBlank(message = "Old password should not blank")
	@Pattern(regexp="((?=.*\\d)(?=.*[a-z])(?=.*[#@$*]).{5,20})",message = "Invalid password!")
	private String newpassword;

	public String getOldpassword() {
		return oldpassword;
	}

	public void setOldpassword(String oldpassword) {
		this.oldpassword = oldpassword;
	}

	public String getNewpassword() {
		return newpassword;
	}

	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}

	@Override
	public String toString() {
		return "ChangepasswordDTO [oldpassword=" + oldpassword + ", newpassword=" + newpassword + "]";
	}
	
	
}
