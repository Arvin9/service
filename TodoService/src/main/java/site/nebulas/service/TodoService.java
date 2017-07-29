package site.nebulas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.nebulas.dao.TodoDao;
import site.nebulas.entity.Todo;


/**
 * Created by Administrator on 2016/12/18.
 */
@Service
public class TodoService {
    @Autowired
    private TodoDao todoDao;

    @Transactional
    public void insertTow(){
        Todo todo = new Todo();
        todo.setCreatTime("123");
        todo.setFinishTime("123");
        todo.setState(1);
        todo.setDescription("TODO");
        todoDao.save(todo);
    }
}
