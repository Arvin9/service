package site.nebulas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import site.nebulas.dao.MailDao;
import site.nebulas.entity.Mail;
import site.nebulas.util.DateUtil;

@Service
public class MailService {
  @Autowired
  private MailDao mailDao;

  /**
   * 添加一条信息
   * 更新时需传入id
   * */
  public Mail save(Mail mail) {
    mail.setCreatTime(DateUtil.getTime());
    return mailDao.save(mail);
  }

  /**
   * 更新时需传入id
   * */
  public Mail update(Mail mail) {
    return mailDao.save(mail);
  }

  /**
   * 查找一条信息
   * */
  public Mail findOne(Integer id){
    return mailDao.findOne(id);
  }

  /**
   * 查找所有信息
   * */
  public List<Mail> findAll() {
    return mailDao.findAll();
  }

  /**
   * 删除一条信息
   * */
  public void delete(Integer id){
    mailDao.delete(id);
  }
}
