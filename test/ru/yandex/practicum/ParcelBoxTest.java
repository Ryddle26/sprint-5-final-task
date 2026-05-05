package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.ParcelBox;
import ru.yandex.practicum.delivery.StandardParcel;

import static org.junit.jupiter.api.Assertions.*;

public class ParcelBoxTest {

    @Test
    void testAddParcel() {
        ParcelBox<StandardParcel> box = new ParcelBox<>(10.0);

        StandardParcel parcel1 = new StandardParcel("Фотоальбом", 3,
                "Тараз", 5);
        StandardParcel parcel2 = new StandardParcel("Стационарный телефон", 2,
                "Семипалатинск", 3);
        StandardParcel tooHeavyParcel = new StandardParcel("Диван", 8,
                "Алматы", 2);

        box.addParcel(parcel1);
        assertEquals(3.0, box.getCurrentWeightOfBox());

        box.addParcel(parcel2);
        assertEquals(5.0, box.getCurrentWeightOfBox());

        assertFalse(box.addParcel(tooHeavyParcel));
        assertEquals(5.0, box.getCurrentWeightOfBox());
    }
}
