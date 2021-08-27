/**
 * 
 */
package com.changing1.zhihuijujia.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.changing1.zhihuijujia.entity.Administrator;

/**
 * @author: 陈骏贤
 * @date: 2021年4月8日
 * @version:
 * @Description:
 */
@Repository
public interface AdministratorMapper {
	public Administrator loginAdministrator(Administrator administrator);//登录验证
	
	public Administrator getAuthorityById (@Param ("aId") String aId);//查询管理员权限

	public Integer addAdministrator(Administrator administrator);//添加一个管理员账号

	public Integer deleteAdministrator(Administrator administrator);//删除一个管理员账号

	public Integer updateAdministrator(Administrator administrator);//修改一个管理员账号密码

	public Administrator nameExists(Administrator administrator);//添加一个管理员账号时判断账号名是否存在

	/**
	 * @param inputLike
	 * @return
	 */
	public List<Administrator> getAdministratorsListByInputLike(@Param("inputLike") String inputLike);


}
