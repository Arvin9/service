package site.nebulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import site.nebulas.entity.Todo;
import site.nebulas.service.TodoService;

/**
 *
 */
@RestController
@RequestMapping(value = "/v1")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @ApiOperation(value = "根据ID获取详情")
    @ApiImplicitParam(name = "id", value = "ToDo的id", required = true, dataType = "Integer")
    @RequestMapping(value = "/todo/{id}" ,method = RequestMethod.GET)
    public Todo qureyTodoById(@PathVariable Integer id){
        return todoService.findOne(id);
    }

    @ApiOperation(value = "插入todo信息")
    @ApiImplicitParam(name = "todo", value = "", required = false, dataType = "Todo")
    @RequestMapping(value = "/todo/save" ,method = RequestMethod.POST)
    public Todo saveTodo(@RequestBody Todo todo){
        return todoService.save(todo);
    }

}
