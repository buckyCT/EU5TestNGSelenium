package com.cybertek.tests.day1_intro;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;

public class FirstClass {

    public static void main(String[] args) {
        //System.out.println("Hello World");

        Faker faker = new Faker();

        System.out.println(faker.name().fullName());
        System.out.println(faker.aviation().aircraft());
        System.out.println(faker.aviation().METAR());
        System.out.println(faker.finance().creditCard(CreditCardType.VISA));
    }
}
