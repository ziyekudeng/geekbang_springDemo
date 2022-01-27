package com.example.geekbang.spring.class6.example2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: geekbang_springDemo
 * @description: 案例 2：错乱混合同类型增强
 * @author: gao wei
 * @create: 2022-01-26 17:15
 */

@RestController
public class C6E2ElectricController {
    @Autowired
    C6E2ElectricService electricService;

    @RequestMapping(path = "c6/e2/charge", method = RequestMethod.GET)
    public void charge() throws Exception {
        electricService.charge();
    }

    ;
}
