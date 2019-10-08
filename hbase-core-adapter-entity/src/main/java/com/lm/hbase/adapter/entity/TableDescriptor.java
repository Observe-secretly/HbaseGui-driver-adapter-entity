package com.lm.hbase.adapter.entity;

import java.util.List;

/**
 * TableDescriptor描述类
 * 
 * @author limin Oct 9, 2019 2:00:47 AM
 */
public class TableDescriptor {

    /**
     * 表名
     */
    private String                       tableName;

    /**
     * 列族Desc
     */
    private List<ColumnFamilyDescriptor> cfDesc;

    /**
     * 原始HbaseClient返回的String类型表结构
     */
    private String                       hDesc;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnFamilyDescriptor> getCfDesc() {
        return cfDesc;
    }

    public void setCfDesc(List<ColumnFamilyDescriptor> cfDesc) {
        this.cfDesc = cfDesc;
    }

    public String gethDesc() {
        return hDesc;
    }

    public void sethDesc(String hDesc) {
        this.hDesc = hDesc;
    }

    @Override
    public String toString() {
        return gethDesc();
    }

}
