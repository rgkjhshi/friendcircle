package com.mk.friendcircle.dao.mapper;

import com.mk.friendcircle.dao.entity.UserIdSource;
import org.apache.ibatis.annotations.Mapper;

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
    int add(UserIdSource userIdSource);

    /**
     * 查询一条记录, 自行控制条件保证返回一条记录
     *
     * @param userIdSource 实体的非空属性会做为查询条件
     * @return 查询到的结果, 无结果将返回null
     */
    UserIdSource queryOne(UserIdSource userIdSource);
}
