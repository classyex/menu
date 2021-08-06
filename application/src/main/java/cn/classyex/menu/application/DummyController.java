package cn.classyex.menu.application;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 初始测试类
 * @author yex <br>
 * @version 1.0 <br>
 * @date 2021/8/4 15:09 <br>
 */
@RestController
public class DummyController {

    @GetMapping
    public String hello() {
        return "hello";
    }

}
