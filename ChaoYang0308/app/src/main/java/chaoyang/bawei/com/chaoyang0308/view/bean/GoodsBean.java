package chaoyang.bawei.com.chaoyang0308.view.bean;

public class GoodsBean {
    private String bargainPrice;
    private String createtime;
    private String detailUrl;
    private String images;
    private String num;
    private String pid;
    private String price;
    private String pscid;
    private String selected;
    private String sellerid;
    private String subhead;
    private String title;

    @Override
    public String toString() {
        return "GoodsBean{" +
                "bargainPrice='" + bargainPrice + '\'' +
                ", createtime='" + createtime + '\'' +
                ", detailUrl='" + detailUrl + '\'' +
                ", images='" + images + '\'' +
                ", num='" + num + '\'' +
                ", pid='" + pid + '\'' +
                ", price='" + price + '\'' +
                ", pscid='" + pscid + '\'' +
                ", selected='" + selected + '\'' +
                ", sellerid='" + sellerid + '\'' +
                ", subhead='" + subhead + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(String bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPscid() {
        return pscid;
    }

    public void setPscid(String pscid) {
        this.pscid = pscid;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GoodsBean() {

    }

    public GoodsBean(String bargainPrice, String createtime, String detailUrl, String images, String num, String pid, String price, String pscid, String selected, String sellerid, String subhead, String title) {

        this.bargainPrice = bargainPrice;
        this.createtime = createtime;
        this.detailUrl = detailUrl;
        this.images = images;
        this.num = num;
        this.pid = pid;
        this.price = price;
        this.pscid = pscid;
        this.selected = selected;
        this.sellerid = sellerid;
        this.subhead = subhead;
        this.title = title;
    }
}
