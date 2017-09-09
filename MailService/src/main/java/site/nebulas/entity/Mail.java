package site.nebulas.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="mail")
public class Mail {
  @Id
  @GeneratedValue
  private Integer id;

  @Column(length = 128, name = "mail_from")
  private String mailFrom;

  @Column(length = 128, name = "mail_to")
  private String mailTo;

  @Column(length = 64, name = "mail_subject")
  private String mailSubject;

  @Column(length = 1024, name = "mail_content")
  private String mailContent;

  @Column(length = 128, name = "mail_desc")
  private String mailDesc;

  @Column(length = 1, name = "mail_state")
  private Integer mailState; // 邮件发送状态：1、成功 0、失败

  @Column(length = 32, name = "create_time")
  private String creatTime;

  public Mail(String mailTo, String mailSubject, String mailContent) {
    this.mailTo = mailTo;
    this.mailSubject = mailSubject;
    this.mailContent = mailContent;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getMailFrom() {
    return mailFrom;
  }

  public void setMailFrom(String mailFrom) {
    this.mailFrom = mailFrom;
  }

  public String getMailTo() {
    return mailTo;
  }

  public void setMailTo(String mailTo) {
    this.mailTo = mailTo;
  }

  public String getMailDesc() {
    return mailDesc;
  }

  public void setMailDesc(String mailDesc) {
    this.mailDesc = mailDesc;
  }

  public Integer getMailState() {
    return mailState;
  }

  public void setMailState(Integer mailState) {
    this.mailState = mailState;
  }

  public String getCreatTime() {
    return creatTime;
  }

  public void setCreatTime(String creatTime) {
    this.creatTime = creatTime;
  }

  public String getMailSubject() {
    return mailSubject;
  }

  public void setMailSubject(String mailSubject) {
    this.mailSubject = mailSubject;
  }

  public String getMailContent() {
    return mailContent;
  }

  public void setMailContent(String mailContent) {
    this.mailContent = mailContent;
  }
}
