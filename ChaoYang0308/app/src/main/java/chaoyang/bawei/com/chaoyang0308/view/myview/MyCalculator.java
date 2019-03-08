package chaoyang.bawei.com.chaoyang0308.view.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import chaoyang.bawei.com.chaoyang0308.R;
import chaoyang.bawei.com.chaoyang0308.view.activity.MainActivity;

public class MyCalculator extends LinearLayout {

    private Button btn_jian;
    private EditText et_txt;
    private Button btn_jia;
    private int i;
    GetMyCalculatorLisener getMyCalculatorLisener;
    public void setGetMyCalculatorLisener(GetMyCalculatorLisener getMyCalculatorLisener){
        this.getMyCalculatorLisener=getMyCalculatorLisener;
    }

    public MyCalculator(Context context) {
        super(context);
    }

    public MyCalculator(final Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.mycalculator,this);
        btn_jian = findViewById(R.id.btn_jian);
        et_txt = findViewById(R.id.et_txt);
        btn_jia = findViewById(R.id.btn_jia);
        String s = et_txt.getText().toString();
        i = new Integer(s);
        btn_jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i>1){
                    String a1 = et_txt.getText().toString();
                    i = new Integer(a1);
                    i--;
                    String num = String.valueOf(i);
                    et_txt.setText(num);
                    getMyCalculatorLisener.getReduce();
                }else{
                    Toast.makeText(context, "商品数量不能小于1", Toast.LENGTH_SHORT).show();
                }
            }
        });
        btn_jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1 = et_txt.getText().toString();
                i = new Integer(a1);
                i++;
                String num = String.valueOf(i);
                et_txt.setText(num);
                getMyCalculatorLisener.getIncrease();
            }
        });
    }

    public MyCalculator(Context context,AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public interface GetMyCalculatorLisener{
        //减少
        void getReduce();
        //增加
        void getIncrease();
    }
}
