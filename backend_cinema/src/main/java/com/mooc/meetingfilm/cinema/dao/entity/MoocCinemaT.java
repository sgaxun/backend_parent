package com.mooc.meetingfilm.cinema.dao.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
/**
 * <p>
 * 影院主表
 * </p>
 *
 * @author sgaxun
 * @since 2021-05-25
 */
@Data
public class MoocCinemaT extends Model<MoocCinemaT> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "UUID", type = IdType.AUTO)
    private Integer uuid;

    private String cinemaName;

    private String cinemaPhone;

    private Integer brandId;

    private Integer areaId;

    private String hallIds;

    private String imgAddress;

    private String cinemaAddress;

    private Integer minimumPrice;

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "MoocCinemaT{" +
        ", uuid=" + uuid +
        ", cinemaName=" + cinemaName +
        ", cinemaPhone=" + cinemaPhone +
        ", brandId=" + brandId +
        ", areaId=" + areaId +
        ", hallIds=" + hallIds +
        ", imgAddress=" + imgAddress +
        ", cinemaAddress=" + cinemaAddress +
        ", minimumPrice=" + minimumPrice +
        "}";
    }
}
