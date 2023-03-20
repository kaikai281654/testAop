package com.kai.aopTest;

public class TestConverte implements  Convert<TestOrder>{

    @Override
    public OperateLogDo convert(TestOrder testOrder) {
        OperateLogDo operateLogDo = new OperateLogDo();
        operateLogDo.setOrderId(testOrder.getTestId());
        return operateLogDo;
    }
}
