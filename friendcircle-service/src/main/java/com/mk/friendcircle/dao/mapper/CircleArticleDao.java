package com.mk.friendcircle.dao.mapper;

import com.mk.friendcircle.dao.entity.CircleArticle;

import java.util.List;

/**
 * @author shisong
 * @since 2018-11-21
 */
public interface CircleArticleDao {

    /**
     * 添加记录
     *
     * @param circleArticle 数据库实体
     * @return 返回受影响的记录条数
     */
    int add(CircleArticle circleArticle);

    /**
     * 通过主键id更新
     *
     * @param circleArticle 数据库实体
     * @return 返回受影响的记录条数
     */
    int updateById(CircleArticle circleArticle);

    /**
     * 查询一条记录, 自行控制条件保证返回一条记录
     *
     * @param circleArticle 实体的非空属性会做为查询条件
     * @return 查询到的结果, 无结果将返回null
     */
    CircleArticle queryOne(CircleArticle circleArticle);

    /**
     * 查询多条记录, 自行控制条件保证返回多条记录
     *
     * @param circleArticle 实体的非空属性会作为查询条件
     * @return 查询到的结果, 无结果将返回空List
     */
    List<CircleArticle> queryList(CircleArticle circleArticle);
}
