package chaoyang.bawei.com.chaoyang0308.view.myview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class MyFlluid extends ViewGroup {
    public MyFlluid(Context context) {
        super(context);
    }

    public MyFlluid(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyFlluid(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
//        获取宽度
        int width = getWidth();
//        定义行数常亮
        int ROW = 0;
//        子控件坐标
        int xWidth = 18;
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            int viewWidth = view.getMeasuredWidth();
            int viewHeight = view.getMeasuredHeight();
            if (viewWidth + xWidth > width) {
                ROW++;
                xWidth = 18;
            }
            view.layout(xWidth, ROW * viewHeight, viewWidth + xWidth, viewHeight * (ROW + 1));
            xWidth += viewWidth;
        }


    }
}
