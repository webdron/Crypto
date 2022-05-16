package com.example.coderpro;

import java.util.ArrayList;
import java.util.Map;

public class Bruteforce {
    public Bruteforce() {

    }

    public static ArrayList<Character> Bruteforce(Map<Integer, Character> map, ArrayList <Character> list) {
        ArrayList<Character> listResult = new ArrayList<Character>(list);
        for (int i = 0; i <= map.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                int temps;
                temps = HelloController.getKey(map, list.get(j));
                temps = temps + i;
                if (temps >= map.size()) {
                    temps = temps % map.size();
                }
                listResult.set(j, map.get(temps));
            }
            StringBuilder str = new StringBuilder();
            for (char chars : listResult) {
                str.append(chars);
            }
            String temp = str.toString();
            if (temp.contains(" ")
                    && temp.contains(", ")
                    && temp.contains(". ")
                    && !temp.contains("-:")
                    && !temp.contains("  ")
                    &&  !temp.contains(",)")
                    &&  !temp.contains(";;")
                    &&  !temp.contains("?:")
                    &&  !temp.contains(",;")
                    &&  !temp.contains("!;")
            ) {
                return listResult;
            }
            else continue;
        }
        return list;
    }
}