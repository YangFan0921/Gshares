package com.review.shares.portal;

import com.review.shares.portal.mapper.TagMapper;
import com.review.shares.portal.model.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PlusTest {
    @Autowired(required = false)
    TagMapper tagMapper;

    @Test
    void getTag(){
        List<Tag> tags = tagMapper.selectList(null);
        for (Tag t : tags){
            System.out.println(t);
        }
    }

}
