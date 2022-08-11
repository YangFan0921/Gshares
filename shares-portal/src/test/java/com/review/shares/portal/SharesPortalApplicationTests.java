package com.review.shares.portal;

import com.review.shares.portal.mapper.TagMapper;
import com.review.shares.portal.model.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SharesPortalApplicationTests {

    @Test
    void contextLoads() {
        Tag tag = new Tag();
        tag.setName("java");
        System.out.println(tag);
        //tag.record();
    }

    @Autowired(required = false)
    TagMapper tagMapper;
    @Test
    public void run(){
        Tag tag = new Tag();
        tag.setId(21);
        tag.setName("MyBatis Plus");
        tag.setCreateby("admin");
        //tag.setCreatetime("2022-8-9 16:00:00");
        int insert = tagMapper.insert(tag);
        System.out.println("num:"+insert);
        System.out.println("新增完毕");
    }

    @Test
    public void start(){
//        int num = tagMapper.deleteById(21);
//        System.out.println(num);
        System.out.println(tagMapper.selectById(21));
        System.out.println("------------");
        List<Tag> tags = tagMapper.selectList(null);
        for (Tag t : tags){
            System.out.println(t);
        }


    }

}
