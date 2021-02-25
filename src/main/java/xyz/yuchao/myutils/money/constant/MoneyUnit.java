package xyz.yuchao.myutils.money.constant;


import java.math.BigDecimal;

/**
 * @Author:yc
 * @Date:2021/2/25 11:22
 */
public enum MoneyUnit {
    /**
     * 元
     */
    CHINESE_YUAN("yuan","1"),
    /**
     * 角
     */
    CHINESE_JIAO("JIAO","10"),
    /**
     * 分
     */
    CHINESE_FEN("FEN","100"),
    ;
    String unitName;
    BigDecimal unitValue;
    MoneyUnit(String unitName,String value){
        this.unitName=unitName;
        this.unitValue=new BigDecimal(value);
    }

    public String getUnitName() {
        return unitName;
    }

    public BigDecimal getUnitValue() {
        return unitValue;
    }
}
