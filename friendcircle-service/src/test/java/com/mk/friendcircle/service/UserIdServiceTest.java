package com.mk.friendcircle.service;

import com.mk.friendcircle.BaseTest;
import com.mk.friendcircle.dao.UserIdSourceMapperTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * @author shisong02
 * @since 2018-11-26
 */
public class UserIdServiceTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(UserIdServiceTest.class);

    @Resource
    private UserIdService userIdService;

    @Test
    public void generateUserId() {
        long userId = userIdService.generateUserId();
        logger.info("userId={}", userId);
    }
}