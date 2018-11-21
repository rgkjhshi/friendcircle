package com.mk.friendcircle.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 好友关系表
 *
 * @author shisong
 * @since 2018-11-21
 */
@Data
public class UserRelation {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 好友的id
     */
    private Long friendId;

    /**
     * 关系状态,0:未关注,1:已关注,2:已屏蔽,3:已拉黑
     */
    private Integer relationStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
