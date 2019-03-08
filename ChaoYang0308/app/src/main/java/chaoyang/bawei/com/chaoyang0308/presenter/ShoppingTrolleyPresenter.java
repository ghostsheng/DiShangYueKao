package chaoyang.bawei.com.chaoyang0308.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

import chaoyang.bawei.com.chaoyang0308.model.ShoppingTrolleyModel;
import chaoyang.bawei.com.chaoyang0308.view.ShoppingTrolleyView;

public class ShoppingTrolleyPresenter<T> {
    private final ShoppingTrolleyModel model;
    private final ShoppingTrolleyView view;
    private Reference<T> tReference;
    public void attchView(T t){
        tReference=new WeakReference<T>(t);
    }

    public ShoppingTrolleyPresenter(ShoppingTrolleyView view) {
        this.model = new ShoppingTrolleyModel();
        this.view = view;
    }
    public void getShoppingTrolleyPresenter(){
        model.getGoodsData();
        model.setGetShoppingTrolleyModel(new ShoppingTrolleyModel.GetShoppingTrolleyModel() {
            @Override
            public void getModelData(String json) {
                view.getShoppingTrolleyView(json);
            }
        });

    }
    public void dttchView(){
        if (tReference!=null){
            tReference.clear();
            tReference=null;
        }
    }

}
