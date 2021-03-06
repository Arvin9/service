package site.nebulas.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import site.nebulas.entity.Image;
import java.util.List;

/**
 * @author caihonghui
 *
 */
public interface ImageDao extends JpaRepository<Image,Integer>{
    /**
     *  通过用户名来查询
     *  需遵守JPA命名规范
     *  findByUsername(String username)这样默认访问username属性
     *  否则findByUserName(String username)User对象的name属性
     */
    List<Image> findByImageCategory(Integer imageCategory);

    Image findByImageName(String imageName);
}
