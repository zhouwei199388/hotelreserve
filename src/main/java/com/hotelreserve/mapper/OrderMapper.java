package com.hotelreserve.mapper;

import com.hotelreserve.model.Order;
import com.hotelreserve.model.OrderExample;
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

public interface OrderMapper {
    @Delete({
        "delete from hotel_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into hotel_order (orderNumber, roomNumber, ",
        "people, phone, note, ",
        "status, price, startDate, ",
        "endDate, hotel, ",
        "hotelroom, days)",
        "values (#{ordernumber,jdbcType=VARCHAR}, #{roomnumber,jdbcType=INTEGER}, ",
        "#{people,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, #{note,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=INTEGER}, #{price,jdbcType=DOUBLE}, #{startdate,jdbcType=VARCHAR}, ",
        "#{enddate,jdbcType=VARCHAR}, #{hotel,jdbcType=VARCHAR}, ",
        "#{hotelroom,jdbcType=VARCHAR}, #{days,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Order record);

    @InsertProvider(type=OrderSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Order record);

    @SelectProvider(type=OrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="orderNumber", property="ordernumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="roomNumber", property="roomnumber", jdbcType=JdbcType.INTEGER),
        @Result(column="people", property="people", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE),
        @Result(column="startDate", property="startdate", jdbcType=JdbcType.VARCHAR),
        @Result(column="endDate", property="enddate", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotel", property="hotel", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotelroom", property="hotelroom", jdbcType=JdbcType.VARCHAR),
        @Result(column="days", property="days", jdbcType=JdbcType.INTEGER)
    })
    List<Order> selectByExample(OrderExample example);

    @Select({
        "select",
        "id, orderNumber, roomNumber, people, phone, note, status, price, startDate, ",
        "endDate, hotel, hotelroom, days",
        "from hotel_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="orderNumber", property="ordernumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="roomNumber", property="roomnumber", jdbcType=JdbcType.INTEGER),
        @Result(column="people", property="people", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="note", property="note", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="price", property="price", jdbcType=JdbcType.DOUBLE),
        @Result(column="startDate", property="startdate", jdbcType=JdbcType.VARCHAR),
        @Result(column="endDate", property="enddate", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotel", property="hotel", jdbcType=JdbcType.VARCHAR),
        @Result(column="hotelroom", property="hotelroom", jdbcType=JdbcType.VARCHAR),
        @Result(column="days", property="days", jdbcType=JdbcType.INTEGER)
    })
    Order selectByPrimaryKey(Integer id);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    @UpdateProvider(type=OrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Order record);

    @Update({
        "update hotel_order",
        "set orderNumber = #{ordernumber,jdbcType=VARCHAR},",
          "roomNumber = #{roomnumber,jdbcType=INTEGER},",
          "people = #{people,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "note = #{note,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=INTEGER},",
          "price = #{price,jdbcType=DOUBLE},",
          "startDate = #{startdate,jdbcType=VARCHAR},",
          "endDate = #{enddate,jdbcType=VARCHAR},",
          "hotel = #{hotel,jdbcType=VARCHAR},",
          "hotelroom = #{hotelroom,jdbcType=VARCHAR},",
          "days = #{days,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Order record);
}