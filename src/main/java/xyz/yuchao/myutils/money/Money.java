package xyz.yuchao.myutils.money;

import xyz.yuchao.myutils.money.constant.MoneyUnit;

import java.math.BigDecimal;

/**
 * @Author:yc
 * @Date:2021/2/25 10:52
 * 钱抽象
 */
public class Money {

    /**
     * 价值 单位为该国主币
     */
    private BigDecimal moneyValue;

    /**
     * 货币单位 默认人民币元
     */
    private MoneyUnit moneyUnit=MoneyUnit.CHINESE_YUAN;


    public void toUnit(String unit){
        this.moneyValue=this.moneyValue.multiply(new BigDecimal(unit));
    }


    public Money(String value){
        this.moneyValue=new BigDecimal(value);
    }

    public Money(BigDecimal moneyValue){
        this.moneyValue=moneyValue;
    }
    public Money add(String value){
        return add(new BigDecimal(value));
    }
    public Money add(Money value){
        return add(value.moneyValue);
    }
    public Money add(BigDecimal value){
        return new Money(this.moneyValue.add(value));
    }
    public Money subtract(String value){
        return subtract(new BigDecimal(value));
    }
    public Money subtract(Money value){
        return subtract(value.moneyValue);
    }
    public Money subtract(BigDecimal value){
        return new Money(this.moneyValue.subtract(value));
    }


    /**
     * 单位转换
     * @param unit
     * @return
     */
    public String getUnitValue(MoneyUnit unit){
        return String.valueOf(this.moneyValue.multiply(unit.getUnitValue()));
    }


    @Override
    public String toString(){
        return String.valueOf(moneyValue.multiply(moneyUnit.getUnitValue()));
    }
}
