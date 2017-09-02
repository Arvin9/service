package site.nebulas.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/29.
 */
@Entity
@Table(name="image")
public class Image {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 64, name = "image_name")
    private String imageName;

    @Column(length = 128, name = "image_url")
    private String imageUrl;

    @Column(length = 128, name = "image_path")
    private String imagePath;

    @Column(length = 1, name = "image_category")
    private Integer imageCategory; // 图片类别

    @Column(length = 20, name = "create_time")
    private String creatTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public Integer getImageCategory() {
        return imageCategory;
    }

    public void setImageCategory(Integer imageCategory) {
        this.imageCategory = imageCategory;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }
}
