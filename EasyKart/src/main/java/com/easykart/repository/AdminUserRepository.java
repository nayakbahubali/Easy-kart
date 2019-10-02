package com.easykart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.easykart.entity.AdminUser;

@Repository
public interface AdminUserRepository extends JpaRepository<AdminUser, Long> {

	AdminUser findByMobileNumber(String mobile);

	AdminUser findByAdminNameAndPassword(String adminName, String password);

	AdminUser findByEmailId(String trim);

}
