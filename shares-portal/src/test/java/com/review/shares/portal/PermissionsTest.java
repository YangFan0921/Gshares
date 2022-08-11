package com.review.shares.portal;

import com.review.shares.portal.mapper.UserMapper;
import com.review.shares.portal.model.Permission;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PermissionsTest {

    @Autowired(required = false)
    UserMapper userMapper;

    @Test
    void getPermissions(){
        //根据用户id查询所有权限
        List<Permission> ps = userMapper.findUserPermissionsByID(11);
        for(Permission p : ps){
            System.out.println(p);
        }
    }

}
