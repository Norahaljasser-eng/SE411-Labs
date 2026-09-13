package edu.psu.se411;

import edu.psu.se411.exception.InvalidAgeException;

public class EX1 {

    public static void validateAge(int age) throws InvalidAgeException {
        if (age < 18) {
            throw new InvalidAgeException("Age must be 18 or higher.");
        }

        System.out.println("Age valid message.");
    }

    public static void main(String[] args) {
        try {
            validateAge(18);
        } catch (InvalidAgeException e) {
            System.out.println(e.getMessage());
        }
    }
}