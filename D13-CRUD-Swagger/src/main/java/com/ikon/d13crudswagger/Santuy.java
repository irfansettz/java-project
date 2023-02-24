package com.ikon.d13crudswagger;

import io.swagger.models.auth.In;

import java.util.*;

public class Santuy {
    public static List<Integer> fibonacci(Integer n){
        List<Integer> result = new ArrayList<>();
        result.add(1);
        result.add(1);

        while (result.size() != n){
            result.add(result.get(result.size()-1) + result.get(result.size()-2));
        }
        return result;
    }
    public static Integer factorial(Integer n){
        Integer result = 1;
        for (int i = n; i > 0 ; i--) {
            result *= i;
        }
        return result;
    }
    public static String reverseString(String s){
        String result = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            result += s.charAt(i);
        }
        return result;
    }
    public static Map<String, Map<String, Integer>> countString(String str){
        Map<String, Map<String, Integer>> result = new HashMap<>();
        Set<String> setString = new HashSet<>();
        List<String> listString = new ArrayList<>();
        for (int i = 0; i < str.length()-1; i++) {
            setString.add(String.valueOf(str.charAt(i)));
            listString.add(String.valueOf(str.charAt(i)));
        }

        for (String s: setString) {
            int count = Collections.frequency(listString, s);
            Map<String, Integer> value = new HashMap<>();
            value.put("count", count);
            if (count == 1) {
                value.put("isUnique", 1);
            } else {
                value.put("isUnique", 0);
            }
            result.put(s, value);
        }
        return result;
    }
    public static void main(String[] args) {
//        System.out.println(fibonacci(10));
//        System.out.println(factorial(3));
//        System.out.println(reverseString("contoh"));
        System.out.println(countString("abbbccc"));
    }

}
