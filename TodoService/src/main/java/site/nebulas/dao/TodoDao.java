package site.nebulas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.nebulas.entity.Todo;
import java.util.List;

/**
 * Created by Administrator on 2016/12/18.
 */
public interface TodoDao extends JpaRepository<Todo,Integer>{
    /**
     *  通过用户名来查询
     *  需遵守JPA命名规范
     *  findByUsername(String username)这样默认访问username属性
     *  否则findByUserName(String username)User对象的name属性
     */
    public List<Todo> findById(Integer id);
}
