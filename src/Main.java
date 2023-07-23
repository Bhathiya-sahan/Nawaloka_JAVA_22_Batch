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



    }
}