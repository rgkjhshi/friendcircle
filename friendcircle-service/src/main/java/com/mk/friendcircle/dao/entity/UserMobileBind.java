package com.mk.friendcircle.dao.entity;

import lombok.Data;

import java.util.Date;

/**
 * 用户手机绑定表
 *
 * @author shisong
 * @since 2018-11-21
 */
@Data
public class UserMobileBind {

    /**
     * 主键id
     */
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 手机号
     */
    private String address;

    /**
     * 国际区号
     */
    private String countryCode;

    /**
     * 验证码
     */
    private Integer verifyCode;

    /**
     * 验证码发送次数
     */
    private Integer sendTimes;

    /**
     * 0:未绑定,1:已绑定, 2:已解绑
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
