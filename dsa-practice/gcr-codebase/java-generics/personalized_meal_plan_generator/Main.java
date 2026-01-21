package personalized_meal_plan_generator;

public class Main {
    public static void main(String[] args) {
        Meal<VegetarianMeal> meal =
                new Meal<>(new VegetarianMeal());

        meal.displayMeal();
        MealGenerator.generateMeal(new VegetarianMeal());
        MealGenerator.generateMeal(new KetoMeal());
    }
}
