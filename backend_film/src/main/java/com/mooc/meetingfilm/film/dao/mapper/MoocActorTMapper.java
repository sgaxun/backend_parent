package com.mooc.meetingfilm.film.dao.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mooc.meetingfilm.film.controller.vo.DescribeActorsRespVO;
import com.mooc.meetingfilm.film.dao.entity.MoocActorT;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author sgaxun
 * @since 2021-05-23
 */
public interface MoocActorTMapper extends BaseMapper<MoocActorT> {

    IPage<DescribeActorsRespVO> describeActors(Page<DescribeActorsRespVO> page);
}
