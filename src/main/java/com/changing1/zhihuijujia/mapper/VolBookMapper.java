/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Shop;
import com.changing1.zhihuijujia.entity.VolBook;



/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface VolBookMapper {

	/**
	 * @param volBook
	 * @return
	 */
	List<VolBook> getVolBooksListByVaId(VolBook volBook);

	/**
	 * @param volBook
	 * @return
	 */
	List<VolBook> getVolBooksListByVPhoneNum(VolBook volBook);

	/**
	 * @param volBook
	 * @return
	 */
	Integer addVolBook(VolBook volBook);

	/**
	 * @param volBook
	 * @return
	 */
	Integer deleteVolBook(VolBook volBook);

	/**
	 * @param volBook
	 * @return
	 */
	Integer updateVolBookState(VolBook volBook);

	/**
	 * @param inputLike
	 * @return
	 */
	List<VolBook> getVolBooksListByInputLike(@Param("inputLike")String inputLike);

	/**
	 * @param volBook
	 * @return
	 */
	List<VolBook> getVolBooksListByCondition(VolBook volBook);

	/**
	 * @param volBook
	 * @return
	 */
	List<VolBook> getVolBooksListByVaIdAndLike(VolBook volBook);

	/**
	 * @param volBook
	 * @return
	 */
	List<VolBook> getVolBooksListByVPhoneAndLike(VolBook volBook);

	/**
	 * @param volBook
	 * @return
	 */
	VolBook ifExists(VolBook volBook);

}
