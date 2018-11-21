package com.mk.friendcircle.entity;

import java.util.Date;

/**
 * 圈子内容
 *
 * @author shisong
 * @since 2018-11-21
 */
public class CircleArticle {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 朋友圈文字
     */
    private String content;

    /**
     * 朋友圈图片,json
     */
    private String picture;

    /**
     * 分享内容,json
     */
    private String shared;

    /**
     * 位置
     */
    private String location;

    /**
     * 文章状态,0:正常,1:已删除
     */
    private Integer articleStatus;

    /**
     * 创建时间
     */
    private Date createTime;

}
