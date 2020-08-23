package kb.design_patterns.decorator.notification;

import java.util.List;

public class SlackNotifier extends BaseDecorator {

    public SlackNotifier(EmailNotifierLibrary notifier) {
        super(notifier);
    }

    @Override
    public void send(String message, List<String> receivers) {
        super.send(message, receivers);
        sendSlackMessage(message, receivers);
    }
    
    private void sendSlackMessage(String message, List<String> users) {
        System.out.println("Slack message: " + message);
    }
}
