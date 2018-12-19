package com.hotelreserve.mapper;

import com.hotelreserve.model.RoomImage;
import com.hotelreserve.model.RoomImageExample;
import java.util.List;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RoomImageMapper {
    @DeleteProvider(type=RoomImageSqlProvider.class, method="deleteByExample")
    int deleteByExample(RoomImageExample example);

    @Insert({
        "insert into roomimage (roomId, name, ",
        "imageurl)",
        "values (#{roomid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{imageurl,jdbcType=VARCHAR})"
    })
    int insert(RoomImage record);

    @InsertProvider(type=RoomImageSqlProvider.class, method="insertSelective")
    int insertSelective(RoomImage record);

    @SelectProvider(type=RoomImageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="roomId", property="roomid", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="imageurl", property="imageurl", jdbcType=JdbcType.VARCHAR)
    })
    List<RoomImage> selectByExample(RoomImageExample example);

    @UpdateProvider(type=RoomImageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") RoomImage record, @Param("example") RoomImageExample example);

    @UpdateProvider(type=RoomImageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") RoomImage record, @Param("example") RoomImageExample example);
}