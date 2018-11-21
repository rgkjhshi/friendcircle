package com.mk.friendcircle.dao;

import com.mk.friendcircle.entity.UserAppBind;

import java.util.List;

/**
 * @author shisong
 * @since 2018-11-21
 */
public interface UserAppBindDao {

    /**
     * 添加记录
     *
     * @param userAppBind 数据库实体
     * @return 返回受影响的记录条数
     */
    int add(UserAppBind userAppBind);

    /**
     * 通过主键id更新
     *
     * @param userAppBind 数据库实体
     * @return 返回受影响的记录条数
     */
    int updateById(UserAppBind userAppBind);

    /**
     * 查询一条记录, 自行控制条件保证返回一条记录
     *
     * @param userAppBind 实体的非空属性会做为查询条件
     * @return 查询到的结果, 无结果将返回null
     */
    UserAppBind queryOne(UserAppBind userAppBind);

    /**
     * 查询多条记录, 自行控制条件保证返回多条记录
     *
     * @param userAppBind 实体的非空属性会作为查询条件
     * @return 查询到的结果, 无结果将返回空List
     */
    List<UserAppBind> queryList(UserAppBind userAppBind);
}
