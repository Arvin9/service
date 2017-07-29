package site.nebulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.nebulas.service.TodoService;

/**
 * Created by Administrator on 2016/12/17.
 */
@RestController
public class HelloController {
    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String say(){
        todoService.insertTow();
        return "Hello";
    }
}
