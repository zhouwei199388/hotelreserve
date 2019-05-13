package com.hotelreserve.mapper;

import com.hotelreserve.model.Order;
import com.hotelreserve.model.OrderExample.Criteria;
import com.hotelreserve.model.OrderExample.Criterion;
import com.hotelreserve.model.OrderExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class OrderSqlProvider {

    public String insertSelective(Order record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("hotel_order");
        
        if (record.getUserid() != null) {
            sql.VALUES("userId", "#{userid,jdbcType=INTEGER}");
        }
        
        if (record.getHotelid() != null) {
            sql.VALUES("hotelId", "#{hotelid,jdbcType=INTEGER}");
        }
        
        if (record.getRoomid() != null) {
            sql.VALUES("roomId", "#{roomid,jdbcType=INTEGER}");
        }
        
        if (record.getAdminid() != null) {
            sql.VALUES("adminId", "#{adminid,jdbcType=INTEGER}");
        }
        
        if (record.getRoomnumber() != null) {
            sql.VALUES("roomNumber", "#{roomnumber,jdbcType=VARCHAR}");
        }
        
        if (record.getTransactionid() != null) {
            sql.VALUES("transactionid", "#{transactionid,jdbcType=VARCHAR}");
        }
        
        if (record.getDays() != null) {
            sql.VALUES("days", "#{days,jdbcType=INTEGER}");
        }
        
        if (record.getOrdernumber() != null) {
            sql.VALUES("orderNumber", "#{ordernumber,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            sql.VALUES("note", "#{note,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomcount() != null) {
            sql.VALUES("roomCount", "#{roomcount,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.VALUES("price", "#{price,jdbcType=DOUBLE}");
        }
        
        if (record.getStartdate() != null) {
            sql.VALUES("startDate", "#{startdate,jdbcType=VARCHAR}");
        }
        
        if (record.getEnddate() != null) {
            sql.VALUES("endDate", "#{enddate,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.VALUES("createTime", "#{createtime,jdbcType=BIGINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(OrderExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("userId");
        sql.SELECT("hotelId");
        sql.SELECT("roomId");
        sql.SELECT("adminId");
        sql.SELECT("roomNumber");
        sql.SELECT("transactionid");
        sql.SELECT("days");
        sql.SELECT("orderNumber");
        sql.SELECT("note");
        sql.SELECT("roomCount");
        sql.SELECT("status");
        sql.SELECT("price");
        sql.SELECT("startDate");
        sql.SELECT("endDate");
        sql.SELECT("createTime");
        sql.FROM("hotel_order");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Order record = (Order) parameter.get("record");
        OrderExample example = (OrderExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("hotel_order");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUserid() != null) {
            sql.SET("userId = #{record.userid,jdbcType=INTEGER}");
        }
        
        if (record.getHotelid() != null) {
            sql.SET("hotelId = #{record.hotelid,jdbcType=INTEGER}");
        }
        
        if (record.getRoomid() != null) {
            sql.SET("roomId = #{record.roomid,jdbcType=INTEGER}");
        }
        
        if (record.getAdminid() != null) {
            sql.SET("adminId = #{record.adminid,jdbcType=INTEGER}");
        }
        
        if (record.getRoomnumber() != null) {
            sql.SET("roomNumber = #{record.roomnumber,jdbcType=VARCHAR}");
        }
        
        if (record.getTransactionid() != null) {
            sql.SET("transactionid = #{record.transactionid,jdbcType=VARCHAR}");
        }
        
        if (record.getDays() != null) {
            sql.SET("days = #{record.days,jdbcType=INTEGER}");
        }
        
        if (record.getOrdernumber() != null) {
            sql.SET("orderNumber = #{record.ordernumber,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            sql.SET("note = #{record.note,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomcount() != null) {
            sql.SET("roomCount = #{record.roomcount,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{record.price,jdbcType=DOUBLE}");
        }
        
        if (record.getStartdate() != null) {
            sql.SET("startDate = #{record.startdate,jdbcType=VARCHAR}");
        }
        
        if (record.getEnddate() != null) {
            sql.SET("endDate = #{record.enddate,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("createTime = #{record.createtime,jdbcType=BIGINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("hotel_order");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("userId = #{record.userid,jdbcType=INTEGER}");
        sql.SET("hotelId = #{record.hotelid,jdbcType=INTEGER}");
        sql.SET("roomId = #{record.roomid,jdbcType=INTEGER}");
        sql.SET("adminId = #{record.adminid,jdbcType=INTEGER}");
        sql.SET("roomNumber = #{record.roomnumber,jdbcType=VARCHAR}");
        sql.SET("transactionid = #{record.transactionid,jdbcType=VARCHAR}");
        sql.SET("days = #{record.days,jdbcType=INTEGER}");
        sql.SET("orderNumber = #{record.ordernumber,jdbcType=VARCHAR}");
        sql.SET("note = #{record.note,jdbcType=VARCHAR}");
        sql.SET("roomCount = #{record.roomcount,jdbcType=INTEGER}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("price = #{record.price,jdbcType=DOUBLE}");
        sql.SET("startDate = #{record.startdate,jdbcType=VARCHAR}");
        sql.SET("endDate = #{record.enddate,jdbcType=VARCHAR}");
        sql.SET("createTime = #{record.createtime,jdbcType=BIGINT}");
        
        OrderExample example = (OrderExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Order record) {
        SQL sql = new SQL();
        sql.UPDATE("hotel_order");
        
        if (record.getUserid() != null) {
            sql.SET("userId = #{userid,jdbcType=INTEGER}");
        }
        
        if (record.getHotelid() != null) {
            sql.SET("hotelId = #{hotelid,jdbcType=INTEGER}");
        }
        
        if (record.getRoomid() != null) {
            sql.SET("roomId = #{roomid,jdbcType=INTEGER}");
        }
        
        if (record.getAdminid() != null) {
            sql.SET("adminId = #{adminid,jdbcType=INTEGER}");
        }
        
        if (record.getRoomnumber() != null) {
            sql.SET("roomNumber = #{roomnumber,jdbcType=VARCHAR}");
        }
        
        if (record.getTransactionid() != null) {
            sql.SET("transactionid = #{transactionid,jdbcType=VARCHAR}");
        }
        
        if (record.getDays() != null) {
            sql.SET("days = #{days,jdbcType=INTEGER}");
        }
        
        if (record.getOrdernumber() != null) {
            sql.SET("orderNumber = #{ordernumber,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            sql.SET("note = #{note,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomcount() != null) {
            sql.SET("roomCount = #{roomcount,jdbcType=INTEGER}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getPrice() != null) {
            sql.SET("price = #{price,jdbcType=DOUBLE}");
        }
        
        if (record.getStartdate() != null) {
            sql.SET("startDate = #{startdate,jdbcType=VARCHAR}");
        }
        
        if (record.getEnddate() != null) {
            sql.SET("endDate = #{enddate,jdbcType=VARCHAR}");
        }
        
        if (record.getCreatetime() != null) {
            sql.SET("createTime = #{createtime,jdbcType=BIGINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, OrderExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}