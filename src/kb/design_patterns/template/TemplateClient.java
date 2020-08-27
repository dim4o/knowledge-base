package kb.design_patterns.template;

abstract class HouseTemplate {
    protected String houseType;

    protected HouseTemplate(String houseType) {
        this.houseType = houseType;
    }
    
    public String getHouseType() {
        return houseType;
    }
    
    protected abstract void buildRoof();

    protected abstract void buildWindows();

    protected abstract void buildColumns();

    protected abstract void buildFoundation();

    protected abstract void buildWalls();

    // Template method
    public final void buildHouse() {
        buildFoundation();
        buildColumns();
        buildWalls();
        buildWindows();
        buildRoof();
        System.out.println("The house is built.");
    }

}

class Hut extends HouseTemplate {
    protected Hut(String houseType) {
        super(houseType);
    }

    @Override
    protected void buildRoof() {
        System.out.println("Building Sloping Roof with Wooden Beams.");
    }

    @Override
    protected void buildWindows() {
        System.out.println("Building Wondows with Wooden Frame.");
    }

    @Override
    protected void buildColumns() {
        System.out.println("Building Columns with Wood Coating.");
    }

    @Override
    protected void buildFoundation() {
        System.out.println("Building Standard Foundation.");
    }

    @Override
    protected void buildWalls() {
        System.out.println("Building Wooden Walls.");
    }
}

class AppartmentHouse extends HouseTemplate {
    protected AppartmentHouse(String houseType) {
        super(houseType);
    }

    @Override
    protected void buildRoof() {
        System.out.println("Building Flat Concrete Roof.");
        
    }

    @Override
    protected void buildWindows() {
        System.out.println("Building Wondows with Double-hung windows");
    }

    @Override
    protected void buildColumns() {
        System.out.println("Building Concrete Columns.");
    }

    @Override
    protected void buildFoundation() {
        System.out.println("Building Strong Foundation.");
    }

    @Override
    protected void buildWalls() {
        System.out.println("Building Bick Walls");
    }
}

class TemplateClient {
    public static void main(String[] args) {
        HouseTemplate hut = new Hut("Mountain Hut");
        HouseTemplate appHause = new AppartmentHouse("City Appartment House");
        
        //using template method
        System.out.println("*** " + hut.getHouseType() + " ***");
        hut.buildHouse();
        
        System.out.println();
        
        System.out.println("*** " + appHause.getHouseType() + " ***");
        appHause.buildHouse();
    }
}
