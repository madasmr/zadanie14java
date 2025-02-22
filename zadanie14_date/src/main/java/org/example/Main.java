package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        LocalDate randomDate = generateRandomDate();

        DayOfWeek dayOfWeek = randomDate.getDayOfWeek();

        String dayOfWeekRussian = translateDayOfWeek(dayOfWeek);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = randomDate.format(formatter);

        System.out.printf("Случайная дата: %s, День недели: %s%n", formattedDate, dayOfWeekRussian);
    }

    public static LocalDate generateRandomDate(){
        Random random = new Random();

        int year = random.nextInt(2026 - 1900) + 1900;
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(LocalDate.of(year, month, 1).lengthOfMonth()) + 1;

        LocalDate randomDate = LocalDate.of(year, month, day);
        return randomDate;
    }

    private static String translateDayOfWeek(DayOfWeek dayOfWeek) {
        switch (dayOfWeek) {
            case MONDAY:
                return "понедельник";
            case TUESDAY:
                return "вторник";
            case WEDNESDAY:
                return "среда";
            case THURSDAY:
                return "четверг";
            case FRIDAY:
                return "пятница";
            case SATURDAY:
                return "суббота";
            case SUNDAY:
                return "воскресенье";
            default:
                return "";
        }
    }
}