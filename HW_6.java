// • Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java. 
// • Создать множество ноутбуков. 
// • Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации и выведет ноутбуки, отвечающие фильтру. 
// Критерии фильтрации можно хранить в Map. Например: // “Введите цифру, соответствующую необходимому критерию: 
// 1 - ОЗУ 
// 2 - Объем ЖД 
// 3 - Операционная система 
// 4 - Цвет …
// • Далее нужно запросить минимальные значения для указанных критериев - сохранить параметры фильтрации можно также в Map. 
// • Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.

import java.util.Set;
import java.util.Map;
import java.util.Objects;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

class Laptop {

    private String name;
    private int ram; // оперативная память
    private int hardDrive; // жесткий диск
    private String os; // операционная система
    private String color; // цвет
    private double diagonal; // диагональ

    public Laptop(String name, int ram, int hardDrive, String os, String color, double diagonal) {
        this.name = name;
        this.ram = ram;
        this.hardDrive = hardDrive;
        this.os = os;
        this.color = color;
        this.diagonal = diagonal;
    }

    @Override
    public String toString() {
        return "Название - " + name + "\n"
                + "Оперативная память - " + ram + "\n"
                + "Объем ЖД - " + hardDrive + "\n"
                + "Операционная система - " + os + "\n"
                + "Цвет - " + color + "\n"
                + "Диагональ - " + diagonal;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Laptop laptop = (Laptop) obj;
        return name.equals(laptop.name) &&
                ram == laptop.ram &&
                hardDrive == laptop.hardDrive &&
                os.equals(laptop.os) &&
                color.equals(laptop.color) &&
                diagonal == laptop.diagonal;
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, ram, hardDrive, os, color, diagonal); // поля должны совпадать с перезаписанным
                                                                        // методом иквелс
    }

    public String getName() {
        return name;
    }

    public int getRam() {
        return ram;
    }

    public int getHardDrive() {
        return hardDrive;
    }

    public String getOs() {
        return os;

    }

    public String getColor() {
        return color;
    }

    public double getDiagonal() {
        return diagonal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public void setHardDrive(int hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setRam(double diagonal) {
        this.diagonal = diagonal;
    }

}

public class HW_6 {
    public static void main(String[] args) {

        Laptop laptop1 = new Laptop("Ноутбук IRBIS NB260", 4, 64, "Windows 10", "черный", 15.6);
        Laptop laptop2 = new Laptop("Ноутбук Echips Envy", 8, 240, "Windows 10 pro", "серый", 15.6);
        Laptop laptop3 = new Laptop("Ноутбук ASUS Vivobook Go 15 OLED E1504FA-L1661", 16, 512, "без ОС", "зеленый", 15.6);
        Laptop laptop4 = new Laptop("Ноутбук ASUS Vivobook 17 X1704ZA-AU106W", 16, 512, "Windows 11", "синий", 17.3);
        Laptop laptop5 = new Laptop("Ноутбук MSI Stealth 14 Studio A13VF-225RU", 16, 1000, "Windows 11", "белый", 14.0);
        Laptop laptop6 = laptop1;


        System.out.println("Имеющиеся в ассортименте ноутбуки: ");
        System.out.println();
        HashSet<Laptop> laptopList = new HashSet<>(Arrays.asList(laptop1, laptop2, laptop3, laptop4, laptop5, laptop6)); 
        for (Laptop laptop : laptopList) {
            System.out.println(laptop);
            System.out.println();
        }
        System.out.printf("Первый ноутбук идентичен шестому: %b \n", laptop1.equals(laptop6));
        System.out.printf("Всего уникалных ноутбуков: %d \n", laptopList.size());
        System.out.println();

        Map<String, Object> filteringOptions = new LinkedHashMap<>();
        filteringOptions.put("1. Объем оперативной памяти больше или равен", 0);
        filteringOptions.put("2. Объем ЖД больше или равен", 0);
        filteringOptions.put("3. Диагональ больше или равна", 0);
    

        Scanner sc = new Scanner(System.in);
        System.out.println("Введите желаемые характеристики: ");
        System.out.println("1. Объем оперативной памяти: ");

        int ramUser = sc.nextInt();
        filteringOptions.put("1. Объем оперативной памяти больше или равен", ramUser);

        System.out.println("2. Oбъем ЖД: ");
        int hdUser = sc.nextInt();
        filteringOptions.put("2. Объем ЖД больше или равен", hdUser);

        System.out.println("3. Диагональ: ");
        double digUser = sc.nextDouble();
        filteringOptions.put("3. Диагональ больше или равна", digUser);
        
        System.out.println();

        System.out.println("Параметры фильтрации: ");
        for (String filterLap : filteringOptions.keySet()) {
            System.out.printf(filterLap + " " + filteringOptions.get(filterLap) + ". ");
            System.out.println();
        }

        System.out.println();
        System.out.println("Данным критериям соответстуют: ");
        System.out.println();

        for (Laptop lap : laptopList) {
            if ((lap.getRam() >= ramUser) && (lap.getHardDrive() >= hdUser) && lap.getDiagonal() >= digUser) {
                System.out.println(lap.toString());
                System.out.println();
            }
        }
        sc.close();
    }
}