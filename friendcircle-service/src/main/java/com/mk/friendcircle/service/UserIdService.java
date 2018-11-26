package com.mk.friendcircle.service;

import com.mk.friendcircle.dao.entity.UserIdSource;
import com.mk.friendcircle.dao.mapper.UserIdSourceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author shisong02
 * @since 2018-11-26
 */
@Service
public class UserIdService {

    @Resource
    private UserIdSourceMapper userIdSourceMapper;

    /**
     * 生成一个userId
     *
     * @return 返回生成的一个自增的id, 作为userId
     */
    long generateUserId() {
        UserIdSource userIdSource = new UserIdSource();
        userIdSourceMapper.add(userIdSource);
        return userIdSource.getId();
    }

}
