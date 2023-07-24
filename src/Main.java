/*  Author:
    ID:

    Start: 00/00/2023    | End:0/00/2023
    Program: Booking management system for ‘Melbourne Cinema (MC)’, a (fictitious) family run cinema. */

//Stage A - Basic ticket booking system.

import java.util.Scanner;  // Import Scanner class to code

public class Main {
    public static void main(String[] args) {

        float standard, pensione, frequent;
        Scanner scan = new Scanner(System.in);

        System.out.println("\n-------------------------------------------------");
        System.out.println("\n\t***************************************");
        System.out.println("\t*   Welcome to Melbourne Cinema (MC)  *");       // Display welcome massage, "Melbourne Cinema (MC)" on the program
        System.out.println("\t***************************************");
        System.out.println("\n-------------------------------------------------");

        System.out.print("Please Enter Number of Rows : ");
        int number_of_rows = scan.nextInt();
        System.out.print("Please Enter The Date Of The Show : ");
        String date = scan.next();

        scan.nextLine();
        System.out.println("\nEnter The Seat Price Category");
        System.out.print("\tStandard (S) $ : ");
        standard = scan.nextFloat();
        System.out.print("\tPensioner (P) $ : ");
        pensione = scan.nextFloat();
        System.out.print("\tFrequent Patrons (F) $ : ");
        frequent = scan.nextFloat();
        System.out.println("\n-------------------------------------------------");

        String[][] seat_list = new String[number_of_rows][10];

        for (int i = 0; i < number_of_rows; i++) {
            for (int j = 0; j < 10; j++) {
                seat_list[i][j] = "O";
            }
        }
        buy_ticket(seat_list,date,number_of_rows);
    }
//____________________________ Buy Seat Function ----------------------------------------------------
        private static void buy_ticket(String[][] seat_area, String date, int Rows){
            Scanner scan = new Scanner(System.in);

            System.out.print("How many seat do you need : ");
            int seat = scan.nextInt();

            for(int i=0; i<seat; i++) {
                boolean gate1 = true;
                System.out.println("\nEnter your "+(i+1)+" seat details.");
                while(gate1) {

                    System.out.print("Enter Row Number : ");
                    int row_number = scan.nextInt();
                    System.out.print("Enter Seat Number : ");
                    int seat_number = scan.nextInt();

                    if (seat_area[row_number-1][seat_number-1] == "O") {
                        seat_area[row_number-1][seat_number-1] = "X";
                        gate1=false;
                    }
                    else {
                        System.out.println("This Seat also booked, try another one.");
                    }
                }
            }
            System.out.println("\nYour seats are booked.\nThanks for join with us");
            System.out.println("\n-------------------------------------------------");
            print_seat(seat_area, Rows);
            receipt(seat,date);
        }

//____________________________ Print Seat Function ----------------------------------------------------

    private static void print_seat(String[][] seat_area, int Rows){
        System.out.print("\n\t\t\t\t *********");
        System.out.println("\t  \"X\"- Unavailable");
        System.out.print("\t\t\t\t * STAGE *");             //  print out a header with the word "STAGE" surrounded by stars.
        System.out.println("\t  \"O\"- available");
        System.out.println("\t\t\t\t *********\n");

        for(int i=0 ; i<Rows ; i++){
            System.out.print("\t");
            for(int x=0 ; x<5; x++){
                System.out.print(" "+seat_area[i][x]+" ");
            }
            System.out.print("\t\t");

            for(int x=5 ; x<10; x++){
                System.out.print(" "+seat_area[i][x]+" ");
            }
            System.out.print("\n");
        }
        System.out.println("\n-------------------------------------------------");
    }


    //____________________________ Receipt Function ----------------------------------------------------

    private static void receipt(int seat, String Date){
        System.out.println("\n\t\tReceipt");
        System.out.println("\t\t*******\n");
        System.out.println("\t\tDate : "+Date);
        System.out.println("\t\tNumber of seats booked : "+seat);
        System.out.println("\t\t"+seat+"* Standard @ $xx.xx =$ ");
        System.out.println("\t\t"+seat+"* Pensioner @ $xx.xx =$ ");
        System.out.println("\t\t"+seat+"* Frequent @ $xx.xx =$ ");
        System.out.println("\t\t\t\tTotal :$ ");
        System.out.println("\n-------------------------------------------------");
    }

}