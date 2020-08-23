package kb.design_patterns.decorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.zip.GZIPInputStream;

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

        // We need to unserialize those Java objects:
        ObjectInputStream ois = new ObjectInputStream(
                new GZIPInputStream(new BufferedInputStream(new FileInputStream("/objects.gz"))));

        // Now we can finally use it:
        // SomeObject someObject = (SomeObject) ois.readObject();

    }

}
