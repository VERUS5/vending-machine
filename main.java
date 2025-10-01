package vending_machine;

import java.util.ArrayList;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        operator op = new operator();
        user us = new user();
        supplier su = new supplier();
        ArrayList<vending> additem = new ArrayList<vending>();
        additem.add(new vending(1, "Water", 0, 1.0));
        Scanner Scanner = new Scanner(System.in);
        int x;
        do {

            System.out.println("\n\n\t\t\t_________________________________________________________\n");
            System.out.println("\t\t\t|  SEC 9  |	 	  	            |  Dr.Majed |\n");
            System.out.println("\t\t\t|                                                       |\n");
            System.out.println("\t\t\t|	              WELCOME TO                        |\n");
            System.out.println("\t\t\t|                G266 vending machine                   |\n");
            System.out.println("\t\t\t|_______________________________________________________|\n");
            System.out.println("\t\t\t| Ibrahim Alborsias  |   	 	    | 222408866 |\n");
            System.out.println("\t\t\t| Anas AL-jumaiah    |	 	  	    | 222421482 |\n");
            System.out.println("\t\t\t| Abdullah Alhassawi |	 	  	    | 222409700 |\n");
            System.out.println("\t\t\t| khalid  almuhaysh|	 	  	    | 222408131 |\n");
            System.out.println("\t\t\t_________________________________________________________\n");

            System.out.println("\n\t\t\t\t\t    MAIN MENU\n");
            System.out.println("\t\t\t\t\t___________________ \n");
            System.out.println("\t\t\t\t\t1. Customer\n");
            System.out.println("\t\t\t\t\t2. Operator\n");
            System.out.println("\t\t\t\t\t3. Supplier\n");
            System.out.println("\t\t\t\t\t4. EXIT\n");
            System.out.println("\t\t\t\t\tENTER YOUR CHOICE from 1 to 4 : ");

            x = Scanner.nextInt();
            switch (x) {
                case 1:
                    us.chooseproduct(additem);
                    break;
                case 2:
                    // password
                    System.out.println("----------------------------");
                    System.out.println("please enter password");
                    int password = Scanner.nextInt();
                    if (password == 123) {
                        op.op_main(additem);
                    } else {
                        System.out.println("password incorrect");
                    }
                    break;
                case 3:
                    System.out.println("----------------------------");
                    System.out.println("please enter password");
                    int password1 = Scanner.nextInt();
                    if (password1 == 123) {
                        su.su_main(additem);
                    } else {
                        System.out.println("password incorrect");
                    }
                    su.su_main(additem);
                    break;
                case 4:
                    System.out.println("Exiting....");
                    break;
                default:
                    break;
            }

        } while (x != 4);
    }

}
