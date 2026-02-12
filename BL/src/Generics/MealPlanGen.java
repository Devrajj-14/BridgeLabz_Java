package Generics;

import java.util.ArrayList;
import java.util.List;

/*
 * Personalized Meal Plan Generator (Generics)
 * - MealPlan interface
 * - Different meal types implement MealPlan
 * - Generic Meal<T extends MealPlan>
 * - Generic method to validate + generate plan
 */
interface MealPlan {}

/*
 * Meal types
 */
class VegetarianMeal implements MealPlan {
    public String toString() { return "Vegetarian Meal Plan"; }
}

class VeganMeal implements MealPlan {
    public String toString() { return "Vegan Meal Plan"; }
}

class KetoMeal implements MealPlan {
    public String toString() { return "Keto Meal Plan"; }
}

class HighProteinMeal implements MealPlan {
    public String toString() { return "High-Protein Meal Plan"; }
}

/*
 * Generic container for any meal plan type
 */
class Meal<T extends MealPlan> {
    T plan;
    List<String> items = new ArrayList<>();

    Meal(T plan) {
        this.plan = plan;
    }

    void addItem(String food) {
        items.add(food);
    }

    void show() {
        System.out.println(plan);
        for (String s : items) System.out.println("- " + s);
    }
}

/*
 * Generic method to validate and generate a plan
 */
class MealGenerator {

    static <T extends MealPlan> Meal<T> generate(T plan) {

        // simple validation (only valid plans allowed)
        if (plan == null) return null;

        Meal<T> meal = new Meal<>(plan);

        // create items based on type
        if (plan instanceof VegetarianMeal) {
            meal.addItem("Paneer + Roti");
            meal.addItem("Dal + Rice");
        } else if (plan instanceof VeganMeal) {
            meal.addItem("Chana Salad");
            meal.addItem("Tofu Stir Fry");
        } else if (plan instanceof KetoMeal) {
            meal.addItem("Egg Omelette");
            meal.addItem("Chicken Salad");
        } else if (plan instanceof HighProteinMeal) {
            meal.addItem("Sprouts Bowl");
            meal.addItem("Chicken / Paneer Bowl");
        } else {
            // unknown type not allowed
            return null;
        }

        return meal;
    }
}

public class MealPlanGen {
    public static void main(String[] args) {

        Meal<VegetarianMeal> vegPlan = MealGenerator.generate(new VegetarianMeal());
        Meal<VeganMeal> veganPlan = MealGenerator.generate(new VeganMeal());

        if (vegPlan != null) vegPlan.show();
        System.out.println();
        if (veganPlan != null) veganPlan.show();
    }
}