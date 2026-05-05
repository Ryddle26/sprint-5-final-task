package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel implements Trackable {

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public int getBaseCost() {
        return 4;
    }

    @Override
    public void packageItem() {
        super.packageItem();
        System.out.println("Посылка " + this.description + " обёрнута в защитную плёнку");
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.println("Хрупкая посылка " + description + " изменила местоположение на " + newLocation);
    }


}
