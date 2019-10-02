package com.easykart.requestDTO;

import javax.validation.constraints.NotEmpty;

import com.easykart.constraint.Create;
import com.easykart.constraint.SignIn;

import lombok.Data;

@Data
public class AdminUserDTO {

	@NotEmpty(groups = { Create.class, SignIn.class })
	private String adminName;

	@NotEmpty(groups = { Create.class })
	private String mobileNumber;

	@NotEmpty(groups = { Create.class })
	private String emailId;

	@NotEmpty(groups = { Create.class, SignIn.class })
	private String password;

	private String confirmPassword;

}
