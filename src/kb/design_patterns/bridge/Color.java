package kb.design_patterns.bridge;

interface Color {
    String fill();
}

class Blue implements Color {
    @Override
    public String fill() {
        return "Color is Blue.";
    }
}

class Red implements Color {
    @Override
    public String fill() {
        return "Color is Red.";
    }
}