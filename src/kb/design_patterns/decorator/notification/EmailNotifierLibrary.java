package kb.design_patterns.decorator.notification;

import java.util.List;

public class EmailNotifierLibrary implements Notifier {

    @Override
    public void send(String message, List<String> users) {
        System.out.println("Email massage: " + message);
    }
}
