package com.mk.friendcircle.controller;

import com.mk.friendcircle.annotation.Log;
import com.mk.friendcircle.annotation.ThreadRename;
import com.mk.friendcircle.vo.BaseResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author song.shi
 * @since 2018-07-11
 */
@Log
@ThreadRename
@RestController
@RequestMapping(value = "/test/")
public class TestController {
    private static final Logger logger = LoggerFactory.getLogger(TestController.class);

    /**
     * 测试首页
     */
    @RequestMapping(value = "index.htm")
    public BaseResponse home() {
        return BaseResponse.getSuccessResponse("返回中文不乱码");
    }

    /**
     * 测试首页
     */
    @RequestMapping(value = "index.api")
    public BaseResponse api() {
        logger.info("index.api");
        return BaseResponse.getSuccessResponse();
    }

}
