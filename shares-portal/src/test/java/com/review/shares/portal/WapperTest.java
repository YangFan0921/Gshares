package com.review.shares.portal;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.review.shares.portal.mapper.ClassroomMapper;
import com.review.shares.portal.model.Classroom;
import com.review.shares.portal.model.Question;
import com.review.shares.portal.service.IQuestionService;
import com.review.shares.portal.service.IUserService;
import com.review.shares.portal.vo.RegisterVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class WapperTest {

    @Autowired
    ClassroomMapper classroomMapper;



    @Test
    void find(){
        QueryWrapper<Classroom> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("invite_code","ABC2003-005803");
        System.out.println(classroomMapper.selectOne(queryWrapper));
    }

    @Autowired
    IUserService userService;
    @Test
    void register(){
        RegisterVo registerVo = new RegisterVo();
        registerVo.setPhone("13265498721");
        registerVo.setNickname("阿帆");
        registerVo.setInviteCode("ABC2003-005803");
        registerVo.setPassword("888888");
        userService.registerStudent(registerVo);
        System.out.println("ok!");
    }

    @Autowired
    IQuestionService questionService;
    @Test
    void question(){
        List<Question> list = questionService.getMyQuestion("st2");
        for (Question question : list){
            System.out.println(question);
        }
    }


}
