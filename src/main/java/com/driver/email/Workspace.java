package com.driver.email;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail {

    private ArrayList<Meeting> calendar;

    public Workspace(String emailId) {
        //The inbox capacity is the maximum value an integer can store
        super(emailId, Integer.MAX_VALUE);
        this.calendar = new ArrayList<>();
    }

    public void addMeeting(Meeting meeting) {
        calendar.add(meeting);
    }

    public int findMaxMeetings() {
        //Find the maximum number of meetings you can attend at a particular time, you can be present
        // in at most one meeting. Note that, if you want to attend a meeting, you must join it at its
        // start time and leave at end time.

        calendar.sort(new Comparator<Meeting>() {
            @Override
            public int compare(Meeting o1, Meeting o2) {
                return o1.getEndTime().compareTo(o2.getEndTime());
            }
        });

        int count = 0;

        if (!calendar.isEmpty()) {
            count++;
        }

        LocalTime endTime = calendar.get(0).getEndTime();

        for (int i = 1; i < calendar.size(); i++) {
            LocalTime startTime = calendar.get(i).getStartTime();

            if (startTime.isAfter(endTime)) {
                count++;
                endTime = calendar.get(i).getEndTime();
            }
        }
        return count;
    }
}
