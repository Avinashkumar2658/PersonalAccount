package com.myaccount.daos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.myaccount.entities.User;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
	Optional<User> findByUserName(String userName);
	User findByRecoveryEmailIgnoreCase(String emailId);
	
	@Query("select u.totalAmount from User u where u.userId = ?1")
	List<Object> findTotalAmountByUserId(Long userId);
	
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update User u SET u.totalAmount=:amount WHERE u.userId=:id")
    public void updateAmount(@Param("id") Long id, @Param("amount") float updateAmount);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update User u SET u.profile_photo=:newProfilePhoto WHERE u.userId=:id")
    public void updateProfilePhoto(@Param("id") Long id, @Param("newProfilePhoto") byte[] profilePhoto);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update User u SET u.password=:newPassword WHERE u.userId=:id")
    public void updatePassword(@Param("id") Long id, @Param("newPassword") String password);
	
	
	
	@Query("select u.profile_photo from User u where u.userId = ?1")
	List<Object> findProfile_photoByUserId(Long userId);
	
	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("Update User u SET u.password=:newPassword, u.recoveryEmail=:newRecoveryEmail, u.name=:newName, u.address=:newAddress, u.mobileNo=:newMobileNo WHERE u.userId=:id")
	void updateUser(@Param("newPassword") String password, @Param("newRecoveryEmail") String recoveryEmail, @Param("newName") String name, @Param("newAddress") String address, @Param("newMobileNo") Long mobileNo, @Param("id") Long id);
}
