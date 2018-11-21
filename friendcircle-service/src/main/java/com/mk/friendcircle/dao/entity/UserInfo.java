package com.mk.friendcircle.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户基本信息表
 *
 * @author shisong
 * @since 2018-11-21
 */
@Data
public class UserInfo {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户唯一id
     */
    private Long userId;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 账号状态
     */
    private Integer userStatus;

    /**
     * 性别,0:女,1:男
     */
    private Integer gender;

    /**
     * 用户头像
     */
    private String avatarUrl;

    /**
     * 验证后的主手机号
     */
    private String mobile;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
