package com.hss01248.sort;

/**
 * Created by Administrator on 2017/5/16 0016.
 */
public class Util {

    public static void swap(Integer[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;

    }
}
