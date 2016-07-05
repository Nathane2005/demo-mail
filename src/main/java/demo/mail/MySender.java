package demo.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

@Service
public class MySender {

    @Autowired
    private MailSender mailSender;

    public void sendEmail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("example@example.com");
        message.setSubject("Subject");
        message.setText("Text");
        mailSender.send(message);
    }

}
