package com.mk.friendcircle.dao;

import com.mk.friendcircle.BaseTest;
import com.mk.friendcircle.entity.UserIdSource;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

import static org.junit.Assert.*;

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
        int row = userIdSourceDao.add(userIdSource);
        logger.info("row={}", row);
    }
}