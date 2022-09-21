package com.spring.lms.utility;

import java.util.List;

public interface EmailUtility {
    public boolean sendTextEmail(String emailTo, String emailSubject, String emailBody);
    public boolean sendHTMLEmail(String emailTo, String emailSubject, String emailBody);

    public void sendHTMLEmailToNewsLetterSubscriber(List<String> listOfEmail, String emailSubject, String emailBody);
}
