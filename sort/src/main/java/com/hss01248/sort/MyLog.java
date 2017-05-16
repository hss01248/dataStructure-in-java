package com.hss01248.sort;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public class MyLog {


    //private static Logger log = Logger.getLogger(MyLog.class.toString());//原生的log会导致重复打印,千万不要用
/* all→finest→finer→fine→config→info→warning→server→off
         级别依次升高，后面的日志级别会屏蔽之前的级别  */
   /* static
    {
        Handler console = new ConsoleHandler();
        console.setLevel(Level.ALL);
        log.addHandler(console);
    }*/

    public static void i(String str){
        System.out.println(str);
    }

    public static void w(String str){
        System.out.println(str);
    }

    public static void e(String str){
        System.out.println(str);
    }

    public static <T> void arr(T[] arr){
        StringBuilder stringBuilder = new StringBuilder();
        int len = arr.length;
        if(len>50){
            len = 50;
        }
        for (int i=0;i<len;i++){
            stringBuilder.append(arr[i]).append(",");
        }
        e(stringBuilder.toString());

    }

}
