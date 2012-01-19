package nijhof2axon.app.command;

import nijhof2axon.app.domain.Address;

/**
 * Author: Bahadir Konu (bah.konu@gmail.com)
 */
public class CreateClientCommand {
    private String name;
    private Address address;
    private String phoneNumber;

    public CreateClientCommand(String name, Address address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
