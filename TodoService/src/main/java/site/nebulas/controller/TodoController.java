package site.nebulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import site.nebulas.entity.Todo;
import site.nebulas.service.TodoService;

import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(value = "/v1")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/todo/{id}" ,method = RequestMethod.GET)
    public Todo qureyTodoById(@PathVariable Integer id){
        return todoService.findOne(id);
    }

    @RequestMapping(value = "/todo/save" ,method = RequestMethod.POST)
    public Todo saveTodo(@RequestBody Todo todo){
        return todoService.save(todo);
    }

    @RequestMapping(value = "/todo/update" ,method = RequestMethod.POST)
    public Todo updateTodo(Todo todo){
        return todoService.update(todo);
    }

    @RequestMapping(value = "/todo/list" ,method = RequestMethod.GET)
    public List<Todo> qureyTodoList(){
        return todoService.findAll();
    }
}
