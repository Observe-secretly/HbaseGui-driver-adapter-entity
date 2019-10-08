package com.lm.hbase.adapter.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * 列族描述信息</br>
 * 已附默认值
 * 
 * @author limin Oct 9, 2019 1:54:31 AM
 */
public class ColumnFamilyDescriptor {

    private Map<ColumnFamilyDescriptorEnum, String> defaultDesc = null;

    public ColumnFamilyDescriptor(){
        defaultDesc = new HashMap<>();
        defaultDesc.put(ColumnFamilyDescriptorEnum.BLOOMFILTER, "ROW");
        defaultDesc.put(ColumnFamilyDescriptorEnum.VERSIONS, "1");
        defaultDesc.put(ColumnFamilyDescriptorEnum.IN_MEMORY, "false");
        defaultDesc.put(ColumnFamilyDescriptorEnum.KEEP_DELETED_CELLS, "FALSE");
        defaultDesc.put(ColumnFamilyDescriptorEnum.DATA_BLOCK_ENCODING, "FAST_DIFF");
        defaultDesc.put(ColumnFamilyDescriptorEnum.TTL, "FOREVER");
        defaultDesc.put(ColumnFamilyDescriptorEnum.COMPRESSION, "GZ");
        defaultDesc.put(ColumnFamilyDescriptorEnum.MIN_VERSIONS, "0");
        defaultDesc.put(ColumnFamilyDescriptorEnum.BLOCKCACHE, "true");
        defaultDesc.put(ColumnFamilyDescriptorEnum.BLOCKSIZE, "65536");
        defaultDesc.put(ColumnFamilyDescriptorEnum.REPLICATION_SCOPE, "0");
    }

    public Map<ColumnFamilyDescriptorEnum, String> getDefaultDesc() {
        return defaultDesc;
    }

    public void setDefaultDesc(Map<ColumnFamilyDescriptorEnum, String> defaultDesc) {
        this.defaultDesc = defaultDesc;
    }

}
