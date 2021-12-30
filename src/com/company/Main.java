package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CompanySharePrice[] list = Main.takeUserInputs();
        Scanner sc = new Scanner(System.in);
        while (true) {
            Main.printInfo();
            int userChoice = sc.nextInt();
            switch (userChoice) {
                case 0:
                    System.out.println("Exited successfully");
                    break;
                case 1:
                    StockUtility.ascendingSort(list);
                    System.out.println("Stock prices in ascending order are :");
                    StockUtility.print(list);
                    continue;
                case 2:
                    StockUtility.descendingSort(list);
                    System.out.println("Stock prices in descending order are :");
                    StockUtility.print(list);
                    continue;
                case 3:
                    int increasedCount = StockUtility.isIncreased(list);
                    System.out.println("Total no of companies whose stock price rose today : " + increasedCount);
                    continue;
                case 4:
                    int decreasedCount = StockUtility.isDeclined(list);
                    System.out.println("Total no of companies whose stock price declined today : " + decreasedCount);
                    continue;
                case 5:
                    System.out.println("enter the key value");
                    double key = sc.nextDouble();
                    boolean isKeyPresent = StockUtility.isKeyPresent(list, key);
                    String isPresent = isKeyPresent ? "Stock of value " + key + " is " + "present" : "Value not found";
                    System.out.println("Stock of value " + key + " is " + isPresent);
                    continue;
                default:
                    continue;
            }
            break;
        }
    }

    private static CompanySharePrice[] takeUserInputs() {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the no of companies");
        int no = sc.nextInt();
        CompanySharePrice arr[] = new CompanySharePrice[no];
        for (int i =0; i < no; i++) {
            System.out.println("Enter current stock price of the company " + (i+1));
            double price = sc.nextDouble();
            System.out.println("Whether company's stock price rose today compare to yesterday?");
            boolean isIncreased = sc.nextBoolean();
            arr[i] = new CompanySharePrice(price, isIncreased);
        }
        return arr;
    }

    private static void printInfo() {
        System.out.println("-----------------------------------------------------");
        System.out.println("Display the companies stock prices in ascending order");
        System.out.println("Display the companies stock prices in descending order");
        System.out.println("Display the total no of companies for which stock prices rose today");
        System.out.println("Display the total no of companies for which stock prices declined today");
        System.out.println("Search a specific stock price");
        System.out.println("press 0 to exit");
        System.out.println("-----------------------------------------------------");
    }
}
