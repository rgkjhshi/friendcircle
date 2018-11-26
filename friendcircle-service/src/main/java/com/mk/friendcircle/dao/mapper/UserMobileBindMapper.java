package com.mk.friendcircle.dao.mapper;

import com.mk.friendcircle.dao.entity.UserMobileBind;

import java.util.List;

/**
 * @author shisong
 * @since 2018-11-26
 */
public interface UserMobileBindMapper {

    /**
     * 添加记录
     *
     * @param userMobileBind 数据库实体
     * @return 返回受影响的记录条数
     */
    int add(UserMobileBind userMobileBind);

    /**
     * 通过主键id更新
     *
     * @param userMobileBind 数据库实体
     * @return 返回受影响的记录条数
     */
    int updateById(UserMobileBind userMobileBind);

    /**
     * 查询一条记录, 自行控制条件保证返回一条记录
     *
     * @param userMobileBind 实体的非空属性会做为查询条件
     * @return 查询到的结果, 无结果将返回null
     */
    UserMobileBind queryOne(UserMobileBind userMobileBind);

    /**
     * 查询多条记录, 自行控制条件保证返回多条记录
     *
     * @param userMobileBind 实体的非空属性会作为查询条件
     * @return 查询到的结果, 无结果将返回空List
     */
    List<UserMobileBind> queryList(UserMobileBind userMobileBind);
}
