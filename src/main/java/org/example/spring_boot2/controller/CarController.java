package org.example.spring_boot2.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_boot2.bean.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lifei
 */
@Slf4j
@RestController
public class CarController {
    @Resource
    private Car car;

    @RequestMapping("/car")
    public Car handle01() {
        log.info("请求进来了...");
        return car;
    }
}
