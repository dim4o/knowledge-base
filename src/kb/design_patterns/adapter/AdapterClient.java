package kb.design_patterns.adapter;

public class AdapterClient {

    public static void main(String[] args) {
        // Now both of the TV's are with different type.
        SamsumgTv samsungTv = new SamsumgTv();
        SonyTv sonyTv = new SonyTv();

        // Now the two TV's share a same SmartTv interface
        SmartTv samsungAdapter = new SamsungTvAdapter(samsungTv);
        SmartTv sonyAdapter = new SonyTvAdapter(sonyTv);

        // turn On/Off
        samsungAdapter.turnOn();
        sonyAdapter.turnOff();

        // open YouTube
        samsungAdapter.openYouTube();
        try {
            sonyAdapter.openYouTube();
        } catch (UnsupportedOperationException e) {
            System.out.println(e.getMessage());
        }
    }
}
