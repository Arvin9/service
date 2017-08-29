package site.nebulas.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/29.
 */
@Entity
@Table(name="file")
public class File {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 32, name = "file_name")
    private String fileName;

    @Column(length = 32, name = "file_size")
    private String fileSize;

    @Column(length = 32, name = "file_desc")
    private String fileDesc;

    @Column(length = 128, name = "save_path")
    private String savePath;

    @Column(length = 32, name = "create_time")
    private String creatTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
    }

    public String getFileDesc() {
        return fileDesc;
    }

    public void setFileDesc(String fileDesc) {
        this.fileDesc = fileDesc;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }
}
