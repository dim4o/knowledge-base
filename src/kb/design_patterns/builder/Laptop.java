package kb.design_patterns.builder;

import java.util.List;

public class Laptop {
    private Long id;
    private String serialNumber;
    private String brandName;
    private float price; // better to use a BigDecimal in a real world scenario
    
    /**
     * Getters and setters.(the setters are not mandatory and are omitted for
     * brevity)
     */
    public Long getId() { return id; }
    public String getSerialNumber() { return serialNumber; }
    public float getPrice() { return price; }
    public String getBrandName() { return brandName; }

    /**
     * The private constructor forces the user to use the Builder and keeps from
     * creating some invalid or malicious instances.
     */
    private Laptop() {}

    /**
     * The builder class should be static.
     */
    public static class Builder {
        private Long id;
        private String serialNumber;
        private float price;
        private String brandName;

        private Builder(Long id) {
            this.id = id;
        }

        public Builder withSerial(String serialNumber) {
            Builder.this.serialNumber = serialNumber;
            // By returning the builder each time, we can create a fluent interface.
            return Builder.this;
        }

        public Builder withPrice(float price) {
            Builder.this.price = price;
            return Builder.this;
        }

        public Builder withBrandName(String brandName) {
            Builder.this.brandName = brandName;
            return Builder.this;
        }

        public Laptop build() {
            // Since the Laptop is an outer class, we can invoke its private constructor and
            // set its private fields.
            Laptop laptop = new Laptop();
            laptop.id = Builder.this.id;
            laptop.price = Builder.this.price;
            laptop.serialNumber = Builder.this.serialNumber;
            laptop.brandName = Builder.this.brandName;

            return laptop;
        }

    }
    
    @Override
    public String toString() {
        return List.of(id, price, (serialNumber != null ? serialNumber : "null"),
                brandName != null ? brandName : null).toString();
    }

    public static void main(String[] args) {
        // The Builder pattern allows to create an an object with various number of
        // parameters in various order without constructor overloading.
        Laptop lTop1 = new Laptop.Builder(1123581321L)
                .withSerial("A1C2-D4KG-GD13-FHG6")
                .withPrice(1399.99f)
                .withBrandName("Toshiba")
                .build();

        Laptop lTop2 = new Laptop.Builder(248163264128L)
                .withBrandName("System76")
                .withPrice(1699.99f)
                .build();
        
        System.out.println(lTop1);
        System.out.println(lTop2);
        
    }
}
