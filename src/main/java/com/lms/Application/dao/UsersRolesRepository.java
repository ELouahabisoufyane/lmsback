package com.lms.Application.dao;

import com.lms.Application.entities.UsersRoles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface  UsersRolesRepository extends JpaRepository<UsersRoles,Long> {
    @Query("select ur from UsersRoles ur where ur.role.role = :r and ur.user.username = :u")
    public UsersRoles findByRoleAndUser(@Param("r")String role, @Param("u")String username  );

}
