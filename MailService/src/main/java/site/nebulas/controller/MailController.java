package site.nebulas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import site.nebulas.entity.Mail;
import site.nebulas.entity.RetMsg;
import site.nebulas.service.SendMailService;
import site.nebulas.util.StringUtil;

/**
 * 邮件服务.
 * @author caihonghui
 */
@RestController
@RequestMapping(value = "/v1/mail")

public class MailController {
  private Logger log = LoggerFactory.getLogger(MailController.class);

  @Autowired
  private SendMailService sendMailService;

  /**
   * 打印post请求.
   * */
  @RequestMapping(value = "/sendSimpleMail" ,method = RequestMethod.POST)
  public RetMsg printByPost(@RequestBody Mail mail) {
    RetMsg retMsg = new RetMsg();
    retMsg.setRequset("/v1/mail/sendSimpleMail");

    if (StringUtil.isNull(mail.getMailTo())) {
      retMsg.setCode(400);
      retMsg.setMsg("参数mailTo不能为空");
      return retMsg;
    }

    if (StringUtil.isNull(mail.getMailSubject())) {
      retMsg.setCode(400);
      retMsg.setMsg("参数mailSubject不能为空");
      return retMsg;
    }

    if (StringUtil.isNull(mail.getMailContent())) {
      retMsg.setCode(400);
      retMsg.setMsg("参数mailContent不能为空");
      return retMsg;
    }

    return sendMailService.sendSimpleMail(mail);
  }
}
