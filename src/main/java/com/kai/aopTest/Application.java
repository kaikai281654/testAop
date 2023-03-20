package com.kai.aopTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {
    public static void main(String[] args) {
        new SpringApplication(Application.class).run(args);
    }

    @Autowired
    OrderService orderService;


    @Override
    public void run(String... args) throws Exception {


        SaveOrder saveOrder=new SaveOrder();
        saveOrder.setSaveId(1L);
        orderService.saveOrder(saveOrder);



        UpdateOrder updateOrder=new UpdateOrder();
        updateOrder.setUpId(2L);
        orderService.updateOrder(updateOrder);



        TestOrder testOrder=new TestOrder();
        testOrder.setTestId(3L);
        orderService.TestOrder(testOrder);


    }
}
