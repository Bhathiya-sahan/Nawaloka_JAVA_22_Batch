/*  Author:
    ID:

    Start: 00/00/2023    | End:0/00/2023
    Program: Booking management system for ‘Melbourne Cinema (MC)’, a (fictitious) family run cinema. */

//Stage A - Basic ticket booking system.

import java.util.Scanner;  // Import Scanner class to code

public class Main {
    public static void main(String[] args) {

        String category;
        Scanner scan = new Scanner(System.in);

        System.out.println("\n\t\t***************************************");
        System.out.println("\t\t*   Welcome to Melbourne Cinema (MC)  *");       // Display welcome massage, "Melbourne Cinema (MC)" on the program
        System.out.println("\t\t***************************************");
        System.out.println("\n-------------------------------------------------");

        System.out.print("Please Enter Number of Rows : ");
        int number_of_rows = scan.nextInt();
        System.out.print("Please Enter The Date Of The Show : ");
        int date = scan.nextInt();
        scan.nextLine();
        System.out.println("\nPrice Categories For A Seat");
        System.out.println("\tStandard (S)");
        System.out.println("\tPensioner (P)");
        System.out.println("\tFrequent Patrons (F)");
        System.out.print("Enter The Seat Price Category (S/P/F): ");
        category = scan.next();
        System.out.println("\n-------------------------------------------------");

        print_seat(number_of_rows);

    }
    private static void print_seat(int Rows){
        System.out.println("\n\t\t\t\t   *********");
        System.out.println("\t\t\t\t   * STAGE *");             //  print out a header with the word "STAGE" surrounded by stars.
        System.out.println("\t\t\t\t   *********\n");

        for(int i=0 ; i<Rows ; i++){
            System.out.print("\t\t");
            for(int x=0 ; x<5; x++){
                System.out.print(" X ");
            }
            System.out.print(" ");

            for(int x=5 ; x<10; x++){
                System.out.print(" X ");
            }
            System.out.print("\n");
        }
    }

    private static void Receipt(int seat, int Date){
        System.out.println("\t\tReceipt");
        System.out.println("\t\t*******");
        System.out.println("\t\tDate:"+Date);
        System.out.println("\t\tNumber of seats booked : "+seat);
        System.out.println("\t\t"+seat+"* Standard @ $xx.xx =$ ");
        System.out.println("\t\t"+seat+"* Pensioner @ $xx.xx =$ ");
        System.out.println("\t\t"+seat+"* Frequent @ $xx.xx =$ ");
        System.out.println("\t\t\t\tTotal :$ ");

    }

}