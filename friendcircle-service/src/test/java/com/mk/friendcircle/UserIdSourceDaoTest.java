package com.mk.friendcircle;

import com.mk.friendcircle.dao.entity.UserIdSource;
import com.mk.friendcircle.dao.mapper.UserIdSourceDao;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author shisong02
 * @since 2018-11-21
 */
public class UserIdSourceDaoTest extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(UserIdSourceDaoTest.class);

    @Resource
    private UserIdSourceDao userIdSourceDao;

    @Test
    public void add() {
        UserIdSource userIdSource = new UserIdSource();
        userIdSourceDao.add(userIdSource);
        logger.info("userIdSource={}", userIdSource);
    }
}