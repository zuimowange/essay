package com.wgg.essay.dao;

import com.wgg.essay.po.User;
import com.wgg.essay.po.UserExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    long countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * 
    * @Title: findByAccount 
    * @Description: 根据账号查找user表 
    * @param    
    * @return User    
    * @throws
     */
	List<User> findByAccount(String account);

	/**
	 * 
	* @Title: reg 
	* @Description: 注册并返回id
	* @param    
	* @return Integer    
	* @throws
	 */
	Integer reg(User po);
}