package chaoyang.bawei.com.chaoyang0308.model;

import android.os.Handler;
import android.os.Message;

import java.io.IOException;

import chaoyang.bawei.com.chaoyang0308.utils.OkHttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class ShoppingTrolleyModel {
    String url="http://172.17.8.100/ks/product/getCarts?uid=51";
    GetShoppingTrolleyModel getShoppingTrolleyModel;
    public void setGetShoppingTrolleyModel(GetShoppingTrolleyModel getShoppingTrolleyModel){
        this.getShoppingTrolleyModel=getShoppingTrolleyModel;
    }
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case 0:
                    String json = (String) msg.obj;
                    getShoppingTrolleyModel.getModelData(json);
                    break;
            }
        }
    };
    public void getGoodsData(){
        OkHttpUtils okHttpUtils=new OkHttpUtils();

        okHttpUtils.doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String json = response.body().string();
                Message message=new Message();
                message.what=0;
                message.obj=json;
                handler.sendMessage(message);
            }
        });
    }
    public interface GetShoppingTrolleyModel{
        void getModelData(String json);

    }
}
