package com.review.shares.portal;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.review.shares.portal.mapper.ClassroomMapper;
import com.review.shares.portal.mapper.QuestionMapper;
import com.review.shares.portal.mapper.UserMapper;
import com.review.shares.portal.model.Classroom;
import com.review.shares.portal.model.Question;
import com.review.shares.portal.model.Role;
import com.review.shares.portal.service.IQuestionService;
import com.review.shares.portal.service.IUserService;
import com.review.shares.portal.vo.RegisterVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
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

//    @Autowired
//    IQuestionService questionService;
//    @Test
//    void question(){
//        List<Question> list = questionService.getMyQuestion("st2");
//        for (Question question : list){
//            System.out.println(question);
//        }
//    }

    @Resource
    IQuestionService questionService;
    @Test
    public void count(){
        int count = questionService.countQuestionByUserId(11);
        System.out.println(count);
    }


    @Test
    public void abc(){
        List<Integer> abc = new ArrayList<>();
        for (int i = 0; i < abc.size(); i++) {
            abc.add(1);
            abc.set(1,2);
        }
        abc.add(1);
        System.out.println(abc.size());
    }


    @Resource
    UserMapper userMapper;
    @Test
    void role(){
        List<Role> roles = userMapper.findUserRolesById(3);
        for (Role role : roles) {
            System.out.println(role);
        }
    }

    @Resource
    QuestionMapper questionMapper;
    @Test
    void teacherList(){
        List<Question> list = questionMapper.findTeacherQuestions(3);
        list.forEach(question -> System.out.println(question));
    }


}
