package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    protected List<T> parcelInBox = new ArrayList<>();
    protected double currentWeightOfBox = 0;
    protected double maxWeightOfBox;

    public ParcelBox(double maxWeightOfBox) {
        this.maxWeightOfBox = maxWeightOfBox;
    }

    public double getCurrentWeightOfBox() {
        return currentWeightOfBox;
    }

    //Добавляем посылку в коробку
    public boolean addParcel(T newParcel, double parcelWeight) {
           if ((currentWeightOfBox + parcelWeight) > maxWeightOfBox) {
               System.out.println("Грузоподъемность коробки превышена. Посылка не добавлена");
           } else {
               parcelInBox.add(newParcel);
               currentWeightOfBox += parcelWeight;
           }
        return false;
    }

    //Получить все посылки из коробки
    public void getAllParcels() {
        if (!parcelInBox.isEmpty() || this == null) {
            System.out.println("Коробка пуста");
        } else {
            for (T parcel : parcelInBox) {
                System.out.println(parcel);
            }
        }

    }
}
