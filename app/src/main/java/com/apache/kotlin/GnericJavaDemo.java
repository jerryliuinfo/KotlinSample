package com.apache.kotlin;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * author: jerry
 * created on: 2020/7/26 6:08 PM
 * description:
 */
public class GnericJavaDemo extends AppCompatActivity {

    void test(){



        List<TextView> textViews = new ArrayList<>();
        /**
         * 报错:Type Dismatch, Require Button Found Textview
         * 不能把一个子类的List对象赋值给一个父类的List引用,这是java泛型的一种性质，叫做 covariance, 中文翻译叫 协变,
         * 协变其实是来自数学上的一种概念, 它在泛型里面的意思是:子类的泛型类型 也属于泛型类型的子类.其实它的意思就是：声明一个
         * 父类的List，可以复制给一个子类的List对象，但是java的泛型不具备这种性质，所以下面的代码会报错, java之所以有这种限制
         * 是因为java泛型在编译时的类型擦除，由于有类型擦除的存在，为了保证类型安全，java给泛型设置了这种限制，
         *
         */
        //List<TextView> textViews2 = new ArrayList<Button>();//

        //在java里用数组来，把一个子类的数组赋值给一个父类的数组，是不会报错的，这是因为数组在编译时不会有类型擦除
        TextView[] textViewArray = new Button[10];

        /**
         * Java不允许把一个子类的泛型类型对象赋值给一个父类的泛型类型声明,Kotlin继承了这种限制
         * 但有时候确实有这种需求，所以java给我们提供了相应的语法来解除这种限制： 通配符，也就是那个 "?"
         * 不过这种写法虽然解除了赋值的限制，但是却会增加另外一个限制： 在使用这个引用的时候，不能调用它的参数
         * 包含参数类型的方法(尖括号里的Textview)，也不能给它的包含类型参数的字段赋值，简单来说就是只能用它
         * 不能修改它:  使用场景 ：
         * 下面printTexts 打印出textview的内容，但是传进来的参数是一个List<Button>时，就可以用? extends
         * 来让本来不具备covarant(协变)性质的java支持covarant，以此来扩大变量或者参数的接收范围
         *
         */
        List<? extends TextView> list = new ArrayList<Button>();//

//        TextView textView = new TextView();
//        list.add(textView);

        List<Button> buttons = new ArrayList<>();
        //这样会报错
        //printTexts(buttons);
        //这样不会报错
        printTexts2(buttons);

        /**
         * 跟? extends 相对的，还有? super，它也是可以让变量或者参数的接受范围扩大，不过扩大的方向跟
         * ？ extends 相反，它可以让父类类型的泛型对象赋值给子类的泛型类型声明，这叫做contravariant 逆变或者反变
         *  和 ? extends 一样，它也在解除赋值限制的同时，会有使用时的附加限制，它的附加限制和? extends也相反
         *  在使用这种变量的时候，不能调用返回值包含类型参数的方法，也不能获得包含类型参数的字段值，
         *  作用场景 {@link GnericJavaDemo#addTextView(List)})
         */
        List<View> views = new ArrayList<>();
        //报错
        //addTextView(views);
        addTextView2(views);

        //Producer extends , Consumer super
    }

    public void printTexts(List<TextView> textViews){
        for (TextView textView : textViews) {
            System.out.println(textView.getText());
        }
        ArrayList arrayList;
    }

    public void printTexts2(List<? extends TextView> textViews){
        for (TextView textView : textViews) {
            System.out.println(textView.getText());
        }
    }


    public void addTextView(List<TextView> textViews){
        TextView textView = new TextView(this);
        textViews.add(textView);
    }

    public void addTextView2(List<? super TextView> list){
        TextView textView = new TextView(this);
        list.add(textView);

        //Java:
        List<? extends TextView> textViews;
        List<? super Button> buttons;

    }



}


