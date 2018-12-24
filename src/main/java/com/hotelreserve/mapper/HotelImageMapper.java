package com.hotelreserve.mapper;

import com.hotelreserve.model.HotelImage;
import com.hotelreserve.model.HotelImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
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

public interface HotelImageMapper {
    @DeleteProvider(type=HotelImageSqlProvider.class, method="deleteByExample")
    int deleteByExample(HotelImageExample example);

    @Delete({
        "delete from hotelimage",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hotelimage (hotelId, url, ",
        "name)",
        "values (#{hotelid,jdbcType=INTEGER}, #{url,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(HotelImage record);

    @InsertProvider(type=HotelImageSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(HotelImage record);

    @SelectProvider(type=HotelImageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="hotelId", property="hotelid", jdbcType=JdbcType.INTEGER),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<HotelImage> selectByExample(HotelImageExample example);

    @Select({
        "select",
        "id, hotelId, url, name",
        "from hotelimage",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="hotelId", property="hotelid", jdbcType=JdbcType.INTEGER),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    HotelImage selectByPrimaryKey(Integer id);

    @UpdateProvider(type=HotelImageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") HotelImage record, @Param("example") HotelImageExample example);

    @UpdateProvider(type=HotelImageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") HotelImage record, @Param("example") HotelImageExample example);

    @UpdateProvider(type=HotelImageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HotelImage record);

    @Update({
        "update hotelimage",
        "set hotelId = #{hotelid,jdbcType=INTEGER},",
          "url = #{url,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HotelImage record);
}