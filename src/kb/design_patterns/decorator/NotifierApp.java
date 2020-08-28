package kb.design_patterns.decorator;

import java.io.IOException;
import java.util.List;

import kb.design_patterns.decorator.notification.EmailNotifierLibrary;
import kb.design_patterns.decorator.notification.FacebookNotifier;
import kb.design_patterns.decorator.notification.Notifier;
import kb.design_patterns.decorator.notification.SlackNotifier;
import kb.design_patterns.decorator.notification.SmsNotifier;

public class NotifierApp {

    public static void main(String[] args) throws IOException {
        List<String> receivers = List.of("bobby_b", "tictac86", "guru777");

        Notifier fbAndSms = new SmsNotifier(new FacebookNotifier(new EmailNotifierLibrary()));

        fbAndSms.send("Hello! Today is your lucky day!", receivers);

        System.out.println();

        Notifier fbAndSmsAndSlack = new SmsNotifier(
                new FacebookNotifier(new SlackNotifier(new EmailNotifierLibrary())));

        fbAndSmsAndSlack.send("There is a super discount today!", receivers);
    }

}
