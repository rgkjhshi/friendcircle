package com.mk.friendcircle.dao.mapper;

import com.mk.friendcircle.dao.entity.UserIdSource;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author shisong
 * @since 2018-11-21
 */
@Mapper
public interface UserIdSourceMapper {

    /**
     * 添加记录
     *
     * @param userIdSource 参数是为了回填id字段
     * @return 返回受影响的记录条数
     */
    int add(UserIdSource userIdSource);
}
