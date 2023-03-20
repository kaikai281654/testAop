package com.kai.aopTest;


import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @RecordOperate(desc = "保存" ,convert = SaveOrderConvert.class)
    public boolean saveOrder(SaveOrder saveOrder) {
        System.out.println("保存订单,"+"订单SaveId:"+saveOrder.getSaveId());
        return true;
    }

    @RecordOperate(desc = "更新",convert = UpdateOrderConvert.class)
    public boolean updateOrder(UpdateOrder updateOrder){
        System.out.println("更新订单,"+"订单UPID:"+updateOrder.getUpId());
        return true;
    }


    @RecordOperate(desc = "测试",convert = TestConverte.class)
    public boolean TestOrder(TestOrder testOrder){
        System.out.println("测试订单,"+"订单UPID:"+testOrder.getTestId());
        return true;
    }



}
