package com.common.javacore.arithmetic.eight;

/**
 * Created by Administrator on 2017/8/20.
 */
public class InsertSortTest {

    /**
     * Ttile 直接插入排序
     * Description  即，将从第二位数开始逐步与已排好序的数组进行对比，然后进行插入。
     *      例如： 2,1,4,3,6,5
     *          第1次插入排序：1,2,4,3,6,5,
     *          第2次插入排序：1,2,4,3,6,5,
     *          第3次插入排序：1,2,3,4,6,5,
     *          第4次插入排序：1,2,3,4,6,5,
     *          第5次插入排序：1,2,3,4,5,6,
     *
     * 主要思想：
     *      特点：        stable sort(稳定性排序)、In-place sort（不占用额外空间）
     *      最优复杂度：  当输入数组就是排好序的时候，复杂度为O(n)，而快速排序在这种情况下会产生O(n^2)的复杂度。
     *      最差复杂度：  当输入数组为倒序时，复杂度为O(n^2)
     *                    插入排序比较适合用于“少量元素的数组”。
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr){
        int length = arr.length;    //获取数组长度
        int currentNum = 0;         //当前比较的数（待插入）

        //第一个数不需要进行插入
        for(int i=1; i<length; i++){
            currentNum = arr[i];

            /* 将当前要插入的数与已排序的数组进行比较>>插入
             * 当i=1,最多遍历一次（比较一次）
             * 当i=2,最多遍历两次（比较两次）
            * */
            int j = i-1;
            //foreach 如果插入数组比数组前一个数小，则将前一个数后移
            while(j >= 0 && arr[j] > currentNum){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1]=currentNum;
            System.out.println("第"+ i +"次插入排序："+ toString(arr));
        }
        return arr;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{2,1,4,3,6,5};
        InsertSortTest.insertSort(arr);
    }


    public static String toString(int[] arr){
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<arr.length;i++){
            sb.append(arr[i] + ",");
        }
        return sb.toString();
    }
}
