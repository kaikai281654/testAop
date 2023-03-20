package com.kai.aopTest;

public class UpdateOrderConvert implements Convert<UpdateOrder>{
    @Override
    public OperateLogDo convert(UpdateOrder updateOrder) {

        OperateLogDo operateLogDo=new OperateLogDo();
        operateLogDo.setOrderId(updateOrder.getUpId());

        return operateLogDo;
    }
}
