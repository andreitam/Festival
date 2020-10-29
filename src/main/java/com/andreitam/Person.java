package com.andreitam;
/**
 * The class Person to be inherited by FestivalAtendee,
 * //in case we will need more data fields later on in the application.
 *
 * @author  Andrei Tamasanu
 * @version 1.0
 * @since   2020-10-29
 */
public class Person {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
