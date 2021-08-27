/**
 * 
 */
package com.changing1.zhihuijujia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.changing1.zhihuijujia.entity.Administrator;
import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.VolBook;
import com.changing1.zhihuijujia.mapper.AdministratorMapper;
import com.changing1.zhihuijujia.mapper.ShopMapper;
import com.changing1.zhihuijujia.mapper.VolBookMapper;
@Service
/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
public class VolBookService implements VolBookMapper {
	@Autowired
	VolBookMapper volBookMapper;

	/**
	 * @param volBook 
	 * @return
	 */
	public List<VolBook> getVolBooksListByVaId(VolBook volBook) {
		// TODO Auto-generated method stub
		return volBookMapper.getVolBooksListByVaId(volBook);
	}

	/**
	 * @param volBook 
	 * @return
	 */
	public List<VolBook> getVolBooksListByVPhoneNum(VolBook volBook) {
		// TODO Auto-generated method stub
		return volBookMapper.getVolBooksListByVPhoneNum(volBook);
	}

	/**
	 * @param volBook
	 * @return
	 */
	public Integer addVolBook(VolBook volBook) {
		// TODO Auto-generated method stub
		return volBookMapper.addVolBook(volBook);
	}

	/**
	 * @param volBook
	 * @return
	 */
	public Integer deleteVolBook(VolBook volBook) {
		// TODO Auto-generated method stub
		return volBookMapper.deleteVolBook(volBook);
	}

	/**
	 * @param volBook2
	 */
	public Integer updateVolBookState(VolBook volBook) {
		// TODO Auto-generated method stub
		return volBookMapper.updateVolBookState(volBook);
	}

	/**
	 * @param volBook
	 * @return
	 */
	public List<VolBook> getVolBooksListByCondition(VolBook volBook) {
		// TODO Auto-generated method stub
		return volBookMapper.getVolBooksListByCondition(volBook);
	}

	/**
	 * @param inputLike
	 * @return
	 */
	public List<VolBook> getVolBooksListByInputLike(String inputLike) {
		// TODO Auto-generated method stub
		return volBookMapper.getVolBooksListByInputLike(inputLike);
	}

	/**
	 * @param volBook
	 * @return
	 */
	public List<VolBook> getVolBooksListByVaIdAndLike(VolBook volBook) {
		// TODO Auto-generated method stub
		return volBookMapper.getVolBooksListByVaIdAndLike(volBook);
	}

	/**
	 * @param volBook
	 * @return
	 */
	public List<VolBook> getVolBooksListByVPhoneAndLike(VolBook volBook) {
		// TODO Auto-generated method stub
		return volBookMapper.getVolBooksListByVPhoneAndLike(volBook);
	}

	/**
	 * @param volBook
	 * @return
	 */
	public VolBook ifExists(VolBook volBook) {
		// TODO Auto-generated method stub
		return volBookMapper.ifExists(volBook);
	}

}
