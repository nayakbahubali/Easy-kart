package com.easykart.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.easykart.commonDTO.CommonDTO;
import com.easykart.constraint.Create;
import com.easykart.constraint.SignIn;
import com.easykart.requestDTO.AdminUserDTO;
import com.easykart.service.AdminUserService;

import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@Slf4j
@RequestMapping("/admin")
public class AdminUserController {

	@Autowired
	private AdminUserService adminuserService;

	@PostMapping
	public CommonDTO addAdmin(@Validated({ Create.class }) @RequestBody AdminUserDTO adminUserRequest) {
		log.info("add admin in AdminUserController");
		return adminuserService.addAdmin(adminUserRequest);
	}

	@PostMapping(path = "/sign-in")
	public CommonDTO signIn(@Validated({ SignIn.class }) @RequestBody AdminUserDTO adminUserRequest) {
		log.info("signIn in AdminUserController");
		return adminuserService.signIn(adminUserRequest);
	}
}
