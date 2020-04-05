package seedu.tasks;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;

public class Class extends Task {

    /**
     * Constructor method for initialising new class object.
     * @param title title of class
     * @param description description of class
     * @param date range of days the class will be on
     * @param time range of time the class will be held
     * @param location location of class
     * @param reminder any additional reminder if any
     * @param category categorise the class by grouping in needed
     */
    public Class(String title, String description, String date, String time, String location,
                        String reminder, String category) {
        super(title,description,time,location,reminder,category);
        if (!date.isEmpty()) {
            setDate(date);
        }
        if (!time.isEmpty()) {
            setTime(time);
        }
        if (!location.isEmpty()) {
            setLocation(location);
        }
    }

    @Override
    public void setDate(String dateInput) throws DateTimeParseException, NumberFormatException {
        this.date.clear();
        String[] days = dateInput.split("\\s+");
        for (String day : days) {
            // Get day of week
            Integer dayOfWeekInt = Integer.parseInt(day);
            if (dayOfWeekInt > 7 | dayOfWeekInt < 1) {
                throw new NumberFormatException();
            }
            Integer inputDayOfWeek = Integer.parseInt(day);
            //Transfer day of week to local date format
            LocalDate now = LocalDate.now();
            Integer nowDayOfWeek = now.getDayOfWeek().getValue();
            this.date.add(now.plusDays(inputDayOfWeek - nowDayOfWeek));
        }
    }


    /**
     * Return string of class in its specific format.
     *
     * @return string of class.
     */
    public String toString() {
        String formattedTask = super.toString();
        for (int i = 0; i < date.size(); i++) {
            formattedTask = formattedTask + String.format(" | %s : %s - %s",
                    date.get(i).getDayOfWeek().name(), time.get(i * 2),time.get(i * 2 + 1));
            if (location.size() > i) {
                formattedTask = formattedTask + String.format(" ( %s )",location.get(i));
            }
        }
        return formattedTask;
    }
}