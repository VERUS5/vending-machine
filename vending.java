package vending_machine;

import java.util.*;

public class vending {
    Scanner Scanner = new Scanner(System.in);
    private int pnum;
    private String pname;
    private int pquntity;
    private double pprice;
    protected static double total_sales;

    public vending(int pnum, String pname, int pquntity, double pprice) {
        this.pnum = pnum;
        this.pname = pname;
        this.pquntity = pquntity;
        this.pprice = pprice;
    }

    public int getpnum() {
        return pnum;
    }

    public String getpname() {
        return pname;
    }

    public double getpprice() {
        return pprice;
    }

    public void setprice(double pprice) {
        this.pprice = pprice;
    }

    public int getpquntity() {
        return pquntity;
    }

    public void setpquntity(int pquntity) {
        this.pquntity = pquntity;
    }

    public void disply() {
        System.out.println("----------------------");
        System.out.println("product number: " + pnum);
        System.out.println("product name: " + pname);
        System.out.println("proudct quntity: " + pquntity);
        System.out.println("proudct price: " + pprice);
        System.out.println("----------------------");
    }

    public void displyq() {
        if (pquntity < 1) {
            System.out.println("----------------------");
            System.out.println("product number: " + pnum);
            System.out.println("product name: " + pname);
            System.out.println("PRODUCT NEED RESTOCK ");
            System.out.println("----------------------");
        }
    }

    public void dispensechange(Double total_entered, double user_total) {

        double change = total_entered - user_total;
        System.out.println("Dispens Change:" + change);

    }

    public void payment(double total, vending index) {
        int c;
        double coin_total = 0.0;
        double cash_total = 0.0;
        boolean correct = false;
        int new_pquntity;

        do {
            System.out.println("----------------------------");
            System.out.println("Select payment method:");
            System.out.println("1-coin\n2-cash\n3-card\n4-confirm\n5-cancel");
            c = Scanner.nextInt();

            switch (c) {
                case 1:
                    double quarter = 0.25;
                    double half = 0.50;
                    double reyal = 1.0;
                    double twoReyal = 2.0;

                    int ca;
                    System.out.println("----------------------------");
                    do {

                        System.out.println("Enter coin");
                        System.out.println("1-Quarter\n2-Half\n3-Reyal\n4-Two Reyal\n5-Confirm\n6-Cancel");
                        ca = Scanner.nextInt();

                        switch (ca) {
                            case 1:
                                coin_total += quarter;
                                System.out.println("Total entered: " + coin_total);
                                break;
                            case 2:
                                coin_total += half;
                                System.out.println("Total entered: " + coin_total);
                                break;
                            case 3:
                                coin_total += reyal;
                                System.out.println("Total entered: " + coin_total);
                                break;
                            case 4:
                                coin_total += twoReyal;
                                System.out.println("Total entered: " + coin_total);
                                break;
                            case 5:
                                double change = coin_total - total;
                                if (change < 0) {
                                    System.out.println("----------------------");
                                    System.out.println("You need to enter: " + Math.abs(change) + " more.");
                                } else if (change == 0) {
                                    System.out.println("----------------------");
                                    System.out.println("No change");
                                    System.out.println("----------------------");
                                    correct = true;
                                } else {
                                    dispensechange(coin_total, total);
                                    correct = true;
                                }
                                break;
                            case 6:
                                System.out.println("Cancel Payment........");
                                System.out.println("----------------------");
                                break;
                            default:
                                System.out.println("Wrong input");
                                break;
                        }
                    } while (ca != 5 && ca != 6);
                    break;

                case 2:
                    double five = 5.0;
                    double ten = 10.0;
                    double fifty = 50.0;
                    double onehundred = 100.0;

                    int cc;
                    System.out.println("----------------------------");
                    do {

                        System.out.println("Enter cash");
                        System.out.println(
                                "1-five reyal\n2-ten reyal\n3-fifty reyal\n4-one hundred reyal\n5-confirm\n6-cancel");
                        cc = Scanner.nextInt();

                        switch (cc) {
                            case 1:
                                cash_total += five;
                                System.out.println("Total entered: " + cash_total);
                                break;
                            case 2:
                                cash_total += ten;
                                System.out.println("Total entered: " + cash_total);
                                break;
                            case 3:
                                cash_total += fifty;
                                System.out.println("Total entered: " + cash_total);
                                break;
                            case 4:
                                cash_total += onehundred;
                                System.out.println("Total entered: " + cash_total);
                                break;
                            case 5:
                                double change = cash_total - total;
                                if (change < 0) {
                                    System.out.println("----------------------");
                                    System.out.println("You need to enter: " + Math.abs(change) + " more.");
                                } else if (change == 0) {
                                    System.out.println("----------------------");
                                    System.out.println("No change");
                                    System.out.println("----------------------");
                                    correct = true;
                                } else {
                                    dispensechange(cash_total, total);
                                    correct = true;
                                }
                                break;
                            case 6:
                                System.out.println("Cancel Payment........");
                                System.out.println("----------------------");
                                break;
                            default:
                                System.out.println("Wrong input");
                                System.out.println("----------------------");
                                break;
                        }

                    } while (cc != 5 && cc != 6);
                    break;

                case 3:
                    correct = true;
                    break;
                case 4:
                    if (correct == true) {
                        total_sales += total;
                        dispenseproudct(index);
                        new_pquntity = index.getpquntity();
                        new_pquntity--;
                        index.setpquntity(new_pquntity);
                    }

                    break;

                case 5:
                    System.out.println("Payment canceled.");
                    break;

                default:
                    System.out.println("Wrong input");
                    break;
            }
        } while (c != 5 && c != 4);
    }

    public void dispenseproudct(vending index) {
        System.out.println("----------------------------");
        System.out.println("Payment successful!");
        System.out.println("Dispening " + index.getpname() + " proudct ");
        System.out.println("----------------------------");
    }

    public static void allsale() {
        System.out.println(total_sales);
    }
}