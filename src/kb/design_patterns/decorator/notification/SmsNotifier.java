package kb.design_patterns.decorator.notification;

import java.util.List;

public class SmsNotifier extends BaseDecorator {

    public SmsNotifier(EmailNotifierLibrary notifier) {
        super(notifier);
    }

    @Override
    public void send(String message, List<String> receivers) {
        super.send(message, receivers);
        sendSmsMessage(message, receivers);
    }

    private void sendSmsMessage(String message, List<String> receivers) {
        System.out.println("SMS message: " + message);
    }

}
