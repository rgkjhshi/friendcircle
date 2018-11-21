package com.mk.friendcircle.dao;

import com.mk.friendcircle.entity.UserRelation;

import java.util.List;

/**
 * @author shisong
 * @since 2018-11-21
 */
public interface UserRelationDao {

    /**
     * 添加记录
     *
     * @param userRelation 数据库实体
     * @return 返回受影响的记录条数
     */
    int add(UserRelation userRelation);

    /**
     * 通过主键id更新
     *
     * @param userRelation 数据库实体
     * @return 返回受影响的记录条数
     */
    int updateById(UserRelation userRelation);

    /**
     * 查询一条记录, 自行控制条件保证返回一条记录
     *
     * @param userRelation 实体的非空属性会做为查询条件
     * @return 查询到的结果, 无结果将返回null
     */
    UserRelation queryOne(UserRelation userRelation);

    /**
     * 查询多条记录, 自行控制条件保证返回多条记录
     *
     * @param userRelation 实体的非空属性会作为查询条件
     * @return 查询到的结果, 无结果将返回空List
     */
    List<UserRelation> queryList(UserRelation userRelation);
}
