package org.example.lesson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class Example {
    public static void main(String[] args) {
        char operator;
        double number1, number2, result;

        while (true) {

            // create an object of Scanner class
            Scanner input = new Scanner(System.in);
            WriteFile writer = new WriteFile();

//            FileWriter writer = new FileWriter("D:/WorkSpace/java_bt/example.txt");
//
//            try {
//                writer.write("Welcome to java");
//                writer.close();
//            }catch (Exception e){
//                System.out.println(e);
//            }
//            System.out.println("Success....");
            // ask users to enter operator
            System.out.println("Choose an operator: +, -, *, /, % or !");
            System.out.println("If you want to close calculator, please choose X");
            operator = input.next().charAt(0);

            if (operator == 'X') {
                System.out.println("Close calculator");
                input.close();
                break;
            } else if (operator == '!') {
                System.out.println("Enter number");
                double number = input.nextDouble();
                result = 1;
                if (number > 1) {
                    for (int i = 1; i <= number; i++) {
                        result = result * i;
                    }
                }
                System.out.println(number + "! = " + result);
                writer.writeFile(number + "! = " + result);
//                writer.write(number + "! = " + result);
            } else {
                // ask users to enter numbers
                System.out.println("Enter first number");
                number1 = input.nextDouble();

                System.out.println("Enter second number");
                number2 = input.nextDouble();

                switch (operator) {

                    // performs addition between numbers
                    case '+' -> {
                        result = number1 + number2;
                        System.out.println(number1 + " + " + number2 + " = " + result);
                        writer.writeFile(number1 + " + " + number2 + " = " + result);
                    }

                    // performs subtraction between numbers
                    case '-' -> {
                        result = number1 - number2;
                        System.out.println(number1 + " - " + number2 + " = " + result);
                        writer.writeFile(number1 + " - " + number2 + " = " + result);

                    }

                    // performs multiplication between numbers
                    case '*' -> {
                        result = number1 * number2;
                        System.out.println(number1 + " * " + number2 + " = " + result);
                        writer.writeFile(number1 + " * " + number2 + " = " + result);

                    }

                    // performs division between numbers
                    case '/' -> {
                        result = number1 / number2;
                        System.out.println(number1 + " / " + number2 + " = " + result);
                        writer.writeFile(number1 + " / " + number2 + " = " + result);

                    }
                    case '%' -> {
                        result = number1 % number2;
                        System.out.println(number1 + " % " + number2 + "=" + result);
                        writer.writeFile(number1 + " % " + number2 + " = " + result);

                    }
                    default -> System.out.println("Invalid operator!");
                }
            }
        }
    }
}
class WriteFile{
    void writeFile(String result){
        try {
            FileWriter writer = new FileWriter("D:/WorkSpace/java_bt/example.txt", true);
            writer.write(result + "\n");
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}