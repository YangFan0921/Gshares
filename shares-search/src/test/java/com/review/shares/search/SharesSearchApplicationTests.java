package com.review.shares.search;

import com.review.shares.search.repository.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SharesSearchApplicationTests {

	@Resource
	ItemRepository itemRepository;

	@Test
	void contextLoads() {
		Item item = new Item()
				.setId(1l)
				.setTitle("罗基激光无线游戏鼠标")
				.setCategory("数码")
				.setBrand("罗技")
				.setPrice(120.0)
				.setImage("/image/1.jpg");
		itemRepository.save(item);
		System.out.println("OK");
	}

	//新增
	@Test
	void addList(){
		List<Item> items = new ArrayList<>();
		items.add(new Item(2l,"雷蛇机械游戏键盘","数码","雷蛇",225.0,"/image/2.jpg"));
		items.add(new Item(3l,"微软办公静音键盘","数码","雷蛇",337.0,"/image/3.jpg"));
		items.add(new Item(4l,"索尼蓝牙游戏耳机","数码","雷蛇",365.0,"/image/4.jpg"));
		items.add(new Item(5l,"罗技无线机械竞技键盘","数码","雷蛇",125.0,"/image/5.jpg"));
		items.add(new Item(6l,"罗技有线激光鼠标","数码","雷蛇",152.0,"/image/6.jpg"));
		itemRepository.saveAll(items);
		System.out.println("OK");
	}

	@Test
	void getAll(){
		//全查
		//Iterable是List接口的父接口
		Iterable<Item> items = itemRepository.findAll();
		for (Item item : items){
			System.out.println(item);
		}
		System.out.println("----------------------------");
		Optional<Item> optional = itemRepository.findById(3l);
		System.out.println(optional.get());

		//删除
		itemRepository.deleteById(3l);
		//修改使用save方法
	}

	//查询1
	@Test
	void find1(){
		Iterable<Item> items = itemRepository.queryItemsByTitleMatches("游戏");
		for (Item item : items){
			System.out.println(item);
		}
	}

	//查询2
	@Test
	void find2(){
		List<Item> items = itemRepository.queryItemsByTitleMatchesAndAndBrandMatches("鼠标","罗技");
		for (Item item : items){
			System.out.println(item);
		}
	}

	//查询2
	@Test
	void find3(){
		List<Item> items = itemRepository.queryItemsByTitleMatchesOrderByPriceAsc("游戏");
		items.forEach(item -> System.out.println(item));
	}

	//分页
	@Test
	void page(){
		//Page是包含查询结果和分页信息的对象
		//PageRequest.of是一个方法
		//	参数是分页查询的页码和每页条数，注意页码从0开始
		//Pageable是PageRequest.of方法的返回值类型
		Page<Item> page = itemRepository.queryItemsByTitleMatchesOrderByPriceAsc("游戏", PageRequest.of(0,2));
		for (Item item : page){
			System.out.println(item);
		}
	}




}
