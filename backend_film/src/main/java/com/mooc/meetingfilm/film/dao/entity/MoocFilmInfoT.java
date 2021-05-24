package com.mooc.meetingfilm.film.dao.entity;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

import java.io.Serializable;
/**
 * <p>
 * 
 * </p>
 *
 * @author sgaxun
 * @since 2021-05-23
 */
@Data
public class MoocFilmInfoT extends Model<MoocFilmInfoT> {

    private static final long serialVersionUID = 1L;

    private Integer uuid;

    private Integer filmId;

    private String filmEnName;

    private String filmScore;

    private Integer filmScoreNum;

    private Integer filmLength;

    private String biography;

    private Integer directorId;

    private String filmImgs;


    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "MoocFilmInfoT{" +
        ", filmId=" + filmId +
        ", filmEnName=" + filmEnName +
        ", filmScore=" + filmScore +
        ", filmScoreNum=" + filmScoreNum +
        ", filmLength=" + filmLength +
        ", biography=" + biography +
        ", directorId=" + directorId +
        ", filmImgs=" + filmImgs +
        "}";
    }
}
