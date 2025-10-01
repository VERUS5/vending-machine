package vending_machine;

import java.util.ArrayList;
import java.util.Scanner;

public class supplier extends operator {
    public void su_main(ArrayList<vending> additem) {
        Scanner Scanner = new Scanner(System.in);
        int x;
        do {
            System.out.println("----------------------------");
            System.out.println("Please choose\n1-Edit Quntity\n2-See notification\n3-Exit");
            x = Scanner.nextInt();
            switch (x) {
                case 1:
                    for (vending v : additem) {
                        v.disply();
                    }
                    int new_index_1;
                    System.out.println("Enter Product Number:");
                    new_index_1 = Scanner.nextInt();
                    if (ProductNumberExists_3(additem, new_index_1) != null) {
                        vending new_index = ProductNumberExists_3(additem, new_index_1);
                        edit_quntity(additem, new_index);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;

                case 2:
                    see_notification(additem);

                    break;
                case 3:
                    System.out.println("----------------------");
                    System.out.println("Exiting....");
                    System.out.println("----------------------");
                    break;
                default:
                    System.out.println("Wrong input");
                    break;
            }

        } while (x != 3);
    }

    public void edit_quntity(ArrayList<vending> additem, vending new_index) {
        int new_quntity;
        System.out.println("Enter New quntity:");
        new_quntity = Scanner.nextInt();
        for (vending item : additem) {
            if (item.getpnum() == new_index.getpnum()) {
                item.setpquntity(new_quntity);
                System.out.println("Quntity updated successfully!");
                return;
            }
        }
        System.out.println("Product not found.");
    }

    public vending ProductNumberExists_3(ArrayList<vending> additem, int pnum) {
        for (vending v : additem) {
            if (v.getpnum() == pnum) {
                return v;
            }
        }
        return null;
    }

    public void see_notification(ArrayList<vending> additem) {

        for (vending v : additem) {
            v.displyq();
        }
    }
}
