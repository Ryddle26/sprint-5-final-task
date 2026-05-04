package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel {

    public FragileParcel(String description, double weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem() {
        System.out.println("Посылка " + this.description + " обёрнута в защитную плёнку");
    }
}
