/*  Author:
    ID:

    Start: 00/00/2023    | End:0/00/2023
    Program: Booking management system for ‘Melbourne Cinema (MC)’, a (fictitious) family run cinema. */

//Stage A - Basic ticket booking system.

import java.util.Date;
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
//____________________________ Start ----------------------------------------------------
        boolean gate1 = true;
        while (gate1) {// Get while loop to repeat menu part
            int option;
            System.out.println("\n-------------------------------------------------");
            System.out.println("Please select an option:\n");
            System.out.println("1) Buy a ticket");
            System.out.println("2) Print seating area");
            System.out.println("3) Cancel ticket");
            System.out.println("0) Quit");
            System.out.println("-------------------------------------------------\n");

            try {
                System.out.print("Enter option: ");//Display to user to "Enter option: "
                option = scan.nextInt();        //Get user input to variable name "option"
                System.out.println(" ");
                switch (option) {       // Use switch case and assign "option" variable for parameter of switch case
                    case 1 -> buy_ticket(seat_list,date,number_of_rows);             // In case 1,call to buy_ticket method
                    case 2 -> print_seat(seat_list,number_of_rows);     // In case 2,call to print_seating_area method
                    case 3 -> cancel_ticket(seat_list,number_of_rows,date);          // In case 3,call to cancel_ticket method
                    case 0 -> {
                        System.out.println("\t\t>> Thank you for join with us <<");
                        gate1 = false;
                    }                                                             // In case 0,Assign false value to check variable, this case use to quit e program
                    default ->
                            System.out.println("\t>> Invalid Option, Please Enter Valid Option <<");  // In default case, Display error message which is inputs are invalid
                }
            } catch (Exception e) {
                System.out.println("\t\t>> Invalid Option, Please Enter Valid Option <<");
            }
            scan.nextLine();
        }
    }
//____________________________ Buy Seat Function ----------------------------------------------------
        private static void buy_ticket(String[][] seat_area, String date, int Rows){
            Scanner scan = new Scanner(System.in);

            System.out.print("How many seat do you need : ");
            int seat = scan.nextInt();

            for(int i=0; i<seat; i++) {
                boolean gate2 = true;
                System.out.println("\nEnter your "+(i+1)+" seat details.");
                while(gate2) {

                    System.out.print("Enter Row Number : ");
                    int row_number = scan.nextInt();
                    System.out.print("Enter Seat Number : ");
                    int seat_number = scan.nextInt();

                    if (seat_area[row_number-1][seat_number-1] == "O") {
                        seat_area[row_number-1][seat_number-1] = "X";
                        gate2=false;
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


    //____________________________ Cancel Ticket Function ----------------------------------------------------
    private static void cancel_ticket(String[][] seat_area, int Rows,String date) {       // Declares a privet method called cancel_ticket() method for cancel booked tickets
        print_seat(seat_area, Rows);                            // Call print_seat method

        Scanner scan2 = new Scanner(System.in);     //Create a new object name "scan2" to get user input by using Scanner class

        try {
            System.out.print("How many seat do you need to cancel : ");
            int seat = scan2.nextInt();

            int count =0;
            for(int i=0 ; i<Rows ; i++) {
                for (int x = 0; x < 10; x++) {
                    if(seat_area[i][x] == "X"){
                        count++;
                    }
                }
            }

            if(seat <=count ) {
                for (int j = 0; j < seat; j++) {
                    System.out.println("\nEnter your " + (j + 1) + " seat details which do you need to cancel.");
                    boolean gate3 = true;
                    while (gate3) {
                        try {                                       // Use exception to recover invalid input
                            System.out.print("\nRow number : ");    // Ask user which row his canceling ticket locating
                            int row_number = scan2.nextInt();           // Assign Row number to row_number variable
                            if (0 < row_number && row_number <= Rows) {
                                try {
                                    System.out.print("Seat number : ");    // Ask user which row his canceling ticket locating
                                    int seat_number = scan2.nextInt();           // Assign Row number to row_number variable
                                    if (0 < seat_number && seat_number < 11) {
                                        if(seat_area[row_number - 1][seat_number - 1]=="X") {
                                            seat_area[row_number - 1][seat_number - 1] = "O";
                                            gate3 = false;
                                        }else {
                                            System.out.println("Invalid seat. This Seat is not booked.");
                                            gate3 = false;
                                            j = seat;
                                        }
                                    } else if (seat_number == 0000) {
                                        gate3 = false;
                                        j = seat;
                                    } else {
                                        System.out.println("\t>>Invalid Seat Number,Enter Valid Seat(1-10) <<");
                                    }
                                } catch (Exception e) {
                                    System.out.println("\t>>Invalid Seat Number,Seat number must be an integer <<");
                                }
                            } else if (row_number == 0000) {
                                gate3 = false;
                                j = seat;
                            } else {
                                System.out.println("\t>>Invalid Row Number,Enter Valid Row(1-" + Rows + ") <<");
                            }
                        } catch (Exception e) {
                            System.out.println("\t>>Invalid Row Number,Row number must be an integer <<");}          // Exception output
                    }
                }
                System.out.println("\nYour seats are cancel.\nThanks for join with us");
                receipt(seat, date);
            }else {
                System.out.println("\nYour have not book enough seat");}
        }catch (Exception e){
            System.out.println("\t>>Invalid Seats,it must be an integer <<");
        }
    }

//____________________________ Print Seat Function ----------------------------------------------------

    private static void print_seat(String[][] seat_area, int Rows){
        System.out.print("\n\t\t\t\t\t\t**********");
        System.out.println("\t  \"B\"- Unavailable");
        System.out.print("\t\t\t\t\t\t * SCREEN *");             //  print out a header with the word "STAGE" surrounded by stars.
        System.out.println("\t  \"-\"- available");
        System.out.println("\t\t\t\t\t\t**********\n");

       //----- First line------

        for(int i=0 ; i<1 ; i++){
            System.out.print("\t\t");
            for(int x=0 ; x<5; x++){
                if(seat_area[i][x] == "O") {
                    System.out.print(" " + (x + 1) + ":-");
                }else {
                    System.out.print(" " + (x + 1) + ":B");
                }
            }
            System.out.print("\t");

            for(int x=5 ; x<10; x++){
                if(seat_area[i][x] == "O") {
                    System.out.print(" " + (x + 1) + ":-");
                }else {
                    System.out.print(" " + (x + 1) + ":B");
                }
            }
            System.out.print("\n");
        }
//-------Other Lines-----------
        for(int i=1 ; i<Rows ; i++){
            System.out.print("\t");
            for(int x=0 ; x<5; x++){
                if(seat_area[i][x] == "O") {
                    System.out.print(" " + (((i*10)+x) + 1) + ":-");
                }else {
                    System.out.print(" " + (((i*10)+x) + 1) + ":B");
                }
            }
            System.out.print("\t");

            for(int x=5 ; x<10; x++){
                if(seat_area[i][x] == "O") {
                    System.out.print(" " + (((i*10)+x) + 1) + ":-");
                }else {
                    System.out.print(" " + (((i*10)+x) + 1) + ":B");
                }
            }
            System.out.print("\n");
        }

        int count =0;
        for(int i=0 ; i<Rows ; i++) {
            for (int x = 0; x < 10; x++) {
                if(seat_area[i][x] == "O"){
                    count++;
                }
            }
        }
        System.out.println("\nNumber of available seats: "+count);

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