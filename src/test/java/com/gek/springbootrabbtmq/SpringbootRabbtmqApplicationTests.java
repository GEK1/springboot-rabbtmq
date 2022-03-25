package com.gek.springbootrabbtmq;

import com.gek.springbootrabbtmq.service.OrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootRabbtmqApplicationTests {
    @Autowired
    private OrderService orderService;
    @Test
    void contextLoads() {
        orderService.makeOrder("1","1",12);
    }

}
