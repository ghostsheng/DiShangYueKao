package chaoyang.bawei.com.chaoyang0308.view.bean;

import java.util.List;
//JsonBean类
public class JsonBean {
    private String code;
    private String msj;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "JsonBean{" +
                "code='" + code + '\'' +
                ", msj='" + msj + '\'' +
                ", data=" + data +
                '}';
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsj() {
        return msj;
    }

    public void setMsj(String msj) {
        this.msj = msj;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public JsonBean() {

    }

    public JsonBean(String code, String msj, List<DataBean> data) {

        this.code = code;
        this.msj = msj;
        this.data = data;
    }
}
