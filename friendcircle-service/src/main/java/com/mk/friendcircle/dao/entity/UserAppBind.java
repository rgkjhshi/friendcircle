package com.mk.friendcircle.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 第三方用户绑定表
 *
 * @author shisong
 * @since 2018-11-21
 */
@Data
public class UserAppBind {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 第三方用户id(微信的openid应在此)
     */
    private String openId;

    /**
     * 用户第三方唯一标识，微信unionid，或第三方唯一userid
     */
    private String uniqueId;

    /**
     * 第三方类别, 1:微信
     */
    private Integer appType;

    /**
     * 绑定状态,1:已绑定,2:已解绑
     */
    private Integer bindStatus;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

}
