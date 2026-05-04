package ru.yandex.practicum;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.FragileParcel;
import ru.yandex.practicum.delivery.PerishableParcel;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

public class DeliveryCostTest {
    @Test
    void standardDeliveryCostTest() {
        StandardParcel standardParcel = new StandardParcel("Книга", 2.0,
                "Астана", 6);
        assertEquals(4, standardParcel.calculateDeliveryCost());
    }

    @Test
    void fragileDeliveryCostTest() {
        FragileParcel fragileParcel = new FragileParcel("Ваза", 5.0,
                "Караганда", 10);
        assertEquals(20, fragileParcel.calculateDeliveryCost());
    }

    @Test
    void perishableDeliveryCostTest() {
        PerishableParcel perishableParcel = new PerishableParcel("Печенье", 3.0,
                "Павлодар", 20, 10);
        assertEquals(9, perishableParcel.calculateDeliveryCost());
    }

}
