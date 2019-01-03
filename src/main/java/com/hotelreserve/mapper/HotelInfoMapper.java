package com.hotelreserve.mapper;

import com.hotelreserve.model.HotelInfo;
import com.hotelreserve.model.HotelInfoExample;
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

public interface HotelInfoMapper {
    @Delete({
        "delete from hotelinfo",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hotelinfo (hotelName, hotelAddress, ",
        "phone, facility, ",
        "hotelText, minPrice, ",
        "addressname, latitude, ",
        "longitude)",
        "values (#{hotelname,jdbcType=VARCHAR}, #{hoteladdress,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=VARCHAR}, #{facility,jdbcType=VARCHAR}, ",
        "#{hoteltext,jdbcType=VARCHAR}, #{minprice,jdbcType=DOUBLE}, ",
        "#{addressname,jdbcType=VARCHAR}, #{latitude,jdbcType=DOUBLE}, ",
        "#{longitude,jdbcType=DOUBLE})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(HotelInfo record);

    @InsertProvider(type=HotelInfoSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(HotelInfo record);

    @SelectProvider(type=HotelInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="hotelName", property="hotelname", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotelAddress", property="hoteladdress", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="facility", property="facility", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotelText", property="hoteltext", jdbcType=JdbcType.VARCHAR),
        @Result(column="minPrice", property="minprice", jdbcType=JdbcType.DOUBLE),
        @Result(column="addressname", property="addressname", jdbcType=JdbcType.VARCHAR),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.DOUBLE),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.DOUBLE)
    })
    List<HotelInfo> selectByExample(HotelInfoExample example);

    @Select({
        "select",
        "id, hotelName, hotelAddress, phone, facility, hotelText, minPrice, addressname, ",
        "latitude, longitude",
        "from hotelinfo",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="hotelName", property="hotelname", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotelAddress", property="hoteladdress", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="facility", property="facility", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotelText", property="hoteltext", jdbcType=JdbcType.VARCHAR),
        @Result(column="minPrice", property="minprice", jdbcType=JdbcType.DOUBLE),
        @Result(column="addressname", property="addressname", jdbcType=JdbcType.VARCHAR),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.DOUBLE),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.DOUBLE)
    })
    HotelInfo selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HotelInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HotelInfo record, @Param("example") HotelInfoExample example);

    @UpdateProvider(type=HotelInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HotelInfo record, @Param("example") HotelInfoExample example);

    @UpdateProvider(type=HotelInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HotelInfo record);

    @Update({
        "update hotelinfo",
        "set hotelName = #{hotelname,jdbcType=VARCHAR},",
          "hotelAddress = #{hoteladdress,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "facility = #{facility,jdbcType=VARCHAR},",
          "hotelText = #{hoteltext,jdbcType=VARCHAR},",
          "minPrice = #{minprice,jdbcType=DOUBLE},",
          "addressname = #{addressname,jdbcType=VARCHAR},",
          "latitude = #{latitude,jdbcType=DOUBLE},",
          "longitude = #{longitude,jdbcType=DOUBLE}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HotelInfo record);
}