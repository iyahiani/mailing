package com.ismail.test.mails;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailTest {

   public static void main(String[] args)

   {
      String to = "ismael.yahiani@avancial.com";

      // Sender's email ID needs to be mentioned
      String from = "ismael.yahiani@avancial.com";

      // Assuming you are sending email from localhost
      String host = "parisgw1.avancial.com";

      // Get system properties
      Properties properties = System.getProperties();

      // Setup mail server
      properties.put("mail.transport.protocol", "smtp");
      properties.put("mail.smtp.host", "parisgw1.avancial.com"); // smtp.gmail.com?
      properties.put("mail.smtp.port", "80");
       
     //Setup Password and user  
      
      properties.put("mail.smtp.auth","true" ) ;

      Authenticator authenticator = new Authenticator() { 
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication("", "") ;
         }
      };
      
      // Get the default Session object.
      Session session = Session.getDefaultInstance(properties,authenticator);

      try{
         // Create a default MimeMessage object.
         MimeMessage message = new MimeMessage(session);

         // Set From: header field of the header.
         message.setFrom(new InternetAddress(from));

         // Set To: header field of the header.
         
         message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

         // Set Subject: header field
         message.setSubject("This is the Subject Line!");
         // Now set the actual message
         message.setText("This is actual message");
         // Send message
         
         Transport.send(message);
         System.out.println("Sent message successfully....");
         
      }catch (MessagingException mex) {
         mex.printStackTrace();
      }
   }
}
