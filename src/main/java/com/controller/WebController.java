package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.config.MainConfig;
import com.config.MyWebConfig;

/**
 * 用于测试读取默认配置文件或者是自定义配置文件
* @ClassName: WebController
* @Description: TODO(这里用一句话描述这个类的作用)
* @author Mr.Dong
* @date 2017年7月13日 下午6:02:43
 */
@RestController
public class WebController {

	@Autowired
	private MainConfig test;
	
	@Autowired
	private Environment env; 
	
	@Autowired
	private MyWebConfig myWebConfig;
	
    @Value("${test.msg}")
    private String msg;

    @RequestMapping(value = "index", method = RequestMethod.GET)
    public String index() {
    	//默认配置文件读取打印控制台
    	System.out.println(myWebConfig.getName()+"----"+myWebConfig.getAddress()+"---------"+myWebConfig.getAge());
	     return "The Way 1 : " +msg+test.getName()+test.getAge()+"The Way 2 :"+env.getProperty("name")+env.getProperty("age");
    }
}