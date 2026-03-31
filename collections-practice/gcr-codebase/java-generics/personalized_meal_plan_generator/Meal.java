package personalized_meal_plan_generator;

public class Meal<T extends MealPlan> {
    private T meal;

    public Meal(T meal) {
        this.meal = meal;
    }

    public void displayMeal() {
        System.out.println("Selected Meal Plan: " + meal.getMealType());
    }
}
