package com.lm.hbase.adapter;

import java.util.List;

public interface FilterFactoryInterface {

    /**
     * 获取所有的过滤器类型
     * 
     * @return
     */
    public List<Class> getAllComparatorClass();

    /**
     * 获取操作符<br>
     * 在createSingleColumnValueFilter方法中，需要把getCompareOpSimpleList返回的操作符转换成CompareOp对象(如果它在其他版本还存在的话)
     * 
     * @return
     */
    public List<String> getCompareOpSimpleList();

    public Object createRowkeyPrefixFilter(byte[] rowkey);

    /**
     * @param family
     * @param qualifier
     * @param compareOpSimple
     * @param fieldType 参考解析写法<br>
     * <p>
     * private byte[] filedValue(String type, String v) { try {<br>
     * &nbsp;switch (type.toLowerCase()) {<br>
     * &nbsp;&nbsp;case "string":<br>
     * &nbsp;return Bytes.toBytes(v);<br>
     * &nbsp;case "int":<br>
     * &nbsp;&nbsp;return Bytes.toBytes(Integer.parseInt(v));<br>
     * &nbsp;case "short":<br>
     * &nbsp;&nbsp;return Bytes.toBytes(Short.parseShort(v));<br>
     * &nbsp;case "long":<br>
     * &nbsp;&nbsp;return Bytes.toBytes(Long.parseLong(v));<br>
     * &nbsp;case "float":<br>
     * &nbsp;&nbsp;return Bytes.toBytes(Float.parseFloat(v));<br>
     * &nbsp;case "double":<br>
     * &nbsp;&nbsp;return Bytes.toBytes(Double.parseDouble(v));<br>
     * &nbsp;case "bigdecimal":<br>
     * &nbsp;&nbsp;return Bytes.toBytes(new BigDecimal(v));<br>
     * &nbsp;default:<br>
     * &nbsp;&nbsp;return Bytes.toBytes(v);<br>
     * }<br>
     * } catch (Exception e) {<br>
     * return Bytes.toBytes(v);<br>
     * }<br>
     * }<br>
     * </p>
     * @param fieldValue
     * @return
     */
    public Object createSingleColumnValueFilter(byte[] family, byte[] qualifier, String compareOpSimple,
                                                String comparatorClassName, String fieldType, String fieldValue);

}
