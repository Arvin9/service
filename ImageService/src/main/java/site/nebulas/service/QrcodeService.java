package site.nebulas.service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.alibaba.fastjson.JSON;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import site.nebulas.entity.Image;
import site.nebulas.entity.QrCode;
import site.nebulas.entity.RetMsg;
import site.nebulas.util.DateUtil;
import site.nebulas.util.StringUtil;
import site.nebulas.util.UUIDUtil;

@Service
public class QrcodeService {

  @Value("${nebula.qrCodeBasePath}")
  private String QRCODE_BASE_PATH; // 存储文件路径
  @Value("${nebula.qrCodeBaseUrl}")
  private String QRCODE_BASE_URL; // 访问地址

  @Autowired
  private ImageService imageService;

  public RetMsg createQrcode(QrCode qrCode) {
    QRCODE_BASE_PATH = "D:\\file\\code";
    QRCODE_BASE_URL = "http://localhost/v1/image/code";
    RetMsg retMsg = new RetMsg();
    Image image = new Image();
    image.setCreatTime(DateUtil.getTime());
    image.setImageCategory(22);
    if (StringUtil.isNull(qrCode.getContent())) {
      retMsg.setCode(400);
      retMsg.setMsg("内容不能为空!");
      return retMsg;
    }
    if (StringUtil.isIntNull(qrCode.getWidth())) {
      qrCode.setWidth(800);
    }
    if (StringUtil.isIntNull(qrCode.getHeight())) {
      qrCode.setHeight(800);
    }
    if (StringUtil.isNull(qrCode.getFormat())) {
      qrCode.setFormat("png");
    }

    // 定义二维码参数
    HashMap hints = new HashMap();
    hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
    hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.Q);
    hints.put(EncodeHintType.MARGIN, 2);

    try {
      BitMatrix bitMatrix = new MultiFormatWriter().encode(qrCode.getContent(), BarcodeFormat.QR_CODE, qrCode.getWidth(), qrCode.getHeight());
      String filename = UUIDUtil.getRandomUUID();
      String filenamefull = filename + '.' + qrCode.getFormat();
      String savePath = QRCODE_BASE_PATH + File.separator + filenamefull; // 存储路径
      String url = QRCODE_BASE_URL + "/" + filenamefull; // 访问路径

      image.setImageName(filename);
      image.setImagePath(savePath);
      image.setImageUrl(url);

      Path file = new File(savePath).toPath();
      MatrixToImageWriter.writeToPath(bitMatrix, qrCode.getFormat(), file);

      imageService.save(image);
      retMsg.setCode(200);
      retMsg.setMsg("二维码创建成功");
      retMsg.setContent(image);
    } catch (Exception e) {
      retMsg.setCode(400);
      retMsg.setMsg("二维码创建失败");
      e.printStackTrace();
    }
    return retMsg;
  }

  public static void main(String[] args) {
    int width = 300;
    int height = 300;
    String format = "png";
    String content = "http://www.baidu.com";
    QrCode qrCode = new QrCode(content);
    RetMsg retMsg = new QrcodeService().createQrcode(qrCode);
    System.out.println(JSON.toJSONString(retMsg));
  }
}
