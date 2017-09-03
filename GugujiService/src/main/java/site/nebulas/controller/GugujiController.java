package site.nebulas.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.nebulas.entity.RetMsg;
import site.nebulas.util.GugujiUtil;

/**
 * 咕咕鸡.
 * @author caihonghui
 */
@RestController
@RequestMapping(value = "/v1/guguji")
public class GugujiController {
  private Logger log = LoggerFactory.getLogger(GugujiController.class);

  /**
   * 打印get请求.
   * */
  @RequestMapping(value = "/print/{content}" ,method = RequestMethod.GET)
  public RetMsg printbyGet(@PathVariable String content) {
    RetMsg retMsg = new RetMsg();
    retMsg.setRequset("/v1/guguji/print/" + content);

    int printcontentid = GugujiUtil.scripPrint(content);
    int status = GugujiUtil.getPrintStatus(printcontentid);
    if (1 == status) {
      retMsg.setCode(200);
      retMsg.setMsg("打印成功");
    } else {
      retMsg.setCode(202);
      retMsg.setMsg("正在打印");
    }
    return retMsg;
  }

  /**
   * 打印post请求.
   * */
  @RequestMapping(value = "/print" ,method = RequestMethod.POST)
  public RetMsg printByPost(@RequestBody String content) {
    RetMsg retMsg = new RetMsg();
    retMsg.setRequset("/v1/guguji/print");

    int printcontentid = GugujiUtil.scripPrint(content);
    int status = GugujiUtil.getPrintStatus(printcontentid);
    if (1 == status) {
      retMsg.setCode(200);
      retMsg.setMsg("打印成功");
    } else {
      retMsg.setCode(202);
      retMsg.setMsg("正在打印");
    }
    return retMsg;
  }
}
