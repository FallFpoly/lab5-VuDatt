

package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.Scanner;


public class bai1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();

        while (true) {
            System.out.print("Nhap mot so thuc: ");
            Double x = sc.nextDouble();
            list.add(x);

            System.out.print("Nhap them (Y/N)? ");
            sc.nextLine(); 
            String tiepTuc = sc.nextLine();
            if (tiepTuc.equalsIgnoreCase("N")) {
                break;
            }
        }

        System.out.println("Danh sach da nhap:");
        double tong = 0;
        for (Double so : list) {
            System.out.println(so);
            tong += so;
        }

        System.out.println("Tong = " + tong);
    }
}