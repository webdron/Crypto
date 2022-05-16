package com.example.coderpro;

import java.util.ArrayList;
import java.util.Map;

public class Encoder {

    public Encoder() {

    }

    public static ArrayList <Character> Encode (Map<Integer, Character> map, ArrayList <Character> list, Integer key) {
        for (int i = 0; i < list.size(); i++) {
            int temp = HelloController.getKey(map, list.get(i)) + key;
            if (temp >= map.size()) {
                temp = temp % map.size();
            }
            if ((temp < 0) && (temp > -map.size())){
                temp = map.size() - Math.abs(HelloController.getKey(map, list.get(i)) - Math.abs(key));
            }
            if (temp <= -map.size()){
                temp = map.size() - Math.abs(temp % map.size()); ;
            }
            list.set(i, map.get(temp));
        }
        return list;
    }
}
