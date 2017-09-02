package com.common.javacore.arithmetic.eight;

/**
 * Created by Administrator on 2017/8/20.
 * Dscription
 * 特性：In-place sort（不占用额外空间） ，unstable sort。
 * 思想：每次找一个最小值。
 *       最好情况时间：O(n^2) = n * n。
 *       最坏情况时间：O(n^2)。
 */
public class selectSortTest {

    /**
     * Title        简单选择排序
     * Description
     *
     * @param a
     */
    public void selectSort(int[] a){
        int length = a.length;

        for (int i = 0; i < length; i++) {
            //循环次数
            int key = a[i];
            int position=i;
            for (int j = i + 1; j < length; j++) {
                //选出最小的值和位置
                if (a[j] < key) {
                    key = a[j];
                    position = j;
                }
            }
            a[position]=a[i];
            //交换位置
            a[i]=key;
        }
    }

    
    public static void main(String[] args) {

    }

}
