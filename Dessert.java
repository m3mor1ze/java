public class Dessert extends Food {
    private String component1;
    private String component2;

    public Dessert(String component1, String component2) {
        super("Dessert");
        this.component1 = component1;
        this.component2 = component2;
    }

    @Override
    public void consume() {
        System.out.println("Dessert (" + component1 + " + " + component2 + ") съеден");
    }

    @Override
    public Integer calculateCalories() {
        return 15 + (component1 + component2).length() * 15;
    }

    @Override
    public String toString(){
        return "Dessert (" + component1 + " + " + component2 + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Dessert dessert = (Dessert) o;

        if (!component1.equals(dessert.component1)) return false;
        if (!component2.equals(dessert.component2)) return false;

        return true;
    }
}