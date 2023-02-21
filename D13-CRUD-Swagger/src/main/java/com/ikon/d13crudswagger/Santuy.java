package com.ikon.d13crudswagger;

import java.util.ArrayList;
import java.util.List;

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
    public static void main(String[] args) {
//        System.out.println(fibonacci(10));
        System.out.println(factorial(3));
    }
}
