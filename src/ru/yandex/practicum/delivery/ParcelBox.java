package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    private List<T> parcelInBox = new ArrayList<>();
    private double currentWeightOfBox = 0;
    private double maxWeightOfBox;

    public ParcelBox(double maxWeightOfBox) {
        this.maxWeightOfBox = maxWeightOfBox;
    }

    public double getCurrentWeightOfBox() {
        return currentWeightOfBox;
    }

    //Добавляем посылку в коробку
    public boolean addParcel(T newParcel) {
           if ((currentWeightOfBox + newParcel.getWeight()) > maxWeightOfBox) {
               System.out.println("Грузоподъемность коробки превышена. Посылка не добавлена");
           } else {
               parcelInBox.add(newParcel);
               currentWeightOfBox += newParcel.getWeight();
           }
        return false;
    }

    //Получить все посылки из коробки
    public void getAllParcels() {
        if (parcelInBox.isEmpty()) {
            System.out.println("Коробка пуста");
        } else {
            for (T parcel : parcelInBox) {
                System.out.println(parcel);
            }
        }

    }
}
