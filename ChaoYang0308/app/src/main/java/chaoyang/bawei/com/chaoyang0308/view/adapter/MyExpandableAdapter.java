package chaoyang.bawei.com.chaoyang0308.view.adapter;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import chaoyang.bawei.com.chaoyang0308.R;
import chaoyang.bawei.com.chaoyang0308.view.bean.JsonBean;
import chaoyang.bawei.com.chaoyang0308.view.myview.MyCalculator;

public class MyExpandableAdapter implements ExpandableListAdapter {
    private Context context;
    private JsonBean bean;
    private CheckBox cb_sp;
    private CheckBox cb_sj;

    public MyExpandableAdapter(Context context, JsonBean bean) {
        this.context = context;
        this.bean = bean;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getGroupCount() {
        return bean.getData().size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return bean.getData().get(groupPosition).getList().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return bean.getData().get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return bean.getData().get(groupPosition).getList().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.layout_groupview, null);
        cb_sj = view.findViewById(R.id.cb_sj);
        TextView txt_name = view.findViewById(R.id.txt_name);
        TextView txt_num = view.findViewById(R.id.txt_num);
        txt_num.setText(bean.getData().get(groupPosition).getSellerName());

        return view;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.layout_childview, null);
        cb_sp = view.findViewById(R.id.cb_sp);
        ImageView img_sp = view.findViewById(R.id.img_sp);
        TextView txt_title_sp = view.findViewById(R.id.txt_title_sp);
        TextView txt_price_sp = view.findViewById(R.id.txt_price_sp);
        MyCalculator mc = view.findViewById(R.id.mc);
        Glide.with(context).load(bean.getData().get(groupPosition).getList().get(childPosition).getImages()).into(img_sp);
        txt_title_sp.setText(bean.getData().get(groupPosition).getList().get(childPosition).getTitle());
        txt_price_sp.setText(bean.getData().get(groupPosition).getList().get(childPosition).getPrice());
        mc.setGetMyCalculatorLisener(new MyCalculator.GetMyCalculatorLisener() {
            @Override
            public void getReduce() {

            }

            @Override
            public void getIncrease() {

            }
        });
        cb_sj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ( cb_sj.isChecked()){
                    for (int i=0 ;i<bean.getData().get(groupPosition).getList().get(childPosition).getPscid().length();i++){
                        cb_sp.setChecked(true);
                    }
                }else{
                    for (int i=0 ;i<bean.getData().get(groupPosition).getList().get(childPosition).getPscid().length();i++){
                        cb_sp.setChecked(false);
                    }

                }

            }
        });
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return true;
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public void onGroupExpanded(int groupPosition) {

    }

    @Override
    public void onGroupCollapsed(int groupPosition) {

    }

    @Override
    public long getCombinedChildId(long groupId, long childId) {
        return 0;
    }

    @Override
    public long getCombinedGroupId(long groupId) {
        return 0;
    }
}
