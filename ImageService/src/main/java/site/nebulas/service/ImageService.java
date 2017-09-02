package site.nebulas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import site.nebulas.dao.ImageDao;
import site.nebulas.entity.Image;
import site.nebulas.util.DateUtil;

import java.util.List;


/**
 * Created by Administrator on 2016/12/18.
 */
@Service
public class ImageService {
    @Autowired
    private ImageDao imageDao;

    /**
     * 添加一条信息
     * 更新时需传入id
     * */
    public Image save(Image image) {
        image.setCreatTime(DateUtil.getTime());
        return imageDao.save(image);
    }

    /**
     * 更新时需传入id
     * */
    public Image update(Image image) {
        return imageDao.save(image);
    }

    /**
     * 根据id查找一条信息
     * */
    public Image findOne(Integer id){
        return imageDao.findOne(id);
    }

    /**
     * 根据名称查找一条信息
     * */
    public Image findByImageName(String imageName){
        return imageDao.findByImageName(imageName);
    }


    /**
     * 查找所有信息
     * */
    public List<Image> findAll() {
        return imageDao.findAll();
    }

    /**
     * 删除一条信息
     * */
    public void delete(Integer id){
        imageDao.delete(id);
    }
}
