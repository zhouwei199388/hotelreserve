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
        
        if (record.getOrdernumber() != null) {
            sql.VALUES("orderNumber", "#{ordernumber,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomnumber() != null) {
            sql.VALUES("roomNumber", "#{roomnumber,jdbcType=INTEGER}");
        }
        
        if (record.getPeople() != null) {
            sql.VALUES("people", "#{people,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            sql.VALUES("note", "#{note,jdbcType=VARCHAR}");
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
        
        if (record.getHotel() != null) {
            sql.VALUES("hotel", "#{hotel,jdbcType=VARCHAR}");
        }
        
        if (record.getHotelroom() != null) {
            sql.VALUES("hotelroom", "#{hotelroom,jdbcType=VARCHAR}");
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
        sql.SELECT("orderNumber");
        sql.SELECT("roomNumber");
        sql.SELECT("people");
        sql.SELECT("phone");
        sql.SELECT("note");
        sql.SELECT("status");
        sql.SELECT("price");
        sql.SELECT("startDate");
        sql.SELECT("endDate");
        sql.SELECT("hotel");
        sql.SELECT("hotelroom");
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
        
        if (record.getOrdernumber() != null) {
            sql.SET("orderNumber = #{record.ordernumber,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomnumber() != null) {
            sql.SET("roomNumber = #{record.roomnumber,jdbcType=INTEGER}");
        }
        
        if (record.getPeople() != null) {
            sql.SET("people = #{record.people,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            sql.SET("note = #{record.note,jdbcType=VARCHAR}");
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
        
        if (record.getHotel() != null) {
            sql.SET("hotel = #{record.hotel,jdbcType=VARCHAR}");
        }
        
        if (record.getHotelroom() != null) {
            sql.SET("hotelroom = #{record.hotelroom,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("hotel_order");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("userId = #{record.userid,jdbcType=INTEGER}");
        sql.SET("orderNumber = #{record.ordernumber,jdbcType=VARCHAR}");
        sql.SET("roomNumber = #{record.roomnumber,jdbcType=INTEGER}");
        sql.SET("people = #{record.people,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("note = #{record.note,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("price = #{record.price,jdbcType=DOUBLE}");
        sql.SET("startDate = #{record.startdate,jdbcType=VARCHAR}");
        sql.SET("endDate = #{record.enddate,jdbcType=VARCHAR}");
        sql.SET("hotel = #{record.hotel,jdbcType=VARCHAR}");
        sql.SET("hotelroom = #{record.hotelroom,jdbcType=VARCHAR}");
        
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
        
        if (record.getOrdernumber() != null) {
            sql.SET("orderNumber = #{ordernumber,jdbcType=VARCHAR}");
        }
        
        if (record.getRoomnumber() != null) {
            sql.SET("roomNumber = #{roomnumber,jdbcType=INTEGER}");
        }
        
        if (record.getPeople() != null) {
            sql.SET("people = #{people,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getNote() != null) {
            sql.SET("note = #{note,jdbcType=VARCHAR}");
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
        
        if (record.getHotel() != null) {
            sql.SET("hotel = #{hotel,jdbcType=VARCHAR}");
        }
        
        if (record.getHotelroom() != null) {
            sql.SET("hotelroom = #{hotelroom,jdbcType=VARCHAR}");
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