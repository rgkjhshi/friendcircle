package com.mk.friendcircle.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 圈子时间轴
 *
 * @author shisong
 * @since 2018-11-21
 */
@Data
public class CircleTimeline {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 圈子内容表的主键id
     */
    private Long articleId;

    /**
     * 是否是自己的,0:不是,1:是
     */
    private Integer isOwn;

    /**
     * 创建时间
     */
    private Date createTime;

}
