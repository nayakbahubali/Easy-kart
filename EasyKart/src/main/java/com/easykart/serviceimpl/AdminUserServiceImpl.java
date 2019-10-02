package com.easykart.serviceimpl;

import java.util.Objects;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.easykart.commonDTO.CommonDTO;
import com.easykart.entity.AdminUser;
import com.easykart.exceptions.EasyKartException;
import com.easykart.repository.AdminUserRepository;
import com.easykart.requestDTO.AdminUserDTO;
import com.easykart.service.AdminUserService;
import com.easykart.utils.EntityConventer;
import com.easykart.utils.ResponseUtil;
import com.easykart.utils.ValidationUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
	private AdminUserRepository adminUserRepository;

	@Override
	public CommonDTO addAdmin(AdminUserDTO adminUserRequest) {
		log.info("addAdmin in AdminUserServiceImpl");
		AdminUser user = null;
		try {
			if (Objects.nonNull(adminUserRequest)) {
				if (!ValidationUtil.isValidMobileNumber(adminUserRequest.getMobileNumber())) {
					throw new EasyKartException("please enter a valid mobile number");
				}
				if (!ValidationUtil.isValidEmail(adminUserRequest.getEmailId())) {
					throw new EasyKartException("please enter a valid email");
				}
				if (adminUserRepository.findByEmailId(adminUserRequest.getEmailId().trim()) != null) {
					throw new EasyKartException("User with email already exits.");
				}
				if (adminUserRepository.findByMobileNumber(adminUserRequest.getMobileNumber().trim()) != null) {
					throw new EasyKartException("User with mobile number already exits.");
				}
				user = new AdminUser();
				BeanUtils.copyProperties(adminUserRequest, user);
				user.setIsActive(true);
				user = adminUserRepository.save(user);

			} else {
				log.error("please fill provide fields of user.");
				throw new EasyKartException("Please fill provide fields of user!", HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			log.error("something went wrong there please try again.");
			throw new EasyKartException("Please contact to admin!", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return ResponseUtil.prepareResponse("User added successfully", HttpStatus.OK.value(),
				EntityConventer.adminEntityToDtoConverter(user));
	}

	@Override
	public CommonDTO signIn(AdminUserDTO adminUserRequest) {
		log.info("signIn in AdminUserServiceImpl");
		String adminName = adminUserRequest.getAdminName();
		String password = adminUserRequest.getPassword();
		AdminUser admin = adminUserRepository.findByAdminNameAndPassword(adminName, password);
		if (Objects.nonNull(admin)) {
			if (adminName.equalsIgnoreCase(admin.getAdminName()) && password.equalsIgnoreCase(admin.getPassword())) {
				log.info("Login successfully...");
			} else {
				log.info("something went wrong there please try again.");
				throw new EasyKartException("something went wrong there please try again.", HttpStatus.BAD_REQUEST);
			}
		} else {
			log.info("No adminUser exist with these data or username or password is incorrect");
			throw new EasyKartException("No adminUser exist with these data or username or password is incorrect",
					HttpStatus.NOT_FOUND);
		}
		return ResponseUtil.prepareResponse("signIn successfully", HttpStatus.OK.value(), null);
	}

}