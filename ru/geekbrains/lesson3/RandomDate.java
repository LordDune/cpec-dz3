package ru.geekbrains.lesson3;

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

public class RandomDate {

    static LocalDate startInclusive = LocalDate.now().minusYears(70);
    static LocalDate endExclusive = LocalDate.now().minusYears(18);


    public static LocalDate set() {
        long startEpochDay = startInclusive.toEpochDay();
        long endEpochDay = endExclusive.toEpochDay();
        long randomDay = ThreadLocalRandom
                .current()
                .nextLong(startEpochDay, endEpochDay);

        return LocalDate.ofEpochDay(randomDay);
    }
}
