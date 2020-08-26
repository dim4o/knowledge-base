package kb.design_patterns.adapter;

/* Common interface for all smart TV's */
interface SmartTv {
    public void turnOn();

    public void turnOff();

    public void openMenu();

    public void connectToWifi(String wifiName);

    public void openYouTube();
}

/* A concrete adapter implementation */
class SamsungTvAdapter implements SmartTv {
    private SamsumgTv tv;

    public SamsungTvAdapter(SamsumgTv samsungTv) {
        tv = samsungTv;
    }

    @Override
    public void turnOn() {
        tv.on();
    }

    @Override
    public void turnOff() {
        tv.off();
    }

    @Override
    public void openMenu() {
        tv.menu();
    }

    @Override
    public void connectToWifi(String wifiName) {
        tv.connectWifi(wifiName);
    }

    @Override
    public void openYouTube() {
        tv.openYouTubeApp();
    }
}

/* A concrete adapter implementation */
class SonyTvAdapter implements SmartTv {
    private SonyTv tv;

    public SonyTvAdapter(SonyTv sonyTv) {
        tv = sonyTv;
    }

    @Override
    public void turnOn() {
        tv.powerOn();
    }

    @Override
    public void turnOff() {
        tv.powerOff();
    }

    @Override
    public void openMenu() {
        tv.showMenu();
    }

    @Override
    public void connectToWifi(String wifiName) {
        tv.connectToWifiNetwork(wifiName);
    }

    @Override
    public void openYouTube() {
        throw new UnsupportedOperationException("YouTube App is not supported for Sony TV.");
    }
}