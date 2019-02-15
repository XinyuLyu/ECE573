
package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BruteForce {
    public Map<String, String> map = new HashMap<>();
    public void buildMap(){
        map.put("13","2");
        map.put("46","5");
        map.put("79","8");
        map.put("17","4");
        map.put("28","5");
        map.put("39","6");
        map.put("19","5");
        map.put("37","5");
        map.put("31","2");
        map.put("64","5");
        map.put("97","8");
        map.put("71","4");
        map.put("82","5");
        map.put("93","6");
        map.put("91","5");
        map.put("73","5");

    }
    public int count(int n){
        buildMap();
        PermutationMN permutation = new PermutationMN();// "123456..n"
        List<String> list = permutation.get(n);
        int count = 0;
        for (String item : list){
            boolean found = false;
            for (Map.Entry<String,String> entry : map.entrySet()){
                if (item.contains(entry.getKey()) && !item.substring(0,item.indexOf(entry.getKey())).contains(entry.getValue())) {
                    found = true;
                    break;
                }
            }
            if (!found) count++;
        }
        return count;
    }
}
