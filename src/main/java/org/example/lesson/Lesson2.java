package org.example.lesson;

public class Lesson2 {
    // constraints [0, 10]
    // gia tri nguyen thuy - tham tri
    static int a = 0;
    static int b;

    static float pi= 3.14f;
    static float pi1;

    static boolean isDate = false;
    static char character = 'h';

    static String string = "hello world";
    static String string1;

    // gia tri object - tham chieu
//    static Int a1 = new Int(0);
//    static Int a2;

    static int[] arrayInt = {1, 2, 3};
    static int[] array2;


    public static void main(String[] args) {
        b = a;
        System.out.println(a == b); // true

        pi1 = pi;
        System.out.println(pi1 == pi); // true

        string1 = string;
        System.out.println(string == string1); // true

//        a2 = a1;
//        a1.value = 2;
//        System.out.println(a1.value); // 2
//        System.out.println(a2.value);  // 2

        array2 = arrayInt;
        System.out.println(arrayInt);
        System.out.println(array2);

        Intrrr a1 = new Intrrr(1);
        a1.tinhtoan(1);
        System.out.println(a1.getPerson2().age);
    }
}
