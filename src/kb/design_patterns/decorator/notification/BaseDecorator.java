package kb.design_patterns.decorator.notification;

import java.util.List;

public abstract class BaseDecorator extends EmailNotifierLibrary {

    private EmailNotifierLibrary wrappee;

    public BaseDecorator(EmailNotifierLibrary notifier) {
        this.wrappee = notifier;
    }

    @Override
    public void send(String message, List<String> receivers) {
        wrappee.send(message, receivers);
    }

}
