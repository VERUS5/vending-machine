package vending_machine;

import java.util.ArrayList;
import java.util.Scanner;

public class user extends vending {

    private double total;
    protected double total_sales;
    Scanner Scanner = new Scanner(System.in);

    public user(int pnum, String pname, int pquntity, double pprice, double total) {
        super(pnum, pname, pquntity, pprice);
        this.total = total;
    }

    public user() {
        super(0, "", 0, 0.0);
    }

    public void chooseproduct(ArrayList<vending> additem) {
        int x, v;

        do {
            System.out.println("----------------------");
            System.out.println("1-Enter product number:\n2-exit");
            System.out.println("----------------------");
            v = Scanner.nextInt();
            switch (v) {
                case 1:
                    displyproudct(additem);
                    System.out.println("----------------------");
                    System.out.println("Enter product number:\n");
                    System.out.println("----------------------");
                    x = Scanner.nextInt();
                    vending index = findpnum(additem, x);
                    if (index.getpquntity() != 0) {
                        if (index != null) {
                            total += index.getpprice();

                            System.out.println("Your total is : " + total);
                            payment(total, index);
                        } else {
                            System.out.println("Proudct Not found");
                        }
                    } else {
                        System.out.println("Proudct is not available");
                    }
                    total = 0;
                    break;
                case 2:
                    System.out.println("Exiting....");
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }
        } while (v != 2);
    }

    public vending findpnum(ArrayList<vending> additem, int x) {
        for (vending v : additem) {
            if (v.getpnum() == x) {
                return v;
            }
        }
        return null;
    }

    public void displyproudct(ArrayList<vending> additem) {
        for (vending v : additem) {
            v.disply();
        }
    }

}
