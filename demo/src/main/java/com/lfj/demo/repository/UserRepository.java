package com.lfj.demo.repository;

import com.lfj.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by lenovo on 2018/10/24.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByName(String name);
}
