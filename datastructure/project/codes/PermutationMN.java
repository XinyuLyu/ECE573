package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PermutationMN {

    private static List<String> list = new ArrayList<>();

    public  void take(String s, int total, List lst) {
        for (int i = 0; i < lst.size(); i++) {
            List templst=new LinkedList(lst);
            String n =  (String) templst.remove(i);// 取出来的数字
            String str = s + n;
            if (total == 1) {
                //System.out.println(str);//以最极端 n个里面只取一个，直接把取出来的结果输出即可
                list.add(str);


            } else {
                int temp=total-1;//在同一层中total总量不能减,不能再原有变量的基础上
                take(str, temp, templst);// 这里的temp以及templst都是全新的变量和集合
            }
        }

    }

    public List<String> get(int n) {
        String[] s ={"1","2","3","4","5","6","7","8","9"};
        PermutationMN m=new PermutationMN();
        List lst = Arrays.asList(s);
        m.take("",n,lst);
        return list;
    }
}

