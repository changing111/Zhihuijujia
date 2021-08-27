/**
 * 
 */
package com.changing1.zhihuijujia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Hospital;

import com.changing1.zhihuijujia.entity.PageBean4VolBook;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.ShopGoods;
import com.changing1.zhihuijujia.entity.VolActivity;
import com.changing1.zhihuijujia.entity.VolBook;
import com.changing1.zhihuijujia.service.AdministratorService;
import com.changing1.zhihuijujia.service.ShopGoodsService;
import com.changing1.zhihuijujia.service.ShopService;
import com.changing1.zhihuijujia.service.VolActivityService;
import com.changing1.zhihuijujia.service.VolBookService;
import com.github.pagehelper.PageHelper;

@RestController
@CrossOrigin
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class VolBookController {
	@Autowired
	private VolBookService volBookService;
	@Autowired
	private VolActivityService volActivityService;
	
	@RequestMapping("/getVolBooksListByCondition")
	public PageBean4VolBook getVolBooksListByCondition(@RequestBody PageBean4VolBook pageBean4VolBook) {
		// TODO Auto-generated method stub
		Integer totalCount = volBookService.getVolBooksListByCondition(pageBean4VolBook.getVolBook()).size();
		PageHelper.startPage(pageBean4VolBook.getCurrentPage(),pageBean4VolBook.getPageSize());
		List<VolBook> volBooksList = volBookService.getVolBooksListByCondition(pageBean4VolBook.getVolBook());
		pageBean4VolBook.setVolBooksList(volBooksList);
		pageBean4VolBook.setTotalCount(totalCount);
		return pageBean4VolBook;
	}
	@RequestMapping("/getVolBooksListByInputLike")
	public PageBean4VolBook getVolBooksListByInputLike(@RequestBody PageBean4VolBook pageBean4VolBook) {
		// TODO Auto-generated method stub
		Integer totalCount = volBookService.getVolBooksListByInputLike(pageBean4VolBook.getInputLike()).size();
		PageHelper.startPage(pageBean4VolBook.getCurrentPage(),pageBean4VolBook.getPageSize());	
		List<VolBook> volBooksList = volBookService.getVolBooksListByInputLike(pageBean4VolBook.getInputLike());
		pageBean4VolBook.setVolBooksList(volBooksList);
		pageBean4VolBook.setTotalCount(totalCount);
		return pageBean4VolBook;
	}
	@RequestMapping("/getVolBooksListByVaIdAndLike") //用vbState代替关键字
	public PageBean4VolBook getVolBooksListByVaIdAndLike(@RequestBody PageBean4VolBook pageBean4VolBook) {
		Integer totalCount = volBookService.getVolBooksListByVaIdAndLike(pageBean4VolBook.getVolBook()).size();
		PageHelper.startPage(pageBean4VolBook.getCurrentPage(),pageBean4VolBook.getPageSize());
		List<VolBook> volBooksList = volBookService.getVolBooksListByVaIdAndLike(pageBean4VolBook.getVolBook());
		pageBean4VolBook.setVolBooksList(volBooksList);
		pageBean4VolBook.setTotalCount(totalCount);
		return pageBean4VolBook;		
	}
	@RequestMapping("/getVolBooksListByVaId")  //暂时不使用关键字搜索
	public PageBean4VolBook getVolBooksListByVaId(@RequestBody PageBean4VolBook pageBean4VolBook) {
		Integer totalCount = volBookService.getVolBooksListByVaId(pageBean4VolBook.getVolBook()).size();
		PageHelper.startPage(pageBean4VolBook.getCurrentPage(),pageBean4VolBook.getPageSize());
		List<VolBook> volBooksList = volBookService.getVolBooksListByVaId(pageBean4VolBook.getVolBook());
		pageBean4VolBook.setVolBooksList(volBooksList);
		pageBean4VolBook.setTotalCount(totalCount);
		return pageBean4VolBook;		
	}
	
	@RequestMapping("/getVolBooksListByVPhoneNum")
	public PageBean4VolBook getVolBooksListByVPhoneNum(@RequestBody PageBean4VolBook pageBean4VolBook) {
		Integer totalCount = volBookService.getVolBooksListByVPhoneNum(pageBean4VolBook.getVolBook()).size();
		PageHelper.startPage(pageBean4VolBook.getCurrentPage(),pageBean4VolBook.getPageSize());
		List<VolBook> volBooksList = volBookService.getVolBooksListByVPhoneNum(pageBean4VolBook.getVolBook());
		pageBean4VolBook.setVolBooksList(volBooksList);
		pageBean4VolBook.setTotalCount(totalCount);
		return pageBean4VolBook;		
	}
	@RequestMapping("/getVolBooksListByVPhoneAndLike") //用vbState代替关键字
	public PageBean4VolBook getVolBooksListByVPhoneAndLike(@RequestBody PageBean4VolBook pageBean4VolBook) {
		Integer totalCount = volBookService.getVolBooksListByVPhoneAndLike(pageBean4VolBook.getVolBook()).size();
		PageHelper.startPage(pageBean4VolBook.getCurrentPage(),pageBean4VolBook.getPageSize());
		List<VolBook> volBooksList = volBookService.getVolBooksListByVPhoneAndLike(pageBean4VolBook.getVolBook());
		pageBean4VolBook.setVolBooksList(volBooksList);
		pageBean4VolBook.setTotalCount(totalCount);
		return pageBean4VolBook;		
	}
	@RequestMapping("/addVolBook")//义工报名活动,同时活动表该项可报人数-1
	public Integer addVolBook(@RequestBody VolBook volBook) {
		// TODO Auto-generated method stub
		if (volBookService.ifExists(volBook)==null) {
			volBook.setVbId(String.valueOf(System.currentTimeMillis()));
			volBook.setVbState("已报名");
			VolActivity volActivity =new VolActivity();
			volActivity.setVaId(volBook.getVbVaId());
			VolActivity volActivity2=volActivityService.getVolActivityByVaId(volActivity);
			Integer remNum =volActivity2.getVaRemNum();
			volActivity2.setVaRemNum(remNum-1);
			Integer integer=volActivityService.updateVolActivityVaRemNum(volActivity2);
			return volBookService.addVolBook(volBook);
		} else {
			return 2;//已报名了该活动，不能报了
		}
		
	}
	
	@RequestMapping("/deleteVolBook")//传入vbvaid和vbid义工取消活动,同时活动表该项可报人数+1
	public Integer deleteVolBook(@RequestBody VolBook volBook) {
		VolActivity volActivity =new VolActivity();
		volActivity.setVaId(volBook.getVbVaId());
		VolActivity volActivity2=volActivityService.getVolActivityByVaId(volActivity);
		Integer remNum =volActivity2.getVaRemNum();
		volActivity2.setVaRemNum(remNum+1);
		Integer integer=volActivityService.updateVolActivityVaRemNum(volActivity2);
		return volBookService.deleteVolBook(volBook);		
	}
	
}
