package vending_machine;

import java.util.*;

public class operator extends vending {

    Scanner Scanner = new Scanner(System.in);

    public operator(int pnum, String pname, int pquntity, double pprice) {
        super(pnum, pname, pquntity, pprice);
    }

    public operator() {
        super(0, "", 0, 0.0);
    }

    public void op_main(ArrayList<vending> additem) {
        int x;

        do {
            System.out.println("-----------------------------------------------------");
            System.out.println("Enter Choice:\n1-ManageInventory\n2-SalesData\n3-Exit");
            x = Scanner.nextInt();
            switch (x) {
                case 1:
                    mangeinventory(additem);
                    break;
                case 2:
                    SalesData();
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

    public void mangeinventory(ArrayList<vending> additem) {
        int c;
        do {
            System.out.println("----------------------------");
            System.out.println("Please choose");
            System.out.println("1-Add item\n2-Delete item\n3-display all items\n4-Edit price\n5-exit");
            c = Scanner.nextInt();
            switch (c) {
                case 1:

                    System.out.println("Enter proudct number: ");
                    int pnum = Scanner.nextInt();
                    if (ProductNumberExists(additem, pnum)) {
                        System.out.println(
                                "Product with the same number already exists Please enter a different product number");
                    } else {
                        System.out.println("Enter product name: ");
                        String pname = Scanner.next();
                        System.out.println("Enter product price: ");
                        double price = Scanner.nextDouble();
                        additem.add(new vending(pnum, pname, 0, price));
                    }
                    break;
                case 2:

                    for (vending v : additem) {
                        v.disply();
                    }
                    System.out.println("Enter product number:");
                    int dpnum = Scanner.nextInt();
                    Iterator<vending> iterator = additem.iterator();
                    while (iterator.hasNext()) {
                        vending v = iterator.next();
                        if (v.getpnum() == dpnum) {
                            iterator.remove();
                            System.out.println("Item deleted successfully");
                            return;
                        }
                    }
                    System.out.println("Item not found");
                    break;
                case 3:
                    for (vending v : additem) {
                        v.disply();
                    }
                    break;
                case 4:
                    for (vending v : additem) {
                        v.disply();
                    }
                    int new_index_1;
                    System.out.println("Enter Product Number:");
                    new_index_1 = Scanner.nextInt();
                    if (ProductNumberExists_2(additem, new_index_1) != null) {
                        vending new_index = ProductNumberExists_2(additem, new_index_1);
                        edit_price(additem, new_index);
                    } else {
                        System.out.println("Product not found.");
                    }
                    break;
                case 5:
                    System.out.println("----------------------");
                    System.out.println("Exiting....");
                    System.out.println("----------------------");
                    break;
                default:
                    System.out.println("Wrong input");
                    System.out.println("----------------------");
                    break;
            }
        } while (c != 5);

    }

    public boolean ProductNumberExists(ArrayList<vending> additem, int pnum) {
        for (vending v : additem) {
            if (v.getpnum() == pnum) {
                return true;
            }
        }
        return false;
    }

    public vending ProductNumberExists_2(ArrayList<vending> additem, int pnum) {
        for (vending v : additem) {
            if (v.getpnum() == pnum) {
                return v;
            }
        }
        return null;
    }

    public void SalesData() {
        System.out.println("Your total sales are ");
        allsale();
    }

    public void edit_price(ArrayList<vending> additem, vending new_index) {
        double new_price;
        System.out.println("Enter New price:");
        new_price = Scanner.nextDouble();
        for (vending item : additem) {
            if (item.getpnum() == new_index.getpnum()) {
                item.setprice(new_price);
                System.out.println("Price updated successfully!");
                return;
            }
        }
        System.out.println("Product not found.");
    }

}
