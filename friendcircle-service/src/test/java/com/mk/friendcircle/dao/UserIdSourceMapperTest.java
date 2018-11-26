package com.mk.friendcircle.dao;

import com.mk.friendcircle.BaseTest;
import com.mk.friendcircle.dao.entity.UserIdSource;
import com.mk.friendcircle.dao.mapper.UserIdSourceMapper;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author shisong02
 * @since 2018-11-21
 */
public class UserIdSourceMapperTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(UserIdSourceMapperTest.class);

    @Resource
    private UserIdSourceMapper userIdSourceMapper;

    @Test
    public void add() {
        UserIdSource userIdSource = new UserIdSource();
        userIdSourceMapper.add(userIdSource);
        logger.info("userIdSource={}", userIdSource);
    }
}