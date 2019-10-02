package com.easykart.service;

import com.easykart.commonDTO.CommonDTO;
import com.easykart.requestDTO.AdminUserDTO;

public interface AdminUserService {

	CommonDTO addAdmin(AdminUserDTO adminUserRequest);
	
	CommonDTO signIn(AdminUserDTO adminUserRequest);


}
