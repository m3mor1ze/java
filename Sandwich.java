public class Sandwich extends Food {
    private String filling1, filling2;

    public Sandwich(String filling1, String filling2) {
        super("Sandwich");
        this.filling1 = filling1;
        this.filling2 = filling2;
    }

    @Override
    public void consume() {
        System.out.println("Sandwich (" + filling1 + " + " + filling2 + ") съеден");
    }

    @Override
    public Integer calculateCalories() {
        return 10 + (filling1 + filling1).length() * 10;
    }

    @Override
    public String toString(){
        return "Sandwich (" + filling1 + " + " + filling2 + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        if (!super.equals(o)) return false;

        Sandwich sandwich = (Sandwich) o;

        if (!filling1.equals(sandwich.filling1)) return false;
        if (!filling2.equals(sandwich.filling2)) return false;

        return true;
    }
}