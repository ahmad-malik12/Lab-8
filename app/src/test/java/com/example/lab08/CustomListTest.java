package com.example.lab08;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CustomListTest {

    private CustomList mockCityList() {
        CustomList cityList = new CustomList();
        cityList.addCity(mockCity());
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testHasCityTrue() {
        CustomList cityList = mockCityList();
        City city = mockCity();

        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testHasCityFalse() {
        CustomList cityList = mockCityList();
        City city = new City("Regina", "Saskatchewan");

        assertFalse(cityList.hasCity(city));
    }
}
