package com.lfj.demo.restcontroller;

import com.lfj.demo.entity.User;
import com.lfj.demo.manage.UserManage;
import com.lfj.demo.model.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by lenovo on 2018/10/24.
 */
@RestController
public class DemoRestController {

    private final Logger logger = LoggerFactory.getLogger(DemoRestController.class);


    @Autowired
    private UserManage userManage;

    /**
     * 通过ID获取某个用户
     * @param id
     * @return
     */
    @GetMapping("/api/demo/findOne")
    public User findById(Integer id){
        User user =  userManage.findById(id);
        return user;
    }

    /**
     * 通过名称查找人
     * @param name
     * @return
     */
    @GetMapping("/api/demo/findByName")
    public List<User> findByUserName(String name){
        List<User> userList = userManage.findByName(name);
        return userList;
    }

    /**
     * 修改人的信息，前端传入的json {'id':'1', 'name':'蜈蚣'}
     * @param userInfo
     * @return
     */
    @PostMapping("/api/demo/modifyUserInfo")
    public User modifyUserInfo(User userInfo){
        User user =  userManage.updateUser(userInfo);
        return user;
    }


    /**
     * 通过ID 去删除 某个
     * @param id
     * @return
     */
    @GetMapping("/api/demo/deleteUer")
    public Result deleteUser(Integer id){
        Result result = new Result(0, "删除成功");

        try{
            userManage.deleteUser(id);
            return result;
        }catch (Exception e){
            logger.error("delete error ：" , e);
            e.printStackTrace();
        }

        return new Result(-1, "删除失败");

    }

    /**
     *  新增一个用户
     * @param user
     * @return
     */
    @PostMapping("/api/demo/addUser")
    public User addUser(User user){
        User addUser = userManage.addUser(user);
        return addUser;
    }




}
