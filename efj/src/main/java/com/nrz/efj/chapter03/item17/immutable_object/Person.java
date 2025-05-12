package com.nrz.efj.chapter03.item17.immutable_object;


public final class Person {
    private final Address address;

    public Person(Address address) {
        this.address = address;
    }

    public Address getAddress() {
//        return address;

        Address copy = new Address();
        copy.setStreet(address.getStreet());
        copy.setZipCode(address.getZipCode());
        copy.setCity(address.getCity());
        return copy;
    }

    public static void main(String[] args) {
        Address seoul = new Address();
        seoul.setCity("서울");

        Person person = new Person(seoul);
        Address pusan = person.getAddress();
        pusan.setCity("pusan");

        System.out.println(person.getAddress().getCity());
    }
}
