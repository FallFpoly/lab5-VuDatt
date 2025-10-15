

package com.mycompany.lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class bai2 {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        int chon;
        do {
            menu();
            System.out.print("Chon chuc nang: ");
            chon = sc.nextInt();
            sc.nextLine();
            switch (chon) {
                case 1:
                    nhap();
                    break;
                case 2:
                    xuat();
                    break;
                case 3:
                    ngaunhien();
                    break;
                case 4:
                    sapxep();
                    break;
                case 5:
                    xoa();
                    break;
                case 6:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Vui long chon tu 1 den 6.");
            }
        } while (chon != 6);
    }

    public static void menu() {
        System.out.println("\n------ MENU ------");
        System.out.println("1. Nhap danh sach ho ten");
        System.out.println("2. Xuat danh sach vua nhap");
        System.out.println("3. Xuat danh sach ngau nhien");
        System.out.println("4. Sap xep giam dan va xuat danh sach");
        System.out.println("5. Tim va xoa ho ten");
        System.out.println("6. Ket thuc");
    }

    public static void nhap() {
        while (true) {
            System.out.print("Nhap ho ten: ");
            String hoTen = sc.nextLine();
            list.add(hoTen);
            System.out.print("Nhap them (Y/N)? ");
            String tiepTuc = sc.nextLine();
            if (tiepTuc.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public static void xuat() {
        System.out.println("\nDanh sach ho ten:");
        for (String ten : list) {
            System.out.println(ten);
        }
    }

    public static void ngaunhien() {
        ArrayList<String> copyList = new ArrayList<>(list);
        Collections.shuffle(copyList);
        System.out.println("\nDanh sach ngau nhien:");
        for (String ten : copyList) {
            System.out.println(ten);
        }
    }

    public static void sapxep() {
        Collections.sort(list);              
        Collections.reverse(list);            
        System.out.println("\nDanh sach sap xep giam dan:");
        for (String ten : list) {
            System.out.println(ten);
        }
    }

    public static void xoa() {
        System.out.print("Nhap ho ten can xoa: ");
        String tenCanXoa = sc.nextLine();
        boolean timThay = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(tenCanXoa)) {
                list.remove(i);
                timThay = true;
                System.out.println("Da xoa ho ten: " + tenCanXoa);
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay ho ten: " + tenCanXoa);
        }
    }
}

