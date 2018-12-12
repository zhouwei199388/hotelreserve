package com.hotelreserve.mapper;

import com.hotelreserve.model.Admin;
import com.hotelreserve.model.AdminExample;
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

public interface AdminMapper {
    @Delete({
        "delete from admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into admin (user, password, ",
        "permission)",
        "values (#{user,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{permission,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Admin record);

    @InsertProvider(type=AdminSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Admin record);

    @SelectProvider(type=AdminSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user", property="user", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission", property="permission", jdbcType=JdbcType.INTEGER)
    })
    List<Admin> selectByExample(AdminExample example);

    @Select({
        "select",
        "id, user, password, permission",
        "from admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="user", property="user", jdbcType=JdbcType.VARCHAR),
        @Result(column="password", property="password", jdbcType=JdbcType.VARCHAR),
        @Result(column="permission", property="permission", jdbcType=JdbcType.INTEGER)
    })
    Admin selectByPrimaryKey(Integer id);

    @UpdateProvider(type=AdminSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    @UpdateProvider(type=AdminSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    @UpdateProvider(type=AdminSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Admin record);

    @Update({
        "update admin",
        "set user = #{user,jdbcType=VARCHAR},",
          "password = #{password,jdbcType=VARCHAR},",
          "permission = #{permission,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Admin record);
}