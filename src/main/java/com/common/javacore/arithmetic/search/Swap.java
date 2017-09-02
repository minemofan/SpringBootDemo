package com.common.javacore.arithmetic.search;

/**
 * Created by Administrator on 2017/8/6.
 * Description 两个变量交换的四种方法（Java）
 */
public class Swap {

    public static void main(String[] args){
        swap1(3,7);
        swap2(3,7);
        swap3(3,7); //效率最好
        swap4(3,7);
    }

    /**
     *  Description 利用第三个变量交换数值，简单的方法。
     * @param x
     * @param y
     */
    public static void swap1(int x, int y){
        System.out.println("swap1交换前，x:"+ x +"，y："+ y);
        int temp = x;       //定义第三临时变量temp并提取x值
        x = y;              //把y的值赋给x
        y = temp;           //然后把临时变量temp值赋给y
        System.out.println("swap1交换后，x:"+ x +"，y："+ y);
    }

    /**
     *  Description 可以用两个数求和然后相减的方式进行数据交换
     *          ,弊端在于如果 x 和 y 的数值过大的话，超出 int 的值会损失精度。
     * @param x
     * @param y
     */
    public static void swap2(int x, int y){
        System.out.println("swap2交换前，x:"+ x +"，y："+ y);
        x = x + y;        //x(15) = 5 + 10；
        y = x - y;        //y(5) = x(15) - 10;
        x = x - y;        //x(10) = x(15) - y(5)
        System.out.println("swap2交换后，x:"+ x +"，y："+ y);
    }

    /**
     *  Description 利用位运算的方式进行数据的交换，利用的思想原理是
     *      ：一个数异或同一个数两次，结果还是那个数，而且不会超出int范围
     * @param x
     * @param y
     */
    public static void swap3(int x, int y){
        System.out.println("swap3交换前，x:"+ x +"，y："+ y);
        x = x^y;
        y = x^y;  //y=(x^y)^y
        x = x^y;  //x=(x^y)^x
        System.out.println("swap3交换后，x:"+ x +"，y："+ y);
    }

    /**
     *  Description 最为简单的，在打印输出的时候直接交换变量
     * @param x
     * @param y
     */
    public static void swap4(int x, int y){
        System.out.println("swap4交换前，x:"+ x +"，y："+ y);
        //直接在输出的时候交换
        System.out.println("swap4交换后，x:"+ y +"，y："+ x);
    }
}
