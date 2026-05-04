package ru.yandex.practicum.delivery;

public abstract class Parcel {
    //добавьте реализацию и другие необходимые классы
    private static final int STANDARD_PRICE_FOR_KG = 2;
    private static final int PERISHABLE_PRICE_FOR_KG = 3;
    private static final int FRAGILE_PRICE_FOR_KG = 4;

    protected String description;
    protected double weight;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(String description, double weight, String deliveryAddress, int sendDay) {
        this.description = description;
        this.weight = weight;
        this.deliveryAddress = deliveryAddress;
        this.sendDay = sendDay;
    }

    public void packageItem() {
        System.out.println("Посылка " + description + " упакована");
    }

    public void deliver() {
        System.out.println("Посылка " + description + " доставлена по адресу " + deliveryAddress);
    }

    public int getPriceForKg() {
        if (this instanceof FragileParcel) {
            return FRAGILE_PRICE_FOR_KG;
        } else if (this instanceof PerishableParcel) {
            return PERISHABLE_PRICE_FOR_KG;
        } else {
            return STANDARD_PRICE_FOR_KG;
        }
    }


    public double calculateDeliveryCost() {
        double priceForDelivery = getPriceForKg();
        return this.weight * priceForDelivery;
    }
}
