package com.review.shares.search.repository;

import com.review.shares.search.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

//Item为vo泛型类型
//Long是vo对象的id类型
public interface ItemRepository extends ElasticsearchRepository<Item,Long> {

    //根据title查询匹配的Item
    Iterable<Item> queryItemsByTitleMatches(String title);

    //查询多个结果返回值为Iterable 必须根据要求的语法定义方法名
    //参数根据需要的条件项传入

    //根据title和品牌进行查询
    List<Item> queryItemsByTitleMatchesAndAndBrandMatches(String title,String brand);

    //根据title查询 根据价格升序排序
    List<Item> queryItemsByTitleMatchesOrderByPriceAsc(String title);

    //分页查询
    Page<Item> queryItemsByTitleMatchesOrderByPriceAsc(String title, Pageable pageable);
}
