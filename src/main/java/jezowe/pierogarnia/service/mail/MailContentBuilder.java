package jezowe.pierogarnia.service.mail;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class MailContentBuilder {

    private TemplateEngine templateEngine;

    @Autowired
    public MailContentBuilder(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public String build(String topicMsg, String message, String from, String email) {
        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("topicMsg", topicMsg);
        context.setVariable("from", from);
        context.setVariable("email", email);
        return templateEngine.process("mailTemplate", context);
    }

}
