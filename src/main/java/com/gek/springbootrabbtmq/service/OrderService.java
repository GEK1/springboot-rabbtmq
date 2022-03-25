package com.gek.springbootrabbtmq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class OrderService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     *
     * @param userid
     * @param productid
     * @param num
     */
    public  void makeOrder(String userid,String productid,int num){
//        1.根据商品id查询库存是否充足
//        2.保存订单
        String OrderId= UUID.randomUUID().toString();
        System.out.println("订单生成成功:"+OrderId);
//        3.通过MQ来完成消息的分发
//        参数1：交换机 参数2:路由key/queue  参数3：消息内容
        String exchangeName="fanout_order_exchange";
        String routeKey="";
        rabbitTemplate.convertAndSend(exchangeName,routeKey,OrderId);

    }
}
