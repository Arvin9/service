package site.nebulas.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import site.nebulas.entity.Mail;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SendMailServiceTest {
  @Autowired
  private SendMailService sendMailService;

  @Test
  public void simpleMailTest() {
    Mail mail = new Mail("594113869@qq.com", "测试", "你好");
    sendMailService.sendSimpleMail(mail);
  }
}
