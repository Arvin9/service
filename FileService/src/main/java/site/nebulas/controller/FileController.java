package site.nebulas.controller;

import com.alibaba.fastjson.JSON;
import org.apache.catalina.util.URLEncoder;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import site.nebulas.entity.RetMsg;
import site.nebulas.entity.File;
import site.nebulas.service.FileService;
import site.nebulas.util.UUIDUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 *
 */
@RestController
@RequestMapping(value = "/v1")
public class FileController {
    Log log = LogFactory.getLog(this.getClass());
    private final String fileDir = "F://file//"; // 存储文件路径

    @Autowired
    private FileService fileService;

    /**
     * 根据id获取文件
     * */
    @RequestMapping(value = "/file/{id}" ,method = RequestMethod.GET)
    public void qureyFileById(@PathVariable Integer id, HttpServletResponse response){
        File file = fileService.findOne(id);
        if(null == file) {
            return;
        }
        String fileName = file.getFileName();
        String[] urlFileName = fileName.split("\\.");

        response.setHeader("content-type", "application/octet-stream;charset=UTF-8");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + new URLEncoder().encode(urlFileName[0],"utf-8")+ "." + urlFileName[1]);
        log.info("MY:"+fileName);
        byte[] buff = new byte[1024];
        BufferedInputStream bis = null;
        OutputStream os = null;
        try {
            os = response.getOutputStream();
            bis = new BufferedInputStream(new FileInputStream(new java.io.File(file.getSavePath())));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff, 0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        } catch (IOException e) {
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
    }
    /**
     * 查询文件列表
     * */
    @RequestMapping(value = "/file/list" ,method = RequestMethod.GET)
    public List qureyFileList(){
        return fileService.findAll();
    }
    /**
     * 文件上传
     * */
    @RequestMapping(value = "/file/upload" ,method = RequestMethod.POST)
    public RetMsg saveFile(@RequestParam("file") MultipartFile file, HttpServletRequest req){
        RetMsg retMsg = new RetMsg();
        File newfile = new File();
        retMsg.setRequset("POST /v1/file/upload");

        newfile.setFileName(file.getOriginalFilename());
        newfile.setFileSize(new Long(file.getSize()).toString());

        String uuid = UUIDUtil.getRandomUUID();
        String newFilePath = fileDir + uuid;

        newfile.setSavePath(newFilePath);

        // 判断文件是否为空
        if (!file.isEmpty()) {
            java.io.File tempFile = new java.io.File(newFilePath);
            if (!tempFile.getParentFile().exists()) {
                tempFile.getParentFile().mkdirs();
            }
            try {
                // 转存文件
                file.transferTo(new java.io.File(newFilePath));
                fileService.save(newfile);
                retMsg.setCode(200);
                retMsg.setMsg("文件上传成功!");
                retMsg.setContent(newfile);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else {
            retMsg.setCode(401);
            retMsg.setMsg("文件为空!");
        }
        log.info("saveFile: " + JSON.toJSONString(newfile));
        return retMsg;
    }
}
