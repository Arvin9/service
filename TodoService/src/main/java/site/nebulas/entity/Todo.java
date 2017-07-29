package site.nebulas.entity;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/29.
 */
@Entity
@Table(name="todo")
public class Todo {
    @Id
    @GeneratedValue
    private Integer id;

    @Column(length = 32)
    private String description;

    @Column(length = 1)
    private Integer state;

    @Column(length = 32, name = "create_time")
    private String creatTime;

    @Column(length = 32, name = "finish_time")
    private String finishTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(String creatTime) {
        this.creatTime = creatTime;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }
}
