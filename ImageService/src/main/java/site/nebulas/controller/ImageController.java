package site.nebulas.controller;

import com.alibaba.fastjson.JSON;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import site.nebulas.entity.RetMsg;
import site.nebulas.entity.Image;
import site.nebulas.service.ImageService;
import site.nebulas.util.FileUtil;
import site.nebulas.util.UUIDUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author caihonghui
 *  20170902
 */
@RestController
@RequestMapping(value = "/v1/image")
public class ImageController {
    Log log = LogFactory.getLog(this.getClass());

    @Value("${nebula.imageBasePath}")
    private String IMAGE_BASE_PATH; // 存储文件路径
    @Value("${nebula.imageBaseUrl}")
    private String IMAGE_BASE_URL; // 访问地址

    @Autowired
    private ImageService imageService;

    /**
     * 根据id获取图片
     * @param id
     * @return image
     * */
    @RequestMapping(value = "/id/{id}" ,method = RequestMethod.GET)
    public RetMsg qureyFileById(@PathVariable Integer id, HttpServletResponse response){
        RetMsg retMsg = new RetMsg();
        Image image = imageService.findOne(id);
        if(null == image) {
            retMsg.setCode(404);
            retMsg.setMsg("找不到该图片!");
            retMsg.setRequset("/v1/image/id" + id);
            return retMsg;
        }
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(image.getImagePath())));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            retMsg.setCode(404);
            retMsg.setMsg("找不到该图片!");
            retMsg.setRequset("/v1/image/id" + id);
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return retMsg;
    }

    /**
     * 根据名称获取图片
     * @param imageName
     * @return image
     * */
    @RequestMapping(value = "/{imageName}" ,method = RequestMethod.GET)
    public RetMsg qureyFileByImageName(@PathVariable String imageName, HttpServletResponse response){
        RetMsg retMsg = new RetMsg();
        Image image = imageService.findByImageName(imageName);
        log.info(imageName);
        log.info(JSON.toJSONString(image));
        if(null == image) {
            retMsg.setCode(404);
            retMsg.setMsg("找不到该图片!");
            retMsg.setRequset("/v1/image/" + imageName);
            return retMsg;
        }
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new File(image.getImagePath())));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
            retMsg.setCode(404);
            retMsg.setMsg("找不到该图片!");
            retMsg.setRequset("/v1/image/" + imageName);
            e.printStackTrace();
        } finally {
            if (bis != null) {
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return retMsg;
    }

    /**
     * 查询文件列表
     * */
    @RequestMapping(value = "/list" ,method = RequestMethod.GET)
    public List qureyFileList(){
        return imageService.findAll();
    }
    /**
     * 图片上传
     * */
    @RequestMapping(value = "/upload" ,method = RequestMethod.POST)
    public RetMsg saveFile(@RequestParam("image") MultipartFile image, HttpServletRequest req){
        RetMsg retMsg = new RetMsg();
        Image newImage = new Image();
        retMsg.setRequset("POST /v1/image/upload");

        String uuid = UUIDUtil.getRandomUUID();

        String imageName = uuid + FileUtil.getExtensionName(image.getOriginalFilename());
        newImage.setImageName(uuid);

        String imagePath = IMAGE_BASE_PATH + File.separator + imageName;
        newImage.setImagePath(imagePath);

        String imageUrl = IMAGE_BASE_URL + uuid;
        newImage.setImageUrl(imageUrl);

        // 判断文件是否为空
        if (!image.isEmpty()) {
            File tempFile = new File(imagePath);
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
            }
            try {
                // 转存文件
                image.transferTo(new java.io.File(imagePath));
                imageService.save(newImage);
                retMsg.setCode(200);
                retMsg.setMsg("图片上传成功!");
                retMsg.setContent(newImage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            retMsg.setCode(401);
            retMsg.setMsg("图片为空!");
        }
        log.info("saveImage: " + JSON.toJSONString(newImage));
        return retMsg;
    }
}
