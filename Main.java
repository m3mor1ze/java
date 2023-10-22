import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws Exception {
        Food[] breakfast = new Food[20];
        boolean ifsort = false;
        boolean ifcalories = false;

        for (String arg : args) {
            if (arg.matches("(^|\\s)-sort\\b(\\s|\\n|$)")) {
                ifsort = true;
                continue;
            }
            if (arg.matches("(^|\\s)-calories\\b(\\s|\\n|$)")) {
                ifcalories = true;
                continue;
            }
            if (arg.matches("\\-.*")) {
                System.out.println("No such params, skip");
            }
        }

        int itemsSoFar = 0;
        Integer calories = 0;
        for (String arg : args) {
            String[] parts = arg.split("/");

            if (parts[0].equals("Sandwich") || parts[0].equals("Dessert") || parts[0].equals("Cocktail")) {
                Class<?> foodClass = Class.forName(parts[0]);

                Food food = (Food) foodClass.getDeclaredConstructor(String.class, String.class).newInstance(parts[1], parts[0]);

                breakfast[itemsSoFar] = food;
                if (ifcalories)
                    calories += food.calculateCalories();
            } else if (parts[0].equals("-calories"))
                System.out.println("Program will calculate calories");
              else if (parts[0].equals("-sort"))
                System.out.println("Breakfast will be sorted");
                else
                System.out.println("Class not found");
            itemsSoFar++;
        }

        for (Food item : breakfast) {
            if (item != null) {
                item.consume();
            } else {
                break;
            }
        }

        if (ifcalories) {
            System.out.println("Calories = " + calories);
        }

        if (ifsort) {
            Arrays.sort(breakfast, Collections.reverseOrder(new Comparator<Food>() {
                @Override
                public int compare(Food first, Food second) {
                    if (first == null && second == null) {
                        return 0;
                    }
                    if (first == null) {
                        return 1;
                    }
                    if (second == null) {
                        return -1;
                    }

                    if (first.equals(second)) {
                        return 0;
                    }

                    int caloriesCompare = first.calculateCalories() - second.calculateCalories();
                    if (caloriesCompare != 0) {
                        return caloriesCompare;
                    }

                    return first.getName().compareTo(second.getName());
                }
            }));

            for (Food item : breakfast) {
                if (item != null) {
                    System.out.println(item.toString());
                }
            }
        }

        System.out.println("Всего хорошего!");
    }
}
