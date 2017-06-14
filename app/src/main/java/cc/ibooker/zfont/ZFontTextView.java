package cc.ibooker.zfont;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * 自定义字体TextView
 * Created by 邹峰立 on 2017/6/14.
 */
public class ZFontTextView extends android.support.v7.widget.AppCompatTextView {

    public ZFontTextView(Context context) {
        this(context, null);
    }

    public ZFontTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ZFontTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        try {
        /*
         * 必须事先在assets底下创建一fonts文件夹，并放入要使用的字体文件(.ttf/.otf)
		 * 并提供相对路径给creatFromAsset()来创建Typeface对象
		 */
        Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/SourceHanSansCN-Light.otf");
        // 当使用外部字体却又发现字体没有变化的时候(以 Droid Sans代替)，通常是因为这个字体android没有支持,而非你的程序发生了错误
        if (typeface != null)
            setTypeface(typeface);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
