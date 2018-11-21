package com.mk.friendcircle.dao;

import com.mk.friendcircle.entity.UserIdSource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author shisong
 * @since 2018-11-21
 */
@Mapper
public interface UserIdSourceDao {

    /**
     * 添加记录
     *
     * @return 返回受影响的记录条数
     */
    @Select("INSERT INTO user_id_source (id) VALUES (NULL)")
    int add(UserIdSource userIdSource);

    /**
     * 查询一条记录, 自行控制条件保证返回一条记录
     *
     * @param userIdSource 实体的非空属性会做为查询条件
     * @return 查询到的结果, 无结果将返回null
     */
    UserIdSource queryOne(UserIdSource userIdSource);
}
