package chaoyang.bawei.com.chaoyang0308.view.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import chaoyang.bawei.com.chaoyang0308.R;
import chaoyang.bawei.com.chaoyang0308.presenter.ShoppingTrolleyPresenter;
import chaoyang.bawei.com.chaoyang0308.view.ShoppingTrolleyView;
import chaoyang.bawei.com.chaoyang0308.view.adapter.MyExpandableAdapter;
import chaoyang.bawei.com.chaoyang0308.view.bean.JsonBean;
import chaoyang.bawei.com.chaoyang0308.view.myview.MyFlluid;

public class MainActivity extends AppCompatActivity implements ShoppingTrolleyView {

    private ExpandableListView elv;
    private ShoppingTrolleyPresenter presenter;
    private EditText et_ssk;
    private Button btn_ssj;
    private MyFlluid mf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        elv = findViewById(R.id.elv);
        et_ssk = findViewById(R.id.et_ssk);
        btn_ssj = findViewById(R.id.btn_ssj);
        mf = findViewById(R.id.mf);
        btn_ssj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView txt_view=new TextView(MainActivity.this);
                String trim = et_ssk.getText().toString().trim();
                txt_view.setText(trim);
                ViewGroup.MarginLayoutParams params=new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT,ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                mf.addView(txt_view,params);
            }
        });
        presenter = new ShoppingTrolleyPresenter(this);
        presenter.getShoppingTrolleyPresenter();

    }

    @Override
    public void getShoppingTrolleyView(String json) {
       Gson gson=new Gson();
        JsonBean bean = gson.fromJson(json, JsonBean.class);
        MyExpandableAdapter adapter=new MyExpandableAdapter(MainActivity.this , bean);
        elv.setAdapter(adapter);
        for (int i=0;i<adapter.getGroupCount();i++){
           elv.expandGroup(i);
        }
        elv.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dttchView();
    }
}
