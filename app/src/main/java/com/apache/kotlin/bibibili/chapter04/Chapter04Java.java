package com.apache.kotlin.bibibili.chapter04;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * author: jerry
 * created on: 2020/9/24 8:33 PM
 * description:
 */
class Chapter04Java {
    public static void main(String[] args) {


        //Java 中的 ? extends

        TextView textView = new Button(null);


        /**
         * 协变(Invariance)：子类的泛型类型 也属于泛型类型的子类
         * 不能把一个子类List对象赋值给一个父类的List 引用
         * 这是因为 Java 的泛型本身具有「不可变性 Invariance」，Java 里面认为 List<TextView> 和 List<Button> 类型并不一致，也就是说，
         * 子类的泛型（List<Button>）不属于泛型（List<TextView>）的子类。这是由于java的泛型类型擦除, 由于有类型擦除的存在，为了保证
         * 类型安全，java 给泛型设置了这种限制
         */
//        List<TextView> textViews = new ArrayList<Button>();

        List<? extends TextView> textViews = new ArrayList<Button>();
        //于它满足 ? extends TextView 的限制条件，所以 get 出来的对象，肯定是 TextView 的子类型，根据多态的特性，能够赋值给 TextView，啰嗦一句，赋值给 View 也是没问题的。
        TextView text = textViews.get(0);

        /**
         * List<? extends TextView> 由于类型未知，它可能是 List<Button>，也可能是 List<TextView>。
         * 对于前者，显然我们要添加 TextView 是不可以的
         *
         * 由于 add 的这个限制，使用了 ? extends 泛型通配符的 List，只能够向外提供数据被消费，从这个角度来讲，向外提供数据的一方称为「生产者 Producer」
         */
//        textViews.add(textView);


        /**
         * Java 中的 ? super
         * 这个 ? super 叫做「下界通配符」，可以使 Java 泛型具有「逆变性 Contravariance」。
         * 通配符 ? 表示 List 的泛型类型是一个未知类型。
         * super 限制了这个未知类型的下界，也就是泛型类型必须满足这个 super 的限制条件。
         * super 我们在类的方法里面经常用到，这里的范围不仅包括 Button 的直接和间接父类，也包括下界 Button 本身
         * super 同样支持 interface。
         * 使用下界通配符 ? super 的泛型 List，只能读取到 Object 对象，一般没有什么实际的使用场景，通常也只拿它来添加数据，也就是消费已有的 List<? super Button>，往里面添加 Button，因此这种泛型类型声明称之为「消费者 Consumer」。
         *
         */
        List<? super Button> buttons1 = new ArrayList<TextView>();
        List<? super Button> buttons2 = new ArrayList<Button>();
        List<? super Button> buttons3 = new ArrayList<Object>();

       Object object = buttons1.get(0);

       Button button = new Button(null);

//       buttons1.add(object);
       buttons1.add(button);


       Chapter04Java demo = new Chapter04Java();

       List<Button> buttons = new ArrayList<>();
       demo.printText(buttons);


       List<View> views = new ArrayList<>();
       demo.addTextView(views);
    }

    /**
     * 这里 加上 ? extends 之后，调用printText时传入List<Button>
     *  所以当遇到「只想使用，不想修改」的情况，可以用? extends来让本来不具备covariant性质的java
     *  支持covariant, 以此来扩大变量或者参数的接收范围，让程序更灵活
     * @param textViews
     */
    public void printText(List<? extends TextView> textViews){
        for (TextView textView : textViews) {
            System.out.println(textView.getText());
        }
    }


    /**
     * 在 参数前面加上 ? super, 可以让
     * 所以当遇到「只想需改，不想使用」的情况，可以用? super来让本来不具备concovariant性质的java
     * @param textViews
     */
    public void addTextView(List<? super TextView> textViews){
        TextView textView = new TextView(null);
        textViews.add(textView);
    }


    class Monster<T extends Animal & Food>{

    }

    private interface Animal{

    }

    private interface Food{

    }


    /**
     * Java 里的泛型参数 T 并不是一个真正的类型, 而是一个代号, 所以
     * 不能当做一个普通的类型来用，比如你不能在方法里检查一个对象是不是一个T的实例
     * 下面的代码会报错
     */
    /*<T> void printIfTypeMatch(Object item){
        if (item instanceof T){
            synchronized (item)
        }
    }*/
}


