package com.spring.lms.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.util.List;

@Service
public class EmailUtilityImpl implements EmailUtility
{
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String emailFrom;
    @Override
    public boolean sendTextEmail(String emailTo, String emailSubject, String emailBody) {

        try{
            System.out.println("\nUser From Email: " + this.emailFrom);
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(this.emailFrom);
            simpleMailMessage.setTo(emailTo);
            simpleMailMessage.setSubject(emailSubject);
            simpleMailMessage.setText(emailBody);
            javaMailSender.send(simpleMailMessage);
            System.out.println("\nEmail Sent...\n");
            return true;
        }
        catch(Exception e)
        {
            e.printStackTrace();
            System.out.println("\nError occured while sending email: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean sendHTMLEmail(String emailTo, String emailSubject, String emailBody) {

        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            mimeMessageHelper.setTo(emailTo);
            mimeMessageHelper.setSubject(emailSubject);
            mimeMessageHelper.setText(emailBody, true);
            javaMailSender.send(mimeMessage);
            return true;
        }
        catch(Exception e){
            System.out.println("\nError during sending HTML email: " + e.getMessage());
            e.printStackTrace();
        }

        return false;
    }

    @Override
    public void sendHTMLEmailToNewsLetterSubscriber(List<String> listOfEmail, String emailSubject, String emailBody) {

        try{
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            /*mimeMessageHelper.setBcc(
                    listOfEmail.stream().toArray(String[]::new) //Converted List<String> to String[]
            );*/
            mimeMessageHelper.setTo(
                    listOfEmail.stream().toArray(String[]::new) //Converted List<String> to String[]
            );
            mimeMessageHelper.setSubject(emailSubject);
            mimeMessageHelper.setText(emailBody, true);
            javaMailSender.send(mimeMessage);
        }catch(Exception e){
            System.out.println("\n\nError during sending news letter email in IMPL: " + e.getMessage());
            e.printStackTrace();
        }

    }
}
