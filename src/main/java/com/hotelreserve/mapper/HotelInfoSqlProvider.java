package com.hotelreserve.mapper;

import com.hotelreserve.model.HotelInfo;
import com.hotelreserve.model.HotelInfoExample.Criteria;
import com.hotelreserve.model.HotelInfoExample.Criterion;
import com.hotelreserve.model.HotelInfoExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class HotelInfoSqlProvider {

    public String insertSelective(HotelInfo record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("hotelinfo");
        
        if (record.getHotelname() != null) {
            sql.VALUES("hotelName", "#{hotelname,jdbcType=VARCHAR}");
        }
        
        if (record.getHoteladdress() != null) {
            sql.VALUES("hotelAddress", "#{hoteladdress,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getFacility() != null) {
            sql.VALUES("facility", "#{facility,jdbcType=VARCHAR}");
        }
        
        if (record.getHoteltext() != null) {
            sql.VALUES("hotelText", "#{hoteltext,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(HotelInfoExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("hotelName");
        sql.SELECT("hotelAddress");
        sql.SELECT("phone");
        sql.SELECT("facility");
        sql.SELECT("hotelText");
        sql.FROM("hotelinfo");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        HotelInfo record = (HotelInfo) parameter.get("record");
        HotelInfoExample example = (HotelInfoExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("hotelinfo");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getHotelname() != null) {
            sql.SET("hotelName = #{record.hotelname,jdbcType=VARCHAR}");
        }
        
        if (record.getHoteladdress() != null) {
            sql.SET("hotelAddress = #{record.hoteladdress,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        }
        
        if (record.getFacility() != null) {
            sql.SET("facility = #{record.facility,jdbcType=VARCHAR}");
        }
        
        if (record.getHoteltext() != null) {
            sql.SET("hotelText = #{record.hoteltext,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("hotelinfo");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("hotelName = #{record.hotelname,jdbcType=VARCHAR}");
        sql.SET("hotelAddress = #{record.hoteladdress,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=VARCHAR}");
        sql.SET("facility = #{record.facility,jdbcType=VARCHAR}");
        sql.SET("hotelText = #{record.hoteltext,jdbcType=VARCHAR}");
        
        HotelInfoExample example = (HotelInfoExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(HotelInfo record) {
        SQL sql = new SQL();
        sql.UPDATE("hotelinfo");
        
        if (record.getHotelname() != null) {
            sql.SET("hotelName = #{hotelname,jdbcType=VARCHAR}");
        }
        
        if (record.getHoteladdress() != null) {
            sql.SET("hotelAddress = #{hoteladdress,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getFacility() != null) {
            sql.SET("facility = #{facility,jdbcType=VARCHAR}");
        }
        
        if (record.getHoteltext() != null) {
            sql.SET("hotelText = #{hoteltext,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, HotelInfoExample example, boolean includeExamplePhrase) {
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