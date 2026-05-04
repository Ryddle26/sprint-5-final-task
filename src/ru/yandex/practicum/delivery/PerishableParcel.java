package ru.yandex.practicum.delivery;

public class PerishableParcel extends Parcel {
    protected int timeToLive;

    public PerishableParcel(String description, double weight, String deliveryAddress,
                            int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    public boolean isExpired(int currentDay) {
        if ((this.sendDay + timeToLive) >= currentDay) {
            return false;
        }
        return true;
    }
}
