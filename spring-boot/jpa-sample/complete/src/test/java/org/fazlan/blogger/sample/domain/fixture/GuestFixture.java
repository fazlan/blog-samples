package org.fazlan.blogger.sample.domain.fixture;

import org.fazlan.blogger.sample.domain.entity.Guest;

public class GuestFixture {

    private GuestFixture() {}

    public static final String GUEST_JOHN_SMITH = "John Smith";

    public static Guest getJohnSmith() {
        return Guest.builder(GUEST_JOHN_SMITH).build();
    }
}