package utils;

/**
 * Created by supiccc on 2019-02-19 16:36
 */
public class ResponseJson {
    private int code;
    private String msg;
    private Object data;

    public ResponseJson(int code, String msg, Object data) {
        setCode(code);
        setMsg(msg);
        setData(data);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
