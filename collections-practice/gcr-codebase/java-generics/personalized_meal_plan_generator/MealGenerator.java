package personalized_meal_plan_generator;

public class MealGenerator {
    public static <T extends MealPlan> void generateMeal(T meal) {
        System.out.println("Generating " + meal.getMealType());
    }
}
