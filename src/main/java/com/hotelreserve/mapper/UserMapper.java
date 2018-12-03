package com.hotelreserve.mapper;

import com.hotelreserve.model.User;
import com.hotelreserve.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface UserMapper {
    @Delete({
        "delete from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user (id, openid, ",
        "sessionkey, level, ",
        "phone, name)",
        "values (#{id,jdbcType=INTEGER}, #{openid,jdbcType=VARCHAR}, ",
        "#{sessionkey,jdbcType=VARCHAR}, #{level,jdbcType=INTEGER}, ",
        "#{phone,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR})"
    })
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="sessionkey", property="sessionkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "id, openid, sessionkey, level, phone, name",
        "from user",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="openid", property="openid", jdbcType=JdbcType.VARCHAR),
        @Result(column="sessionkey", property="sessionkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="phone", property="phone", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR)
    })
    User selectByPrimaryKey(Integer id);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update user",
        "set openid = #{openid,jdbcType=VARCHAR},",
          "sessionkey = #{sessionkey,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=INTEGER},",
          "phone = #{phone,jdbcType=VARCHAR},",
          "name = #{name,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}