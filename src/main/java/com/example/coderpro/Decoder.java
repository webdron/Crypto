package com.example.coderpro;

import java.util.ArrayList;
import java.util.Map;

public class Decoder {
    public Decoder() {

    }

    public static ArrayList<Character> Decode(Map<Integer, Character> map, ArrayList <Character> list, Integer key) {
        for (int i = 0; i < list.size(); i++) {
            int temp = HelloController.getKey(map, list.get(i)) - key;
            if (temp < 0) {
                temp = temp + map.size();
            }
            if (temp >= map.size()) {
                temp = temp % map.size();
            }
            list.set(i, map.get(temp));
        }
        return list;
    }
}
