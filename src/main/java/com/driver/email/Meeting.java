package com.driver.email;

import java.time.LocalTime;

public class Meeting {
    private LocalTime startTime;
    private LocalTime endTime;

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Meeting() {
    }

    public Meeting(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
