package com.lms.Application.dao;
import com.lms.Application.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {

    @Query("select u from User u where u.username = :x")
    public User findByUserName( @Param("x")String username );

    @Query("select u from User u where u.username like :x order by u.username")
    public Page<User> findAllByMotCle(@Param("x")String motCle, Pageable pageable);

    User findByUsernameAndPassword(String username, String password);
}
