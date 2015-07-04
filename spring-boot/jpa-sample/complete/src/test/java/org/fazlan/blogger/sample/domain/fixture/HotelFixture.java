package org.fazlan.blogger.sample.domain.fixture;

import org.fazlan.blogger.sample.domain.entity.Hotel;

public class HotelFixture {

    private HotelFixture() {}

    public static final String HOTEL_CROWN = "Crown";

    public static Hotel getCrownHotel() {
        return Hotel.builder(HOTEL_CROWN).build();
    }
}