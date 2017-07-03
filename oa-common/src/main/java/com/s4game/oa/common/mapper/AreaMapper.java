package com.s4game.oa.common.mapper;

import com.s4game.oa.common.entity.Area;
import java.util.List;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    Area selectByPrimaryKey(Integer id);

    List<Area> selectAll();

    int updateByPrimaryKey(Area record);
}