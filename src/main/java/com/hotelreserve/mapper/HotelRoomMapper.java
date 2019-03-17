package com.hotelreserve.mapper;

import com.hotelreserve.model.HotelRoom;
import com.hotelreserve.model.HotelRoomExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface HotelRoomMapper {
    @Delete({
        "delete from hotelroom",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hotelroom (hotelId, name, ",
        "price, isWindow, ",
        "image)",
        "values (#{hotelid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{price,jdbcType=DOUBLE}, #{iswindow,jdbcType=INTEGER}, ",
        "#{image,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(HotelRoom record);

    @InsertProvider(type=HotelRoomSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(HotelRoom record);

    @SelectProvider(type=HotelRoomSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="hotelId", property="hotelid", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE),
        @Result(column="isWindow", property="iswindow", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR)
    })
    List<HotelRoom> selectByExample(HotelRoomExample example);

    @Select({
        "select",
        "id, hotelId, name, price, isWindow, image",
        "from hotelroom",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="hotelId", property="hotelid", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE),
        @Result(column="isWindow", property="iswindow", jdbcType=JdbcType.INTEGER),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR)
    })
    HotelRoom selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HotelRoomSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HotelRoom record, @Param("example") HotelRoomExample example);

    @UpdateProvider(type=HotelRoomSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HotelRoom record, @Param("example") HotelRoomExample example);

    @UpdateProvider(type=HotelRoomSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HotelRoom record);

    @Update({
        "update hotelroom",
        "set hotelId = #{hotelid,jdbcType=INTEGER},",
          "name = #{name,jdbcType=VARCHAR},",
          "price = #{price,jdbcType=DOUBLE},",
          "isWindow = #{iswindow,jdbcType=INTEGER},",
          "image = #{image,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HotelRoom record);
}