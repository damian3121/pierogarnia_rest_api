package jezowe.pierogarnia.controller;

import jezowe.pierogarnia.dto.mail.EmailDTO;
import jezowe.pierogarnia.mail.SmtpMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@CrossOrigin(origins = "https://www.pierogarniajezowe.pl")
public class SenderMailController {
    @Autowired
    private SmtpMailSender smtpMailSender;

    @RequestMapping(value = "/send-mail", method = RequestMethod.POST)
    public void sendMail(@RequestBody EmailDTO emailDTO) throws MessagingException {
        smtpMailSender.send("pierogarniajezowe@gmail.com", emailDTO.getEmail(), emailDTO.getTopicMsg(), emailDTO.getMessage(), emailDTO.getName());
    }
}
