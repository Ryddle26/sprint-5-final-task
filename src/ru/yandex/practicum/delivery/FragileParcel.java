package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {

    public FragileParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + this.description + " обёрнута в защитную плёнку");
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }


}
