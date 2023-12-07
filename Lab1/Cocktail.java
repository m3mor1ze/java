public class Cocktail extends Food {
    private String drink, fruit;

    public Cocktail(String drink, String fruit) {
        super("Cocktail");
        this.drink = drink;
        this.fruit = fruit;
    }

    @Override
    public void consume() {
        System.out.println("Cocktail (" + drink + " + " + fruit + ") выпит");
    }

    @Override
    public Integer calculateCalories() {
        return 5 + (drink + fruit).length() * 5;
    }

    @Override
    public String toString() {
        return "Cocktail (" + drink + " + " + fruit + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Cocktail cocktail = (Cocktail) o;

        if (!drink.equals(cocktail.drink)) return false;
        if (!fruit.equals(cocktail.fruit)) return false;

        return true;
    }
}