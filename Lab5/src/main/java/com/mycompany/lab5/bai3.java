

package com.mycompany.lab5;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SanPham {
    String ten;
    Double donGia;

    public SanPham(String ten, Double donGia) {
        this.ten = ten;
        this.donGia = donGia;
    }

    public String toString() {
        return "Ten: " + ten + ", Gia: " + donGia;
    }
}

public class bai3 {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<SanPham> list = new ArrayList<>();

    public static void main(String[] args) {
        int chon;
        do {
            menu();
            System.out.print("Chon chuc nang: ");
            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    nhap();
                    break;
                case 2:
                    sapXepVaXuat();
                    break;
                case 3:
                    xoa();
                    break;
                case 4:
                    xuatTrungBinh();
                    break;
                case 5:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Vui long chon tu 1 den 5.");
            }
        } while (chon != 5);
    }

    public static void menu() {
        System.out.println("\n------ MENU ------");
        System.out.println("1. Nhap danh sach san pham");
        System.out.println("2. Sap xep giam dan theo gia va xuat danh sach");
        System.out.println("3. Tim va xoa san pham theo ten");
        System.out.println("4. Xuat gia trung binh cua cac san pham");
        System.out.println("5. Ket thuc");
    }

    public static void nhap() {
        while (true) {
            System.out.print("Nhap ten san pham: ");
            String ten = sc.nextLine();
            System.out.print("Nhap don gia: ");
            Double gia = Double.parseDouble(sc.nextLine());
            list.add(new SanPham(ten, gia));

            System.out.print("Nhap them (Y/N)? ");
            String tiepTuc = sc.nextLine();
            if (tiepTuc.equalsIgnoreCase("N")) {
                break;
            }
        }
    }

    public static void sapXepVaXuat() {
        Comparator<SanPham> comp = new Comparator<SanPham>() {
            
            public int compare(SanPham o1, SanPham o2) {
                return o2.donGia.compareTo(o1.donGia); 
            }
        };

        Collections.sort(list, comp);

        System.out.println("\nDanh sach san pham sap xep giam dan theo gia:");
        for (SanPham sp : list) {
            System.out.println(sp);
        }
    }

    public static void xoa() {
        System.out.print("Nhap ten san pham can xoa: ");
        String tenXoa = sc.nextLine();
        boolean timThay = false;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).ten.equalsIgnoreCase(tenXoa)) {
                list.remove(i);
                System.out.println("Da xoa san pham: " + tenXoa);
                timThay = true;
                break;
            }
        }

        if (!timThay) {
            System.out.println("Khong tim thay san pham co ten: " + tenXoa);
        }
    }

    public static void xuatTrungBinh() {
        if (list.isEmpty()) {
            System.out.println("Khong co san pham nao de tinh trung binh.");
            return;
        }

        double tong = 0;
        for (SanPham sp : list) {
            tong += sp.donGia;
        }

        double trungBinh = tong / list.size();
        System.out.println("Gia trung binh cua cac san pham: " + trungBinh);
    }
}

