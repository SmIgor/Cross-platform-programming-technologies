package com.company;

public class Main {

    public static void main(String[] args) {
        //перебираем числа от 2 до 100 включительно, если число простое, то выводим его на экран
        for (int i = 2; i <= 100; i++){
            if (isPrime(i))
                System.out.print(i + "; ");
        }
    }

    //Метод возвращает true, если число является простым; false, если нет
    public static boolean isPrime(int n){
        //перебираем числа от 2 до n, если n делится на число без остатка, то оно не является простым
        for (int i = 2; i < n; i++){
            if (n % i == 0)
                return false;
        }
        return true;
    }
}
