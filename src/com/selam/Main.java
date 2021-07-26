package com.selam;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//      Scanner scanner = new Scanner(System.in);
//        System.out.print("Number: ");
//        int number = scanner.nextInt();
//
//        if( number % 5 == 0 && number % 3 == 0)
//            System.out.println("FizzBuzz");
//        else if (number % 5 == 0)
//            System.out.println("Fizz");
//        else if (number % 3 == 0)
//            System.out.println("Buzz");
//
//        else
//            System.out.println(number);
       final byte MONTHS_IN_YEAR = 12;
       final byte PERCENT = 100;

       int principal = 0;
       float monthlyInterest = 0;
       int numberOfPayments = 0;

       Scanner scanner = new Scanner(System.in);

       while (true) {
           System.out.print("Principal: ");
           principal = scanner.nextInt();
           if (principal >= 1000 && principal <=1_000_000)
               break;
           System.out.println("Enter a value between 1000 and 1000000");
       }

       while(true) {
           System.out.print("Annual Interest Rate: ");
           float annualInterest = scanner.nextFloat();
           if (annualInterest >= 1 && annualInterest <=30) {
              monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;
               break;
           }
           System.out.println("Enter a value between 1 and 30");
       }

       while(true) {
           System.out.print("Period (Years): ");
           byte years = scanner.nextByte();
           if (years >=1 && years <=30) {
               numberOfPayments = years * MONTHS_IN_YEAR;
               break;
           }
           System.out.println("Enter a year between 1 and 30.");

       }
        double mortgage = principal
                * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                / (Math.pow(1 + monthlyInterest, numberOfPayments) -1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + mortgageFormatted);
    }
}
