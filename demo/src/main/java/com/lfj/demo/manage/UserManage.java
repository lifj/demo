package com.lfj.demo.manage;

import com.lfj.demo.entity.User;
import com.lfj.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

/**
 * Created by lenovo on 2018/10/24.
 * 不是很规范的写法，偷个懒
 */
@Component
@Transactional
public class UserManage {

    @Autowired
    private UserRepository userRepository;

    //通过主键去查找
    public User findById(Integer id){
        Optional<User> u =userRepository.findById(id);
        return u.get();
    }

    //通过名字去查找
    public List<User> findByName(String name){
        List<User> userList = userRepository.findByName(name);
        return userList;
    }

    //增加用户
    public User addUser(User user) {
        User addUser = userRepository.save(user);
        return addUser;
    }

    //修改用户
    public User updateUser(User user){
        User oldUser = userRepository.getOne(user.getId());
        if(oldUser == null){
            throw new RuntimeException("没有该用户");
        }

        //相当于把user的信息全部修改了。。。哈哈
        user.setId(oldUser.getId());
        return  userRepository.save(user);
    }

    //通过主键去删除
    public void deleteUser(Integer id){
        userRepository.deleteById(id);
    }


}
