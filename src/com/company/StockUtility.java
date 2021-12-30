package com.company;

public class StockUtility {
    public static void ascendingSort(CompanySharePrice[] list) {
        StockUtility.mergeSort(list, 0, list.length - 1);
    }

    public static void descendingSort(CompanySharePrice[] list) {
        StockUtility.mergeSort(list, 0, list.length - 1);
        for (int i = 0; i < list.length/2; i++ ) {
            CompanySharePrice temp = list[i];
            list[i] = list[list.length - 1 - i];
            list[list.length - 1 - i] = temp;
        }
    }

    public static void merge(CompanySharePrice[] arr, int l, int mid, int r) {
        int no1 = mid - l + 1;
        int no2 = r - mid;

        CompanySharePrice[] list1 = new CompanySharePrice[no1];
        CompanySharePrice[] list2 = new CompanySharePrice[no2];

        for (int i = 0; i < no1; i++) {
            list1[i] = arr[l + i];
        }

        for (int i = 0; i < no2; i++) {
            list2[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = l;
        while (i < no1 && j < no2) {
            if (list1[i].getPrice() < list2[j].getPrice()) {
                arr[k] = list1[i];
                i++;
            } else {
                arr[k] = list2[j];
                j++;
            }
            k++;
        }
        while (i < no1) {
            arr[k] = list1[i];
            k++;
            i++;
        }
        while (j < no2) {
            arr[k] = list2[j];
            k++;
            j++;
        }
    }

    public static void mergeSort(CompanySharePrice[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            StockUtility.mergeSort(arr, l, mid);
            StockUtility.mergeSort(arr, mid + 1, r);

            StockUtility.merge(arr, l, mid, r);
        }
    }

    public static void print(CompanySharePrice[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i].getPrice() + " ");
        }
        System.out.print("\n");
    }

    private static int countDeclinedOrIncreased(CompanySharePrice[] arr, boolean isIncreased) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].isIncreased() == isIncreased) {
                count++;
            }
        }
        return count;
    }

    public static int isDeclined(CompanySharePrice[] arr) {
        return StockUtility.countDeclinedOrIncreased(arr, false);
    }

    public static int isIncreased(CompanySharePrice[] arr) {
        return StockUtility.countDeclinedOrIncreased(arr, true);
    }

    public static boolean isKeyPresent(CompanySharePrice[] arr, double key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getPrice() == key) {
                return true;
            }
        }
        return false;
    }
}
