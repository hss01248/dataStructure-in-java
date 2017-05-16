package com.hss01248.sort;

/**
 * Created by Administrator on 2017/5/16.
 */
public class Sort2 {

    public void select(Integer[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int key = arr[i];
            int idx = i;
            for (int j = i+1; j < len; j++) {
                if(key > arr[j]){
                    key = arr[j];
                    idx = j;
                }
            }
            Util.swap(arr,i,idx);
        }
    }

    public void bubble(Integer[] arr){
        int len = arr.length;
        for (int i = 0; i < len ; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if(arr[j+1] <arr[j]){
                    Util.swap(arr,j,j+1);
                }
            }
        }
    }

    public void select2(Integer[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int value = arr[i];
            int idx = i;
            for (int j = i+1; j < len; j++) {
                if(arr[j] < value){
                    value = arr[j];
                    idx = j;
                }
            }
            Util.swap(arr,i,idx);
        }
    }

    public void bubble2(Integer[] arr){
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len - i - 1; j++) {
                if(arr[j+1] <arr[j]){
                    Util.swap(arr,j,j+1);
                }
            }
        }
    }

    public void insert(Integer[] arr){
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            if(arr[i+1] < arr[i]){//只有后面待插入的i+1位置上的偏小，才要往前面插入
                int tmp = arr[i+1];
                //arr[i+1] = arr[i];//先移一位
                int idx = i;//然后从i-1开始往前比较
                for (int j = idx; j >=0 ; j--) {//从后往前逐个比较
                    if(tmp < arr[j]){//如果待插入的树比j位置上的还是小,那么:
                        arr[j+1] = arr[j];//arr[j]往后移一位
                        idx = j;
                    }else {//找到了位置idx,就是j的位置
                        idx = j;
                        break;
                    }
                }
                //此时arr[i+1]已经被覆盖,要用tmp赋值给arr[idx]
                arr[idx] = tmp;


            }
        }
    }

    public void quick(Integer[] arr,int low,int high){
        if(low<high){
            int mid = findMid(arr,low,high);
            quick(arr,low,mid-1);
            quick(arr,mid+1,high);
        }


    }

    private int findMid(Integer[] arr, int low, int high) {
        int tmp = arr[low];//默认参照为第一个
        while (low<high){
            while (low<high && arr[high]>tmp){//从后往前,找出比参照小的
                high--;
            }
            arr[low] = arr[high];//将那个小的移动到参照的位置
            while (low<high && arr[low]< tmp){//从前往后,找出比对照大的
                low++;
            }
            arr[high] = arr[low];//将比对照大的那个数移动到arr[high]原先空出的位置上
        }
        arr[low] = tmp;//将中轴的位置移动到最终空出来的low位置上,并返回该中轴的位置
        return low;
    }
}
