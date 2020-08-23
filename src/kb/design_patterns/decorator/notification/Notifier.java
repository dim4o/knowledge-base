package kb.design_patterns.decorator.notification;

import java.util.List;

public interface Notifier {
    /**
     * Sends notification messages to {@link List} of receivers.
     * 
     * @param message   a message to send
     * @param receivers a {@link List} of message receivers
     */
    public void send(String message, List<String> users);
}
