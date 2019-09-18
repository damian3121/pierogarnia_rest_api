package jezowe.pierogarnia.mail;

import jezowe.pierogarnia.service.mail.MailContentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;

@Component
public class SmtpMailSender {
    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailContentBuilder mailContentBuilder;

    public void send(String to, String from, String subject, String body, String name) throws MessagingException {

        MimeMessagePreparator messagePreparator = mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setFrom(from);
            messageHelper.setTo(to);
            messageHelper.setSubject(subject);
            String content = mailContentBuilder.build(subject, body, name, from);
            messageHelper.setText(content, true);
        };

        javaMailSender.send(messagePreparator);
    }
}
