package com.hss01248.sort;


import com.hss01248.proxy.ProxyUtil;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/3/28 0028.
 */
public class Test {



    public static void main(String[] args){

        final int num = 50;


        final Integer[] nums = new Integer[num];
        randomNums(num, nums);

        Sort2 sort = new Sort2();
       sort = ProxyUtil.getProxy(sort, new InvocationHandler() {
           public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
               MyLog.e("-----------------"+method.getName()+"---------------------");
               MyLog.arr(nums);
               long startTime = System.nanoTime();
                Object o  = method.invoke(proxy,args);
               long endTime = System.nanoTime();
               long passed = endTime - startTime;
               long passms = passed/1000000;
               MyLog.i("time used:"+ String.format("%d min %d s %d ms  %d ns",passms/60000,passms/1000%60,passms%1000,passed%1000000));
               MyLog.arr(nums);
               randomNums(num,nums);
               return o;
           }
       });


       sort.bubble2(nums);
       //sort.bubblePro(nums);

        sort.insert(nums);
        //sort.sheel(nums);

        sort.select2(nums);
       // sort.heap(nums);
        sort.quick(nums,0,nums.length-1);




        /*Cat cat = ProxyUtil.getProxy(new Cat(), new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                MyLog.i("before-------------");
                 method.invoke(proxy,args);
                MyLog.i("after-------------");
                return null;
            }
        });
        cat.fly();

        Cat cat2 = ProxyUtil.getProxy(Cat.class, new MethodInterceptor() {
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                MyLog.i("before-------------2");
               methodProxy.invokeSuper(o,objects);
                MyLog.i("after-------------2");
                return null;
            }
        });
        cat2.fly();*/


       /* CglibProxy proxy = new CglibProxy();
        //通过生成子类的方式创建代理类
        Cat proxyImp = (Cat)proxy.getProxy(Cat.class);
        proxyImp.fly();*/


    }

    private static void randomNums(int num, Integer[] nums) {
        for (int i = 0; i < num; i++) {
            nums[i] = (int) (Math.random()*num);
        }
    }

}
