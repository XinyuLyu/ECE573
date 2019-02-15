package com.company;

public class SmartWay {
    public int numberOfPatterns(int m, int n) {
        return count(m, n, 0, 1, 1, 1, 1);
    }
    public int count(int m, int n, int used, int i1, int j1, int i2, int j2) {
        int number=0;
        if(m<=0)//m为0规定为一
        {
            number=1;
        }
        if(n==0)//结束条件
        {
            return 1;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int I = i2 + i, J = j2 + j, used2 = used | (1 << (i * 3 + j));
                if (used2 > used && ((I % 2)==1 || (J % 2)==1 || (used2 & (1 << (I / 2 * 3 + J / 2)))!=0 ))
                    number += count(m - 1, n - 1, used2, i2, j2, i, j);
            }
        }
        return number;
    }
}
