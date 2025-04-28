# ZFontTextView
Android字体，分析了Android系统自带的4种样式效果，以及对思源黑体的安装和实现进行详解。最后自定义字体TextView（ZFontTextView）。使用工具Android Studio

>本文选自[书客创作](http://www.ibooker.cc)平台第14篇文章。[阅读原文](http://www.ibooker.cc/article/14/detail) 。

![书客创作](http://upload-images.jianshu.io/upload_images/3480018-880151e7a8fcc76f..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

​Android字体，今天在这里所要说的不是Android字体的相关属性，而是来说一说如何修改Android字体的样式问题。

Android系统默认提供4种字体样式，分别是**"sans"，"serif"，"monospace"，"normal"**。各个字体样式有所不同，效果图如下：

![Android系统默认字体效果图](http://upload-images.jianshu.io/upload_images/3480018-957ed4c208c231b2..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

Android系统默认字体效果图
从效果上看，好像Android系统字体样式差别不是很大，只要在布局文件XML中通过**android:typeface**属性即可实现。

```
android:typeface="sans"
android:typeface="monospace"
android:typeface="normal"
android:typeface="serif"
```
Android系统自带的几种字体样式，局限性太大，所以Google与Adobe合作发布思源黑体（Source Han Sans）。这套字体有七种字体粗细**（ExtraLight、Light、Normal、Regular、Medium、Bold 和 Heavy）**，完全支持日文、韩文、繁体中文和简体中文，还包括来自 Source Sans字体家族的拉丁文、希腊文和西里尔文字形。

![思源黑体，牛刀小试效果图](http://upload-images.jianshu.io/upload_images/3480018-814218eed6ebd267..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

**那么如何去实现该套字体呢？**

1、引入外部字体资源，一般情况下会把下载下来的字体资源文件放置在main/assets/fonts文件夹下。

一般我们下载下来的字体资源文件后缀为.ttf，而这套思源黑体，则为.otf，这里的otf，意为opentype和ttf(truetype)是兼容的。

![思源黑体，一个7种，导入项目结构图](http://upload-images.jianshu.io/upload_images/3480018-7273cd809eb1b383..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

2、在Java代码中进行引用，并设置到相应的控件上就可以了，例如使用SourceHanSansCN-Bold.otf。

```
TextView boldTv = (TextView) findViewById(R.id.tv_shscn_bold);
Typeface typeFaceHold = Typeface.createFromAsset(getAssets(),"fonts/SourceHanSansCN-Bold.otf");
boldTv.setTypeface(typeFaceHold);
```

在实际的生产中，为了提高代码的复用性，往往会自定义TextView设置字体。之后，只需要引入自定义TextView即可。

```
public class ZFontTextView extends android.support.v7.widget.AppCompatTextView {
   public ZFontTextView(Context context) {
      this(context, null);
   }
   public ZFontTextView(Context context, @NullableAttributeSet attrs) {
      this(context,attrs,0);
   }
   public ZFontTextView(Context context, @NullableAttributeSet attrs, intdefStyleAttr) {
      super(context,attrs,defStyleAttr);
      init(context);
   }
   private void init(Context context) {
      try{
         /*
          *必须事先在assets底下创建一fonts文件夹，并放入要使用的字体文件(.ttf/.otf)
          *并提供相对路径给creatFromAsset()来创建Typeface对象
          */
         Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/SourceHanSansCN-Light.otf");
         // 当使用外部字体却又发现字体没有变化的时候(以Droid Sans代替)，通常是因为这个字体android没有支持,而非你的程序发生了错误
         if(typeface != null)
            setTypeface(typeface);
      } catch(Exception e) {
         e.printStackTrace();
      }
   }
}
```

XML布局文件中引入。
```
<cc.ibooker.zfont.ZFontTextView
   android:layout_width="wrap_content"
   android:layout_height="wrap_content"/>
```
思源黑体在IOS中能够很好的显示，但是在Android思源黑体并不没有想象中那么好，例如字体间间距过大，而这种大的间距没法通过属性进行修改，所以实际使用过程要注意。

[Github地址](https://github.com/zrunker/ZFontTextView)
[阅读原文](http://www.ibooker.cc/article/14/detail)

----------
![微信公众号：书客创作](http://upload-images.jianshu.io/upload_images/3480018-a93c53e8a4a3abf9..jpg?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)
