package chaoyang.bawei.com.chaoyang0308.view.bean;

import java.util.List;
//数据Bean类
public class DataBean {
    private String sellerName;
    private String sellerid;
    private List<GoodsBean> list;

    public DataBean() {
    }

    public DataBean(String sellerName, String sellerid, List<GoodsBean> list) {

        this.sellerName = sellerName;
        this.sellerid = sellerid;
        this.list = list;
    }

    public String getSellerName() {

        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public List<GoodsBean> getList() {
        return list;
    }

    public void setList(List<GoodsBean> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "DataBean{" +
                "sellerName='" + sellerName + '\'' +
                ", sellerid='" + sellerid + '\'' +
                ", list=" + list +
                '}';
    }
}
