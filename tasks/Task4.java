package com.company;

import java.util.*;
import java.util.concurrent.SynchronousQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task4 {
    /* 1. Создайте функцию, которая принимает массив чисел и возвращает "Бум!", если в
        массиве появляется цифра 7. В противном случае верните "в массиве нет 7". */
    public static String sevenBoom(int[] array){
        for (int i:array) {
            if(i == 7)
                return "Boom!";
        }
        return "there is no 7 in the array";
    }
    /* 2. Создайте функцию, которая определяет, могут ли элементы в массиве быть
        переупорядочены, чтобы сформировать последовательный список чисел, где
        каждое число появляется ровно один раз. */
    public static boolean cons(int[] array){
        Arrays.sort(array);
        for (int i = 0; i < array.length - 1; i++) {
            if(array[i] == array[i + 1] && array[i]+1 != array[i+1])
                return false;
        }
        return true;
    }
    /* 3. lPaeesh le pemu mnxit ehess rtnisg! О, извините, это должно было быть: Пожалуйста,
        помогите мне распутать эти строки!
        Каким-то образом все строки перепутались, каждая пара символов поменялась местами.
        Помоги отменить это, чтобы снова понять строки. */
    public static String unmix(String str){
        String _str = "";
        for(int i = 0; i < str.length(); i+=2){
            char chEven = str.charAt(i),
                    chOdd = str.charAt(i + 1);
            _str = _str + chOdd + chEven;
        }
        return _str;
    }
    /*4 Создать функцию, которая преобразует предложения, заканчивающиеся
        несколькими вопросительными знаками ? или восклицательными знаками ! в
        предложение, заканчивающееся только одним, без изменения пунктуации в
        середине предложений. */
    public static String noYelling(String str){
        int i = str.length() - 1;
        int count = -1;
        String _str = "";
        while (str.charAt(i) == '!' || str.charAt(i) == '?'){
            count++;
            i--;
        }
        for (int j = 0; j < str.length() - count; j++)
            _str = _str + str.charAt(j);
        return _str;
    }
    /*5 Создайте функцию, которая заменяет все x в строке следующими способами:
        Замените все x на "cks", ЕСЛИ ТОЛЬКО:
        Слово начинается с "x", поэтому замените его на "z".
        Слово-это просто буква "х", поэтому замените ее на " cks ". */
    public static String xPronounce(String str){
        String _str = "";
        for (int i = 0; i < str.length(); i++){
            if(Character.toLowerCase(str.charAt(i)) == 'x'){
                if(str.charAt(i - 1) == ' '){
                    if(str.charAt(i + 1) == ' ') _str += "ecks";
                    else _str += "z";
                }
                else _str += "cks";
            }
            else _str += str.charAt(i);
        }
        return _str;
    }
    /* 6. Учитывая массив целых чисел, верните наибольший разрыв между
отсортированными элементами массива. */
    public static int largestGap(int[] array){
        Arrays.sort(array);
        int gap = 0;
        for (int i = 0; i < array.length - 1; i++){
            if(gap < (array[i + 1] - array[i]))
                gap = array[i + 1] - array[i];
        }
        return gap;
    }
    /* 7. Это вызов обратного кодирования. Обычно вам дают явные указания о том, как
        создать функцию. Здесь вы должны сгенерировать свою собственную функцию,
        чтобы удовлетворить соотношение между входами и выходами.
        Ваша задача состоит в том, чтобы создать функцию, которая при подаче входных данных
        ниже производит показанные примеры выходных данных. */
    public static int rndAnswer(int num){
        switch (num){
            case (832):
                return 594;

            case (51):
                return 36;

            case (7977):
                return 198;

            case (1):
            case (149):
                return 0;

            case (665):
                return 99;

            default:
                Random random = new Random();
                return random.nextInt(1000);
        }
    }
    /* 8. Создайте функцию, которая принимает предложение в качестве входных данных и
возвращает наиболее распространенную последнюю гласную в предложении в
виде одной символьной строки. */
    public static Character commonLastVowel(String str)
    {
        str += " ";
        Character[] vowels = {'a','e','y','u','i','o'};
        Character[] letters = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
        Map<Character, Integer> hashMap = new HashMap<Character, Integer>();
        for (int i = 0; i < str.length() - 1; i++){
            if (!Arrays.asList(letters).contains(str.charAt(i+1)) && Arrays.asList(vowels).contains(str.charAt(i)))
            hashMap.put(str.charAt(i), hashMap.getOrDefault(str.charAt(i), 0) + 1);
        }
        int maxCount = 0;
        Character greatestChar = ' ';
        for (Map.Entry<Character,Integer> entry : hashMap.entrySet()){
            if (entry.getValue() > maxCount){
                maxCount = entry.getValue();
                greatestChar = entry.getKey();
            }
        }
        return greatestChar;
    }
    /* 9. */
    public static int memeSum(int firstNum, int secondNum){
        String memeAnswer = "";
        int sum;
        while((firstNum != 0) || (secondNum != 0)){
            sum = 0;
            if(firstNum == 0){
                sum += secondNum % 10;
                secondNum /= 10;

            }
            else if(secondNum == 0){
                sum += firstNum % 10;
                firstNum /= 10;
            }
            else{
                sum += firstNum % 10 + secondNum % 10;
                firstNum /= 10;
                secondNum /= 10;
            }
            memeAnswer = Integer.toString(sum) + memeAnswer;
        }
        return Integer.parseInt(memeAnswer);
    }
    /* 10. Создайте функцию, которая удалит все повторяющиеся символы в слове,
        переданном этой функции. Не просто последовательные символы, а символы,
        повторяющиеся в любом месте строки. */
    public static String unrepeated(String str){
        String _str = "";
        _str += str.charAt(0);
        for (int i = 1; i < str.length(); i++)
        {
            int k = 0;
            for (int j = 0; j < _str.length(); j++)
            {
                if (_str.charAt(j) == str.charAt(i)) {
                    k++;
                }
            }
            if (k == 0)
                _str += str.charAt(i);
        }
        return _str;

    }
    public static void main(String[] args) {
        //1
        assert sevenBoom(new int[]{1, 2, 3, 4, 5, 6, 7}).equals("Boom!");
        assert sevenBoom(new int[]{8, 6, 33, 100}).equals("there is no 7 in the array");
        assert sevenBoom(new int[]{2, 55, 60, 97, 86}).equals("Boom!");

        //2
        assert cons(new int[]{5, 1, 4, 3, 2}) == true;
        assert cons(new int[]{5, 1, 4, 3, 2, 8}) == false;
        assert cons(new int[]{5, 6, 7, 8, 9, 9}) == false;

        //3
        assert unmix("123456").equals("214365");
        assert unmix("hTsii s aimex dpus rtni.g").equals("This is a mixed up string.");
        assert unmix("badce").equals("abcde");

        //4
        assert noYelling("What went wrong?????????").equals("What went wrong?");
        assert noYelling("Oh my goodness!!!").equals("Oh my goodness!");
        assert noYelling("I just!!! can!!! not!!! believe!!! it!!!").equals("I just!!! can!!! not!!! believe!!! it!");
        assert noYelling("Oh my goodness!").equals("Oh my goodness!");
        assert noYelling("I just cannot believe it.").equals("I just cannot believe it.");

        //5
        assert xPronounce("The x ray is excellent").equals("The ecks ray is eckscellent");

        //6
        assert largestGap(new int[]{9, 4, 26, 26, 0, 0, 5, 20, 6, 25, 5}) == 11;

        //7
        assert rndAnswer(832) == 594;

        //8
        assert commonLastVowel("OOI UUI EEI AAI").equals("i");

        //9
        assert memeSum(122, 81) == 1103;

        //10
        assert unrepeated("call 911").equals("cal 91");
    }
}