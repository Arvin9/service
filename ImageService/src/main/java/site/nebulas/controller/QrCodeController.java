package site.nebulas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import site.nebulas.entity.QrCode;
import site.nebulas.entity.RetMsg;
import site.nebulas.service.QrcodeService;

/**
 * @author caihonghui
 *  20170902
 */
@RestController
@RequestMapping(value = "/v1/image/code")
@CrossOrigin(origins = "*")
public class QrCodeController {

  @Autowired
  private QrcodeService qrcodeService;

  @RequestMapping(value = "/{content}" ,method = RequestMethod.GET)
  public RetMsg createCode (@PathVariable String content) {
    QrCode qrCode = new QrCode();
    qrCode.setContent(content);
    return qrcodeService.createQrcode(qrCode);
  }

  @RequestMapping(value = "/" ,method = RequestMethod.POST)
  public RetMsg createCodeByPost (@RequestBody QrCode qrCode) {
    return qrcodeService.createQrcode(qrCode);
  }
}
