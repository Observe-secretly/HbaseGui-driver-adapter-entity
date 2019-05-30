package com.lm.hbase.adapter;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.lm.hbase.adapter.entity.HBasePageModel;
import com.lm.hbase.adapter.entity.HbaseQualifier;

/**
 * Hbase适配器接口
 * 
 * @author limin May 30, 2019 2:45:42 PM
 */
public interface HbaseAdapterInterface {

    /**
     * 获取适配器版本信息
     * 
     * @return
     */
    public String getVersion();

    /**
     * 初始化Hbase适配器
     * 
     * @param zkPort
     * @param zkQuorum
     * @param hbaseMaster
     * @param znodeParent
     * @throws IOException
     */
    public void init(String zkPort, String zkQuorum, String hbaseMaster, String znodeParent) throws IOException;

    /**
     * 关闭Hbase连接
     * 
     * @throws IOException
     */
    public void close() throws IOException;

    /**
     * 创建表。提供更加高级的功能创建hbase表。
     * 
     * @param tableName 表名
     * @param columnFamilys 列族
     */
    public void createTable(String tableName, byte[][] splitKeys, byte[] startKey, byte[] endKey, int numRegions,
                            ColumnFamilyParam... columnFamilys) throws Exception;

    /**
     * 创建表
     * 
     * @param tableName 表名
     * @param columnFamilys 列族
     */
    public void createTable(String tableName, String... columnFamilys) throws Exception;

    public HBasePageModel scanResultByPageFilter(String tableName, byte[] startRowKey, byte[] endRowKey,
                                                 List<Object> filtersObj, int maxVersions, HBasePageModel pageModel,
                                                 boolean firstPage, Map<String, String> typeMapping) throws Exception;

    /**
     * 删除数据
     * 
     * @param tablename
     * @param rowkey
     */
    public void deleteRow(String tablename, String... rowkey) throws Exception;

    /**
     * 列出所有表名称
     * 
     * @return
     */
    public String[] getListTableNames() throws Exception;

    /**
     * 删除表
     * 
     * @param tablename
     * @throws IOException
     */
    public void dropTable(String tablename) throws Exception;

    /**
     * 清空表
     * 
     * @param tablename
     * @param preserveSplits
     */
    public void truncateTable(String tablename, boolean preserveSplits) throws Exception;

    /**
     * 通过获取表的第一行数据，粗略的确定表的所有修饰列信息
     * 
     * @param tableName
     * @return
     * @throws Exception
     */
    public List<HbaseQualifier> getTableQualifiers(String tableName) throws Exception;

    /**
     * 尝试获取Hbase集群状态信息，通过此方法判定hbase的连接是否有效
     * 
     * @return
     * @throws Exception
     */
    public String getClusterStatus() throws Exception;

    /**
     * 计算表数据总数
     * 
     * @param tablename
     * @return
     */
    public long rowCount(String tableName) throws Exception;

    /**
     * 获取所有的namespace
     * 
     * @return
     * @throws Exception
     */
    public Vector<String> listNameSpace() throws Exception;

    /**
     * 创建命名空间
     * 
     * @param name
     * @throws Exception
     */
    public void createNameSpace(String name) throws Exception;

    /**
     * 删除命名空间
     * 
     * @param name
     * @throws Exception
     */
    public void deleteNameSpace(String name) throws Exception;

}
