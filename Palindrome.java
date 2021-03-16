package com.company;
import java.util.Scanner;

public class Palindrome {
    public static void main(String[] args) {
        //ввод слов на проверку
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split("\\s");
        //перебираем массив слов, проверяя является ли слово палиндромом
        for (String word : words) {
            System.out.println(word + " " + isPalindrome(word));
        }
    }

    //Метод, который возвращает строку в обратном порядке
    public static String reverseString(String s){
        String reverseS = "";
        for (int i = s.length()-1; i >= 0; i--){
            reverseS += s.charAt(i);
        }
        return reverseS;
    }

    //Если слово является полиндромом, то возвращаем true, false в ином случае
    public static boolean isPalindrome(String s){
        s = s.toLowerCase();
        String reverseS = reverseString(s);
        return reverseS.equals(s);
    }
}
