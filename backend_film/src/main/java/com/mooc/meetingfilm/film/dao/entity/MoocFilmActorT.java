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
public class MoocFilmActorT extends Model<MoocFilmActorT> {

    private static final long serialVersionUID = 1L;

    private Integer uuid;

    private Integer filmId;

    private Integer actorId;

    private String roleName;

    @Override
    protected Serializable pkVal() {
        return null;
    }

    @Override
    public String toString() {
        return "MoocFilmActorT{" +
        ", filmId=" + filmId +
        ", actorId=" + actorId +
        ", roleName=" + roleName +
        "}";
    }
}
