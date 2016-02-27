# RichText
用来显示重排网页内容的富文本控件

#### 原理：
``` java
//方法说明：
public static Spanned fromHtml (String source, Html.ImageGetter imageGetter, Html.TagHandler tagHandler)
//参数：
//source：包含Html的字符串。
//imageGetter：imageGetter对象。当系统解析到<img>标签时就会调用imageGetter对象的getDrawable方法，
//并将src属性值传递传入getDrawable方法。至于src属性的具体含义，就要在getDrawable方法中确定了。getDrawable方法返回一个Drawable对象。
//我们可以从res/drawable资源、assets资源、SD卡以及网络上获得图像资源，并分装成Drawable对象。
//tagHandler：TagHandler对象。系统没处理一个标签时都会调用该对象的handleTag方法。不过这个参数并不常用。如果不用可以设为null。
```
