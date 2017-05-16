package com.hss01248.sort;

/**
 * Created by Administrator on 2017/5/16 0016.
 *
 * 主要参考: http://www.jianshu.com/p/5e171281a387
 */
public class Sort {

    public  void bubble(Integer[] nums){
        int size = nums.length;
        for (int i = 0; i < size -1; i++) {
            for (int j = 0; j < size -1 -i; j++) {
                if(nums[j] > nums[j+1]){
                    swap(nums,j,j+1);
                }
            }
        }
    }

    public  void bubblePro(Integer[] nums){
        int temp = 0;
        int size = nums.length;
        boolean isContinue = true;
        for (int i = 0; i < size -1 && isContinue; i++) {
            isContinue = false;
            for (int j = 0; j < size -1 -i; j++) {
                if(nums[j] > nums[j+1]){
                    temp = nums[j+1];
                    nums[j+1] = nums[j];
                    nums[j] = temp;
                    isContinue = true;
                }
            }
        }
    }

    public  void insert(Integer[] arr){
        int size = arr.length;
        for (int i = 1; i < size; i++) {
            if(arr[i] < arr[i-1]){
                int temp = arr[i];//拿到待插入的值,暂存
                int k = i-1;
                for (int j = k; j >=0 && temp < arr[j]; j--) {//通过内循环找到插入位置k
                    arr[j+1] = arr[j];//并且每一个数都往后一位
                    k--;
                }
                arr[k+1] = temp;//执行插入
            }
        }
    }

    public  void sheel(Integer[] arr){
        int d = arr.length;

        while (d !=0){
            d= d/2;//分组的间隔为d,
            for (int x=0; x<d; x++){
                for (int i = x+d; i < arr.length; i+=d) {//以d为间隔的数组成一组,在每个分组中进行插入排序
                    int j = i-d;
                    int tmp = arr[i];
                    for (;j>0&& arr[j] > tmp;j-=d){
                        arr[j+d] = arr[j];
                    }
                    arr[j+d] = tmp;
                }
            }
        }
    }

    public  void select(Integer[] nums){
        int temp = 0;
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            int key = nums[i];
            int pos = i;
            for (int j = i+1; j < size; j++) {//选出后面序列中最小值和位置
                if(key > nums[j]){
                    key = nums[j];
                    pos = j;
                }
            }
            //执行交换
            nums[pos] = nums[i];
            nums[i] = key;
        }
    }

    public void heap(Integer[] arr){
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            buildMaxHeap(arr,len-1-i);
            swap(arr,0,len-1-i);
        }
    }


    public void quick(Integer[] arr,int start,int end){
        if(start>=end){
            return;
        }
        int base = getQuickBase(arr,start,end);
        int tmp ;
        int i = start;
        int j = end;

    }

    private int getQuickBase(Integer[] arr, int start, int end) {
        return arr[start];
    }


    private void swap(Integer[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[i] = tmp;

    }

    private void buildMaxHeap(Integer[] arr, int lastIndex) {
        for (int i = (lastIndex-1)/2; i >=0 ; i--) {
            int k = i;
            while (k*2+1<=lastIndex){
                int biggerIndex = 2*k +1;
                if(biggerIndex < lastIndex){
                    if(arr[biggerIndex] < arr[biggerIndex+1]){
                        biggerIndex++;
                    }
                }
                if(arr[k]< arr[biggerIndex]){
                    swap(arr,k,biggerIndex);
                    k = biggerIndex;
                }else {
                    break;
                }
            }
        }
    }


}
