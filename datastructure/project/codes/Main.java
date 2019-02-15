package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int n = 3;
        DFS dfs = new DFS();
        long startTime=System.currentTimeMillis();   //获取开始时间
        System.out.print(dfs.numberOfPatterns(n,n));//测试的代码段
        long endTime=System.currentTimeMillis(); //获取结束时间
        System.out.println("DFS程序运行时间： "+(endTime-startTime)+"ms");

        BackTracking backTracking = new BackTracking();
        long startTime2=System.currentTimeMillis();   //获取开始时间
        System.out.print(backTracking.numberOfPatterns(n,n));// .numberOfPatterns(2,9);//测试的代码段
        long endTime2=System.currentTimeMillis(); //获取结束时间
        System.out.println("BackTracking程序运行时间： "+(endTime2-startTime2)+"ms");

        SmartWay smartWay = new SmartWay();
        long startTime3=System.currentTimeMillis();   //获取开始时间
        System.out.print(smartWay.numberOfPatterns(n,n));// .numberOfPatterns(2,9);//测试的代码段
        long endTime3=System.currentTimeMillis(); //获取结束时间
        System.out.println("SmartWay程序运行时间： "+(endTime3-startTime3)+"ms");

        BruteForce bruteForce = new BruteForce();
        long startTime4=System.currentTimeMillis();   //获取开始时间
        System.out.print(bruteForce.count(n));
        long endTime4=System.currentTimeMillis(); //获取结束时间
        System.out.println("BruteForth程序运行时间： "+(endTime4-startTime4)+"ms");

        DP dp = new DP();
        long startTime5=System.currentTimeMillis();   //获取开始时间
        System.out.print(dp.numberOfPatterns(n,n));
        long endTime5=System.currentTimeMillis(); //获取结束时间
        System.out.println("DP程序运行时间： "+(endTime5-startTime5)+"ms");

    }
}
