package com.hotelreserve.mapper;

import com.hotelreserve.model.PreOrderResponse;
import com.hotelreserve.model.PreOrderResponseExample;
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

public interface PreOrderResponseMapper {
    @DeleteProvider(type=PreOrderResponseSqlProvider.class, method="deleteByExample")
    int deleteByExample(PreOrderResponseExample example);

    @Delete({
        "delete from preorderresponse",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into preorderresponse (orderId, noncestr, ",
        "packagestr, timestamap, ",
        "paysign, appid)",
        "values (#{orderid,jdbcType=INTEGER}, #{noncestr,jdbcType=VARCHAR}, ",
        "#{packagestr,jdbcType=VARCHAR}, #{timestamap,jdbcType=VARCHAR}, ",
        "#{paysign,jdbcType=VARCHAR}, #{appid,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(PreOrderResponse record);

    @InsertProvider(type=PreOrderResponseSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(PreOrderResponse record);

    @SelectProvider(type=PreOrderResponseSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="orderId", property="orderid", jdbcType=JdbcType.INTEGER),
        @Result(column="noncestr", property="noncestr", jdbcType=JdbcType.VARCHAR),
        @Result(column="packagestr", property="packagestr", jdbcType=JdbcType.VARCHAR),
        @Result(column="timestamap", property="timestamap", jdbcType=JdbcType.VARCHAR),
        @Result(column="paysign", property="paysign", jdbcType=JdbcType.VARCHAR),
        @Result(column="appid", property="appid", jdbcType=JdbcType.VARCHAR)
    })
    List<PreOrderResponse> selectByExample(PreOrderResponseExample example);

    @Select({
        "select",
        "id, orderId, noncestr, packagestr, timestamap, paysign, appid",
        "from preorderresponse",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="orderId", property="orderid", jdbcType=JdbcType.INTEGER),
        @Result(column="noncestr", property="noncestr", jdbcType=JdbcType.VARCHAR),
        @Result(column="packagestr", property="packagestr", jdbcType=JdbcType.VARCHAR),
        @Result(column="timestamap", property="timestamap", jdbcType=JdbcType.VARCHAR),
        @Result(column="paysign", property="paysign", jdbcType=JdbcType.VARCHAR),
        @Result(column="appid", property="appid", jdbcType=JdbcType.VARCHAR)
    })
    PreOrderResponse selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PreOrderResponseSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PreOrderResponse record, @Param("example") PreOrderResponseExample example);

    @UpdateProvider(type=PreOrderResponseSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PreOrderResponse record, @Param("example") PreOrderResponseExample example);

    @UpdateProvider(type=PreOrderResponseSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PreOrderResponse record);

    @Update({
        "update preorderresponse",
        "set orderId = #{orderid,jdbcType=INTEGER},",
          "noncestr = #{noncestr,jdbcType=VARCHAR},",
          "packagestr = #{packagestr,jdbcType=VARCHAR},",
          "timestamap = #{timestamap,jdbcType=VARCHAR},",
          "paysign = #{paysign,jdbcType=VARCHAR},",
          "appid = #{appid,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PreOrderResponse record);
}