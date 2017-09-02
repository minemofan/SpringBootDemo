package com.common.javacore.arithmetic.search;

/**
 * Created by Administrator on 2017/8/6.
 * Title    二分查找法   又称折半查找，它是一种效率较高的查找方法。
 * Descripition
 　　【二分查找要求】：
            1.必须采用顺序存储结构。
            2.必须按关键字大小有序排列。
 */
public class binarySearch {

    public static int[] src = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

    public static void main(String[] args){
        binarySearch(src,10);
    }

    /**
     * Description
     *  例如：查找10 ，经历的中间数： 5 > 8 > 9
     * @param nums   数组
     * @param val   目标val
     */
    public static int binarySearch(int[] nums, int  val ){
        int start = 0;
        int end = nums.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;            //中间数
            System.out.println(nums[mid]);
            if (nums[mid] == val) {
                return mid;                     //已经查到返回！
            } else if (nums[mid] > val) {
                end = mid - 1;
            } else if (nums[mid] < val) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
