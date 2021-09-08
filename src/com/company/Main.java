package com.company;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        ProductManagement productManagement = new ProductManagement();
        do {
            menu();
            System.out.println("Nhập lựa chọn");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1: {
                    productManagement.showAll();
                    break;
                }
                case 2: {
                    Product product = inputProduct();
                    productManagement.add(product);
                    break;
                }
                case 3: {
                    String id = inputId();
                    Product product = inputProduct();
                    productManagement.updateProduct(id, product);
                }
            }
        } while (choice != 9);
    }

    private static Product inputProduct() {
        String id = inputId();
        String name = inputName();
        String priceString = "";
        Pattern pattern = Pattern.compile("^[0-9]*$");
        priceString = inputPrice(pattern);
        double price = Double.parseDouble(priceString);
        String amountString = "";
        amountString = inputAmount(pattern);
        int amount = Integer.parseInt(amountString);
        System.out.println("Nhập mô tả sản phẩm");
        String description = scanner.nextLine();
        Product product = new Product(id, name, price, amount, description);
        return product;
    }

    private static String inputAmount(Pattern pattern) {
        String amountString;
        boolean isMatcher;
        do {
            System.out.println("Nhập số lượng sản phẩm");
            amountString = scanner.nextLine();
            Matcher matcher = pattern.matcher(amountString);
            isMatcher = matcher.find();
            if (!isMatcher) {
                System.err.println("Chỉ được phép nhập số");
            }
        } while (!isMatcher);
        return amountString;
    }

    private static String inputPrice(Pattern pattern) {
        String priceString;
        boolean isMatcher;
        do {
            System.out.println("Nhập giá sản phẩm");
            priceString = scanner.nextLine();
            Matcher matcher = pattern.matcher(priceString);
            isMatcher = matcher.find();
            if (!isMatcher) {
                System.err.println("Chỉ được phép nhập số");
            }
        } while (!isMatcher);
        return priceString;
    }

    private static String inputName() {
        String name = "";
        do {
            System.out.println("Nhập tên sản phẩm");
            name = scanner.nextLine();
            if (name.equals("")) {
                System.err.println("Trường này bắt buộc phải nhập!");
            }
        } while (name.equals(""));
        return name;
    }

    private static String inputId() {
        String id;
        do {
            System.out.println("Nhập mã sản phẩm");
            id = scanner.nextLine();
            if (id.equals("")) {
                System.err.println("Trường này bắt buộc phải nhập!");
            }
        } while (id.equals(""));
        return id;
    }

    private static void menu() {
        System.out.println("Menu quản lý sản phẩm");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Sắp xếp");
        System.out.println("6. Tìm sản phẩm có giá đắt nhất");
        System.out.println("7. Đọc file");
        System.out.println("8. Ghi file");
        System.out.println("9. Thoát");
    }
}
