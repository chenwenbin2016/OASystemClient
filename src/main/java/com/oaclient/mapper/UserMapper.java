package com.oaclient.mapper;

import com.oaclient.entity.login.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    /**
     * 通过手机查询电话
     * @param phone
     * @return
     */
    @Select(value = "select id ,name,phone,password from User where phone=#{phone}")
    public User getUserByPhone(@Param("phone") String phone);

}
