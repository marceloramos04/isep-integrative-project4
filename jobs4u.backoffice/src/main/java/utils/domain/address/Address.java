package utils.domain.address;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.Objects;

@Embeddable
public class Address {

    @Column(nullable = false)
    private String street;

    @Column(nullable = false)
    private int building_number;

    @Column(nullable = false)
    private ZipCode zipCode;

    @Column(nullable = false)
    private String city;

    protected Address() {
        //ORM
    }

    public Address(String street, int buildingNumber, String zipcode, String city) {
        this.street = street;
        this.building_number = buildingNumber;
        this.zipCode = new ZipCode(zipcode);
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("%s, %d, %s, %s", street, building_number, zipCode.toString(), city);
    }
}
