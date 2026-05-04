package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();
    private static List<FragileParcel> trackingParcels = new ArrayList<>();
    private static ParcelBox<StandardParcel> standardBox = null;
    private static ParcelBox<PerishableParcel> perishableBox = null;
    private static ParcelBox<FragileParcel> fragileBox = null;

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
                    for (Parcel parcel : allParcels) {
                        if (parcel instanceof FragileParcel) {
                            FragileParcel fragileParcel = (FragileParcel) parcel;
                            trackingParcels.add(fragileParcel);
                        }
                    }
                    break;
                case 3:
                    calculateCosts();
                    break;
                case 4:
                    if (!trackingParcels.isEmpty()) {
                        System.out.println("Укажите где находится посылка на данный момент");
                        String newLocation = scanner.nextLine();
                        for (FragileParcel parcel : trackingParcels) {
                            parcel.reportStatus(newLocation);
                        }
                    } else {
                        System.out.println("Нет посылок в пути");
                    }
                    break;
                case 5:
                    System.out.println("Содержимое обычной коробки");
                    standardBox.getAllParcels();
                    System.out.println("Содержимое коробки с хрупкими посылками");
                    fragileBox.getAllParcels();
                    System.out.println("Содержимое коробки со скоропортящимися посылками");
                    perishableBox.getAllParcels();
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
        System.out.println("4 - Отследить посылки");
        System.out.println("5 - Показать содержимое коробки");
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

        System.out.println("Укажите день доставки посылки");
        int sendDay = scanner.nextInt();
        scanner.nextLine();

        switch (parcelType) {
            case (1):
                StandardParcel standardParcel = new StandardParcel(parcelDescription, parcelWeight,
                        parcelAddress, sendDay);
                allParcels.add(standardParcel);
                standardBox = addToBox(standardBox, standardParcel);
                break;
            case (2):
                FragileParcel fragileParcel = new FragileParcel(parcelDescription, parcelWeight,
                        parcelAddress, sendDay);
                allParcels.add(fragileParcel);
                fragileBox = addToBox(fragileBox, fragileParcel);
                break;
            case (3):
                System.out.println("Для скоропортящейся посылки укажите срок годности");
                int timeToLive = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Укажите также день отправки посылки");
                int currentDay = scanner.nextInt();
                scanner.nextLine();
                PerishableParcel perishableParcel = new PerishableParcel(parcelDescription, parcelWeight,
                        parcelAddress, sendDay, timeToLive);
                if (perishableParcel.isExpired(currentDay)) {
                    allParcels.add(perishableParcel);
                    perishableBox = addToBox(perishableBox, perishableParcel);
                } else {
                    System.out.println("Посылка не успеет дойти до истечения срока годности");
                }
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

    private static <T extends Parcel> ParcelBox<T> addToBox(ParcelBox<T> box, T parcel) {
        if (box == null) {
            System.out.println("Пожалуйста, введите максимальную грузоподъемность коробки");
            double maxWeight = scanner.nextDouble();
            scanner.nextLine();
            box = new ParcelBox<>(maxWeight);
        }
        box.addParcel(parcel, parcel.weight);
        return box;
    }

}

