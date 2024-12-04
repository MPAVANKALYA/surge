package com.adobe.aem.demo.core.models;



import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Model(adaptables = Resource.class)
public class YourComponentModel {

    @ValueMapValue
    private String textField;

    @ValueMapValue
    private String pathField;

    @ValueMapValue
    private String selectedDate;

    public String getTextField() {
        return textField;
    }

    public String getPathField() {
        return pathField;
    }

    public String getSelectedDate() {
        return selectedDate;
    }

    public boolean isDataValid() {
        // If the selected date is null or empty, return false
        if (selectedDate == null || selectedDate.isEmpty()) {
            return false;
        }

        try {
            // Parse the selected date using the ISO format (yyyy-MM-dd)
            LocalDate selectedDateObj = LocalDate.parse(selectedDate, DateTimeFormatter.ISO_LOCAL_DATE);

            // Get today's date (no time included)
            LocalDate today = LocalDate.now();

            // Return true if the selected date is today or in the future
            return !selectedDateObj.isBefore(today);
        } catch (DateTimeParseException e) {
            // If date parsing fails, return false (invalid date)
            return false;
        }
    }
}
