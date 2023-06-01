package org.example.example2.controller;

import org.example.example2.mapper.OrderMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Resource
    private OrderMapper orderMapper;

    @RequestMapping(value = "/create/{userId}", method = RequestMethod.GET)
    public void create(@PathVariable("userId") String user_id) {
        orderMapper.insert(user_id, "123", 0);
    }
}
