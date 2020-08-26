package kb.design_patterns.adapter;

/* Can eventually extents some Samsung interface */
class SamsumgTv {
    public void on() {
        System.out.println("Samsung TV is on.");
    }

    public void off() {
        System.out.println("Samsung TV is off.");
    }

    public void menu() {
        System.out.println("Samsung TV menu is opened.");
    }

    public void connectWifi(String wifiName) {
        System.out.println("Samsung TV is connected to WiFi: " + wifiName);
    }

    public void openYouTubeApp() {
        System.out.println("YouTube App is opened.");
    }
}

/* Can eventually extents some Sony interface */
class SonyTv {
    public void powerOn() {
        System.out.println("Sony TV is on.");
    }

    public void powerOff() {
        System.out.println("Sony TV is off.");
    }

    public void showMenu() {
        System.out.println("Sony TV menu is opened.");
    }

    public void connectToWifiNetwork(String wifiName) {
        System.out.println("Sony TV is connected to WiFi: " + wifiName);
    }
}