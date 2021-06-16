package org.example.spring_boot2.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.spring_boot2.bean.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author lifei
 */
@Slf4j
@RestController
public class PersonController {
    @Resource
    private Person person;

    @RequestMapping("/person")
    public Person handle01() {
        return person;
    }
}
