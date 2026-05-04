package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    addParcel();
                    break;
                case 2:
                    sendParcels();
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("Выберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels
        System.out.println("Укажите тип посылки");
        System.out.println("1 - Стандартная посылка");
        System.out.println("2 - Хрупкая посылка");
        System.out.println("3 - Скоропортящаяся посылка");
        int parcelType = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Опишите товар");
        String parcelDescription = scanner.nextLine();

        System.out.println("Укажите вес посылки");
        double parcelWeight = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Укажите адрес доставки");
        String parcelAddress = scanner.nextLine();

        System.out.println("Укажите день отправки посылки");
        int dayOfDelivery = scanner.nextInt();
        scanner.nextLine();

        switch (parcelType) {
            case (1):
                StandardParcel standardParcel = new StandardParcel(parcelDescription, parcelWeight,
                        parcelAddress, dayOfDelivery);
                allParcels.add(standardParcel);
                break;
            case (2):
                FragileParcel fragileParcel = new FragileParcel(parcelDescription, parcelWeight,
                        parcelAddress, dayOfDelivery);
                allParcels.add(fragileParcel);
                break;
            case (3):
                System.out.println("Для скоропортящейся посылки укажите срок годности");
                int timeToLive = scanner.nextInt();
                PerishableParcel perishableParcel = new PerishableParcel(parcelDescription, parcelWeight,
                        parcelAddress,dayOfDelivery, timeToLive);
                allParcels.add(perishableParcel);
                break;
            default:
                System.out.println("Такого типа посылок нет");
                break;
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            parcel.packageItem();
            parcel.deliver();
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double sum = 0;
        for (Parcel parcel : allParcels) {
            sum += parcel.calculateDeliveryCost();
        }
        System.out.println("Итого стоимость посылок " + sum);
    }

}

