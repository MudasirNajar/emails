package com.driver.email;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Gmail extends Email {
    int inboxCapacity;
    List<Mail> inbox;
    List<Mail> trash;

    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity = inboxCapacity;
        inbox = new ArrayList<>();
        trash = new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message) {
        //If the inbox is full, move the oldest mail in the inbox to trash. Add the new mail to the inbox.
        //It is guaranteed that:
        //Each mail in the inbox is distinct.
        //The date of a new mail is greater than equal to the dates of mails received already.

        //Remove it from the inbox and add it to trash
        if (inbox.size() == inboxCapacity) {
            Mail mail = inbox.get(0); //Oldest mail
            trash.add(mail);
            inbox.remove(mail);
        }
        Mail mail = new Mail(date, sender, message);
        inbox.add(mail);
    }

    public void deleteMail(String message) {
        //If the given message is found in any mail in the inbox, move the mail to trash,
        //else do nothing. Note that all the messages are distinct. Thus, at most one match
        //would be found in the inbox.

        for (int i =0;i<inbox.size();i++) {
            Mail mail = inbox.get(i);
            if (mail.getMessage().equals(message)) {
                trash.add(mail);
                inbox.remove(mail);
            }
        }
    }

    public String findLatestMessage() {
        //If the inbox is empty, return null. Else, return the message of the latest mail
        //present in the inbox.
        if (inbox.isEmpty())
            return null;
        return inbox.get(inbox.size() - 1).getMessage();
    }

    public String findOldestMessage() {
        //If the inbox is empty, return null. Else, return the message of the oldest mail
        //present in the inbox.
        if (inbox.isEmpty())
            return null;
        return inbox.get(0).getMessage();
    }

    public Integer findMailsBetweenDates(Date start, Date end) {
        //Find number of emails between given dates
        //It is guaranteed that the start date >= end date.

        //Iterate over the inbox and keep a count variable

        int count = 0;
        for (Mail mail : inbox) {
            if (mail.getDate().compareTo(start) >= 0 && mail.getDate().compareTo(end) <= 0) {
                count++;
            }
        }
        return count;
    }

    public Integer getInboxSize() {
        return inbox.size();
    }

    public Integer getTrashSize() {
        return trash.size();
    }

    public void emptyTrash() {
        trash.clear();

    }

    public Integer getInboxCapacity() {
        return inboxCapacity;
    }
}
