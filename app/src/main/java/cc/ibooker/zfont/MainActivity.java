package cc.ibooker.zfont;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        TextView boldTv = (TextView) findViewById(R.id.tv_shscn_bold);
        Typeface typeFaceHold = Typeface.createFromAsset(getAssets(), "fonts/SourceHanSansCN-Bold.otf");
        boldTv.setTypeface(typeFaceHold);

        TextView extraLightTv = (TextView) findViewById(R.id.tv_shscn_extraLight);
        Typeface typeFaceExtraLight = Typeface.createFromAsset(getAssets(), "fonts/SourceHanSansCN-ExtraLight.otf");
        extraLightTv.setTypeface(typeFaceExtraLight);

        TextView heavyTv = (TextView) findViewById(R.id.tv_shscn_heavy);
        Typeface typeFaceHeavy = Typeface.createFromAsset(getAssets(), "fonts/SourceHanSansCN-Heavy.otf");
        heavyTv.setTypeface(typeFaceHeavy);

        TextView lightTv = (TextView) findViewById(R.id.tv_shscn_light);
        Typeface typeFaceLight = Typeface.createFromAsset(getAssets(), "fonts/SourceHanSansCN-Light.otf");
        lightTv.setTypeface(typeFaceLight);

        TextView mediumTv = (TextView) findViewById(R.id.tv_shscn_medium);
        Typeface typeFaceMedium = Typeface.createFromAsset(getAssets(), "fonts/SourceHanSansCN-Medium.otf");
        mediumTv.setTypeface(typeFaceMedium);

        TextView normalTv = (TextView) findViewById(R.id.tv_shscn_normal);
        Typeface typeFaceNormal = Typeface.createFromAsset(getAssets(), "fonts/SourceHanSansCN-Normal.otf");
        normalTv.setTypeface(typeFaceNormal);

        TextView regularTv = (TextView) findViewById(R.id.tv_shscn_regular);
        Typeface typeFaceRegular = Typeface.createFromAsset(getAssets(), "fonts/SourceHanSansCN-Regular.otf");
        regularTv.setTypeface(typeFaceRegular);
    }

}
