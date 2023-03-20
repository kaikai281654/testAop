package com.kai.aopTest;

public class OperateLogDo {
    public Long OrderId;
    public String Desc;
    public String result;

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public Long getOrderId() {
        return OrderId;
    }

    public void setOrderId(Long orderId) {
        OrderId = orderId;
    }

    @Override
    public String toString() {
        return "OperateLogDo{" +
                "OrderId=" + OrderId +
                ", Desc='" + Desc + '\'' +
                ", result='" + result + '\'' +
                '}';
    }
}
