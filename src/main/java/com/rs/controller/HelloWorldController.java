package com.rs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
 
/**
 * <b>function:</b> FreeMarker示例控制器
 * @author hoojo
 * @createDate 2011-3-3 下午04:50:10
 * @file HelloWorldController.java
 * @package com.hoo.controller
 * @project SpringFreemarker
 * @version 1.0
 */
@Controller
@RequestMapping("/freeMarker")
public class HelloWorldController {
    
    @RequestMapping("/hello")
    public String sayHello(ModelMap map) {
        System.out.println("say Hello ……");
        map.addAttribute("name", " World!");
        return "/hello.ftl";
    }
    
    @RequestMapping("/hi")
    public String sayHi(ModelMap map) {
        System.out.println("say hi ……");
        map.put("name", "jojo");
        return "/hi.ftl";
    }
    
    @RequestMapping("/jsp")
    public String jspRequest(ModelMap map) {
        System.out.println("jspRequest ……");
        map.put("name", "jsp");
        
        return "/temp.jsp";
    }
}