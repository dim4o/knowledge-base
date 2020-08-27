package kb.design_patterns.singelton;

public class Client {

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        SingletonDoubleCheckLock s1 = SingletonDoubleCheckLock.getInstance();
        SingletonDoubleCheckLock.getInstance();

        SingletonStaticHolder s2 = SingletonStaticHolder.getInstance();
        SingletonStaticHolder.getInstance();

        SingeltonEnum s3 = SingeltonEnum.INSTANCE;
        SingeltonEnum s4 = SingeltonEnum.INSTANCE;
    }
}
