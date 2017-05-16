package com.hss01248.sort.simple;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public class BubbleSort {

    /**
     * 从小到大排序
     * 不满足"两两比较相邻记录"的排序思想,只是最简单的交换排序
     * 思路是:让每个关键字都和它后面的每个关键字比较,如果大,就交换,这样一次下来,这个位置的关键字就是最小值
     *
     * @param datas
     * @return
     */
    public static Integer[] bubbleSort0(Integer[] datas){
        int i,j;
        for ( i = 0; i < datas.length; i++) {
            for ( j = i+1; j < datas.length; j++) {
                if(datas[i]>datas[j]){//拿外层指定位置的数据datas[i]跟它后面的数从前往后依次比较,大则换
                    datas[i] ^= datas[j];
                    datas[j] ^= datas[i];
                    datas[i] ^= datas[j];
                }
            }
        }
        return datas;
    }

    public static Integer[] bubbleSortReal(Integer[] datas){
        int i,j;
        for ( i = 0; i < datas.length; i++) {
            for ( j = datas.length-1; j >= i; j--) {
                if(datas[j]>datas[j+1]){//
                    datas[i] ^= datas[j];
                    datas[j] ^= datas[i];
                    datas[i] ^= datas[j];
                }
            }
        }
        return datas;
    }





}
