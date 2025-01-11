package org.example.lesson;

public class Intrrr {

    private int a;
    private int tong;

    private Person person1;
    private Person person2;

    public Intrrr(int a) {
        this.a = a;


        person1 = new Person();
        person2 = person1;
    }

    public void tinhtoan(int b) {
        tong = a + b;
        person1.age = tong;
    }

    public int getTong() {
        return tong;
    }

    public Person getPerson2() {
        return person2;
    }

}

class Person {
    int age = 0;
}
