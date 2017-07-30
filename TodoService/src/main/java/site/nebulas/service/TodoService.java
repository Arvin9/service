package site.nebulas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.nebulas.dao.TodoDao;
import site.nebulas.entity.Todo;
import site.nebulas.util.DateUtil;

import java.util.List;


/**
 * Created by Administrator on 2016/12/18.
 */
@Service
public class TodoService {
    @Autowired
    private TodoDao todoDao;

    /**
     * 添加一条信息
     * 更新时需传入id
     * */
    public Todo save(Todo todo) {
        todo.setCreatTime(DateUtil.getTime());
        return todoDao.save(todo);
    }

    /**
     * 更新时需传入id
     * */
    public Todo update(Todo todo) {
        return todoDao.save(todo);
    }

    /**
     * 查找一条信息
     * */
    public Todo findOne(Integer id){
        return todoDao.findOne(id);
    }

    /**
     * 查找所有信息
     * */
    public List<Todo> findAll() {
        return todoDao.findAll();
    }

    /**
     * 删除一条信息
     * */
    public void delete(Integer id){
        todoDao.delete(id);
    }

    /**
     * 通过状态查询所有信息
     * */
    public List<Todo> findByState(String state) {
        return todoDao.findByState(state);
    }

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
