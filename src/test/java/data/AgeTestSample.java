package data;

import entity.Age;

public class AgeTestSample {
    public static Age getValidAgeForAdult() {
        return new Age(22);
    }

    public static Age getValidAgeForChildren() {
        return new Age(10);
    }
}
