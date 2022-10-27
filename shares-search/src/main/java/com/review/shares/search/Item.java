package com.review.shares.search;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
//对应ES文档的一个对象
//indexName = "item" 对应索引名
//对这个索引进行操作时，如果不存在，则自动创建
@Document(indexName = "items")
public class Item {
    @Id
    private Long id;

    //商品标题
    @Field(type = FieldType.Text,analyzer = "ik_smart",searchAnalyzer = "ik_smart")
    private String title;

    //分类
    @Field(type = FieldType.Keyword)
    private String category;

    //品牌
    @Field(type = FieldType.Keyword)
    private String brand;

    //价格
    @Field(type = FieldType.Double)
    private Double price;

    //图片路径
    @Field(type = FieldType.Keyword,index = false)
    private String image;

}
