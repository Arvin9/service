package site.nebulas.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import site.nebulas.entity.Mail;
import site.nebulas.entity.RetMsg;

@Service
public class SendMailService {
  private Logger log = LoggerFactory.getLogger(SendMailService.class);

  @Value("${nebula.mail.from}")
  private String from;

  @Autowired
  private JavaMailSender javaMailSender;

  @Autowired
  private MailService mailService;

  public RetMsg sendSimpleMail(Mail mail) {
    mail.setMailFrom(from);
    RetMsg retMsg = new RetMsg();
    SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
    simpleMailMessage.setFrom(from);
    simpleMailMessage.setTo(mail.getMailTo());
    simpleMailMessage.setSubject(mail.getMailSubject());
    simpleMailMessage.setText(mail.getMailContent());

    try {
      javaMailSender.send(simpleMailMessage);
      mail.setMailState(1);
      mailService.save(mail);
      retMsg.setCode(200);
      retMsg.setContent(mail);
      retMsg.setMsg("邮件发送成功");
      log.info("邮件发送成功");
    } catch (Exception e) {
      mail.setMailState(0);
      mailService.save(mail);
      retMsg.setCode(999);
      retMsg.setContent(mail);
      retMsg.setMsg("邮件发送失败");
      log.error("邮件发送异常", e);
    }
    return retMsg;
  }
}
