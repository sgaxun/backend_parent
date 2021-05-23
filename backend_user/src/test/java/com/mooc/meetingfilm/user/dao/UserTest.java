package com.mooc.meetingfilm.user.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.BackendUserApplicationTests;
import com.mooc.meetingfilm.user.dao.entity.MoocBackendUserT;
import com.mooc.meetingfilm.user.dao.mapper.MoocBackendUserTMapper;
import com.mooc.meetingfilm.utils.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author sgaxun
 * @date Created in 2021/5/20 21:52
 * @description TODO
 */
@Slf4j
public class UserTest extends BackendUserApplicationTests {

    @Resource
    private MoocBackendUserTMapper moocBackendUserTMapper;

    @Test
    public void add(){
        MoocBackendUserT user = new MoocBackendUserT();
        user.setUserName("admin");
        user.setUserPwd(MD5Util.encrypt("admin123"));
        user.setUserPhone("18103820835");

        moocBackendUserTMapper.insert(user);
    }

    @Test
    public void select(){
        List<MoocBackendUserT> user = moocBackendUserTMapper.selectList(null);
        user.stream().forEach(
                System.out::println
        );
    }

    @Test
    public void selectByPage(){
        Page<MoocBackendUserT> page = new Page<>(1, 3);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.like("user_name", "sgaxun");

        IPage<MoocBackendUserT> iPage = moocBackendUserTMapper.selectPage(page, wrapper);
        iPage.getRecords().stream().forEach(
                System.out::println
        );
    }
}
