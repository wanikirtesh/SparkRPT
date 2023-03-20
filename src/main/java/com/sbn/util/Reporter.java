package com.sbn.util;

import org.testng.ITestResult;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Reporter {
    private static StringBuilder sb = new StringBuilder();
    public static void startSuite(ITestResult testResult){
        sb.append("<html> <haead></head><body>");
        sb.append("<h1>"+testResult.getTestName()+"</h1>");
        sb.append("<table border='1px'><thead><tr><th>Name</th><th>Result</th></tr></thead><tbody>");

    }

    public static void endSuite(){
        sb.append("</table></body></html>");
        try {
            sendEmail(sb);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void startTest(){

    }

    public static void endTest(ITestResult testResult){
        sb.append("<tr>");
        sb.append("<td>"+testResult.getMethod()+"</td><td>" + (testResult.getStatus()==1?"Pass":"Fail") + "</td>");
        sb.append("</tr>");
    }

    private static void sendEmail(StringBuilder sb) throws MessagingException {
        final String username = "<<fromEmail>>";
        //final String password = AES256.decrypt("H4PAFMrtj+DxsERILxTFIw==");
        final String password = "<<password>>";
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "<<SMTP Host>>");
        prop.put("mail.smtp.port", "<<PORT>>");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true"); //TLS

        Session session = Session.getInstance(prop,
        new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        Message message = new MimeMessage(session);

        message.setFrom(new InternetAddress(username));
        message.setRecipients(
                Message.RecipientType.TO,
                InternetAddress.parse("<<TO Email>>")
        );
        message.setSubject("Automation test results");
        message.setContent(sb.toString(),"text/html");
        Transport.send(message);
    }

}
