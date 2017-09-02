package site.nebulas.entity;

/**
 * Created by Administrator on 2017/8/6.
 */
public class RetMsg {
    private Integer code;
    private String msg;
    private String requset;
    private Object content;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getRequset() {
        return requset;
    }

    public void setRequset(String requset) {
        this.requset = requset;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
