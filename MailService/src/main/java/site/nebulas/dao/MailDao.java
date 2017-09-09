package site.nebulas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import site.nebulas.entity.Mail;
/**
 * 邮件信息dao层.
 * @author caihonghui
 * @create_time 20170910
 * */
public interface MailDao extends JpaRepository<Mail,Integer> {
  /**
   *  通过用户名来查询
   *  需遵守JPA命名规范
   *  findByUsername(String username)这样默认访问username属性
   *  否则findByUserName(String username)User对象的name属性
   */
  List<Mail> findById(Integer id);
}
