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
    @Test
    void testDeleteCity() {
        CustomList cityList = mockCityList();
        City city = mockCity();

        assertTrue(cityList.hasCity(city));

        cityList.deleteCity(city);

        assertFalse(cityList.hasCity(city));
    }

    @Test
    void testDeleteCityException() {
        CustomList cityList = mockCityList();
        City cityNotInList = new City("Toronto", "Ontario");

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.deleteCity(cityNotInList);
        });
    }

    @Test
    void testCountCities() {
        CustomList cityList = new CustomList();

        assertEquals(0, cityList.countCities());

        cityList.addCity(new City("Edmonton", "Alberta"));
        assertEquals(1, cityList.countCities());

        cityList.addCity(new City("Regina", "Saskatchewan"));
        assertEquals(2, cityList.countCities());
    }
}
