package model;

import java.util.ArrayList;
import java.util.List;

public class Dish {

    private String name;
    private List<String> ingredients;
    private String recipe;
    private String description;

    public Dish(String name) {
        this.name = name;
        ingredients = new ArrayList<>();
        recipe = "";
        description = "";
    }

    public Dish(String name, String description, List<String> ingredients, String recipe) {
        this.name = name;
        this.description = description;
        this.ingredients = ingredients;
        this.recipe = recipe;
    }

    // getters
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getRecipe() {
        return recipe;
    }

    // methods
    public void addIngredient(String ingredient) {
        if (!this.ingredients.contains(ingredient)) {
            ingredients.add(ingredient);
        }
    }
    public void removeIngredient(String ingredient) {
        if (this.ingredients.contains(ingredient)) {
            ingredients.remove(ingredient);
        }
    }
}
