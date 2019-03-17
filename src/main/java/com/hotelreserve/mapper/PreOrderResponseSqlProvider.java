package com.hotelreserve.mapper;

import com.hotelreserve.model.PreOrderResponse;
import com.hotelreserve.model.PreOrderResponseExample.Criteria;
import com.hotelreserve.model.PreOrderResponseExample.Criterion;
import com.hotelreserve.model.PreOrderResponseExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class PreOrderResponseSqlProvider {

    public String deleteByExample(PreOrderResponseExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("preorderresponse");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(PreOrderResponse record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("preorderresponse");
        
        if (record.getOrderid() != null) {
            sql.VALUES("orderId", "#{orderid,jdbcType=INTEGER}");
        }
        
        if (record.getNoncestr() != null) {
            sql.VALUES("noncestr", "#{noncestr,jdbcType=VARCHAR}");
        }
        
        if (record.getPackagestr() != null) {
            sql.VALUES("packagestr", "#{packagestr,jdbcType=VARCHAR}");
        }
        
        if (record.getTimestamap() != null) {
            sql.VALUES("timestamap", "#{timestamap,jdbcType=VARCHAR}");
        }
        
        if (record.getPaysign() != null) {
            sql.VALUES("paysign", "#{paysign,jdbcType=VARCHAR}");
        }
        
        if (record.getAppid() != null) {
            sql.VALUES("appid", "#{appid,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(PreOrderResponseExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("orderId");
        sql.SELECT("noncestr");
        sql.SELECT("packagestr");
        sql.SELECT("timestamap");
        sql.SELECT("paysign");
        sql.SELECT("appid");
        sql.FROM("preorderresponse");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        PreOrderResponse record = (PreOrderResponse) parameter.get("record");
        PreOrderResponseExample example = (PreOrderResponseExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("preorderresponse");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getOrderid() != null) {
            sql.SET("orderId = #{record.orderid,jdbcType=INTEGER}");
        }
        
        if (record.getNoncestr() != null) {
            sql.SET("noncestr = #{record.noncestr,jdbcType=VARCHAR}");
        }
        
        if (record.getPackagestr() != null) {
            sql.SET("packagestr = #{record.packagestr,jdbcType=VARCHAR}");
        }
        
        if (record.getTimestamap() != null) {
            sql.SET("timestamap = #{record.timestamap,jdbcType=VARCHAR}");
        }
        
        if (record.getPaysign() != null) {
            sql.SET("paysign = #{record.paysign,jdbcType=VARCHAR}");
        }
        
        if (record.getAppid() != null) {
            sql.SET("appid = #{record.appid,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("preorderresponse");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("orderId = #{record.orderid,jdbcType=INTEGER}");
        sql.SET("noncestr = #{record.noncestr,jdbcType=VARCHAR}");
        sql.SET("packagestr = #{record.packagestr,jdbcType=VARCHAR}");
        sql.SET("timestamap = #{record.timestamap,jdbcType=VARCHAR}");
        sql.SET("paysign = #{record.paysign,jdbcType=VARCHAR}");
        sql.SET("appid = #{record.appid,jdbcType=VARCHAR}");
        
        PreOrderResponseExample example = (PreOrderResponseExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(PreOrderResponse record) {
        SQL sql = new SQL();
        sql.UPDATE("preorderresponse");
        
        if (record.getOrderid() != null) {
            sql.SET("orderId = #{orderid,jdbcType=INTEGER}");
        }
        
        if (record.getNoncestr() != null) {
            sql.SET("noncestr = #{noncestr,jdbcType=VARCHAR}");
        }
        
        if (record.getPackagestr() != null) {
            sql.SET("packagestr = #{packagestr,jdbcType=VARCHAR}");
        }
        
        if (record.getTimestamap() != null) {
            sql.SET("timestamap = #{timestamap,jdbcType=VARCHAR}");
        }
        
        if (record.getPaysign() != null) {
            sql.SET("paysign = #{paysign,jdbcType=VARCHAR}");
        }
        
        if (record.getAppid() != null) {
            sql.SET("appid = #{appid,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PreOrderResponseExample example, boolean includeExamplePhrase) {
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