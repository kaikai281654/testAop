package com.kai.aopTest;

public class SaveOrderConvert implements Convert<SaveOrder>{
    @Override
    public OperateLogDo convert(SaveOrder saveOrder) {
        OperateLogDo operateLogDo=new OperateLogDo();
        operateLogDo.setOrderId(saveOrder.getSaveId());

        return operateLogDo;
    }


}
