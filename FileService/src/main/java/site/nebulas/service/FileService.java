package site.nebulas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import site.nebulas.dao.FileDao;
import site.nebulas.entity.File;
import site.nebulas.util.DateUtil;

import java.util.List;


/**
 * Created by Administrator on 2016/12/18.
 */
@Service
public class FileService {
    @Autowired
    private FileDao fileDao;

    /**
     * 添加一条信息
     * 更新时需传入id
     * */
    public File save(File file) {
        file.setCreatTime(DateUtil.getTime());
        return fileDao.save(file);
    }

    /**
     * 更新时需传入id
     * */
    public File update(File todo) {
        return fileDao.save(todo);
    }

    /**
     * 查找一条信息
     * */
    public File findOne(Integer id){
        return fileDao.findOne(id);
    }

    /**
     * 查找所有信息
     * */
    public List<File> findAll() {
        return fileDao.findAll();
    }

    /**
     * 删除一条信息
     * */
    public void delete(Integer id){
        fileDao.delete(id);
    }
}
