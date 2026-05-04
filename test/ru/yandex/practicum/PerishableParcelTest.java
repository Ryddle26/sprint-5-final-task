package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.PerishableParcel;

import static org.junit.jupiter.api.Assertions.*;

public class PerishableParcelTest {
    @Test
    void testIsExpired() {
        PerishableParcel parcel = new PerishableParcel("Молоко", 0.5,
                "Шымкент", 1, 5);

        assertFalse(parcel.isExpired(1));
        assertFalse(parcel.isExpired(3));
        assertTrue(parcel.isExpired(6));
        assertTrue(parcel.isExpired(7));
    }
}
