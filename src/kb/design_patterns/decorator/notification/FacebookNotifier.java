package kb.design_patterns.decorator.notification;

import java.util.List;

public class FacebookNotifier extends BaseDecorator {
    public FacebookNotifier(EmailNotifierLibrary notifier) {
        super(notifier);
    }
    
    @Override
    public void send(String message, List<String> receivers) {
        super.send(message, receivers);
        sendFacebookMessage(message, receivers);
    }
    
    private void sendFacebookMessage(String message, List<String> receivers) {
        System.out.println("Facebook message: " + message);
    }

}
