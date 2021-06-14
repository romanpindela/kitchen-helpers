package com.codecool.kitchenmanagement.employee;

import com.codecool.kitchenmanagement.util.MessageBroker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class KitchenHelper extends Employee {

    private Map<Ingredient, Integer> ingredients;

    public KitchenHelper(String name, LocalDate birthDay, BigDecimal salary) {
        super(name, birthDay, salary);
        ingredients = new TreeMap<>();
    }

    private boolean hasIngredient(Ingredient i){
        if (ingredients.get(i) != null){
            return ingredients.get(i) > 0;
        } else return false;
    }

    private void decreaseIngredient(Ingredient i){
        ingredients.put(i, ingredients.get(i) - 1);
    }

    public Optional<Ingredient> giveUpIngredient( Ingredient i ){
        if (hasIngredient(i)){
            decreaseIngredient(i);
            MessageBroker.messageConsole(this + " > I'm giving up " + i);
            return Optional.of(i);
        } else {
            MessageBroker.messageConsole(this + " > I'm out of " + i + " I'm getting it..");
            getIngredient(i);
            return Optional.empty();
        }
    }

    private void getIngredient ( Ingredient i ) {
        int numberOfIngredients = i.getRandomNumber();
        addToIngredients(i, numberOfIngredients );
    }

    private void addToIngredients ( Ingredient i, int numberOfIngredients ) {
        if (ingredients.get(i) != null) {
            ingredients.put(i, ingredients.get(i) + numberOfIngredients);
        } else {
            ingredients.put(i,  numberOfIngredients);
        }

    }

    public Map<Ingredient, Integer> getIngredients () {
        return ingredients;
    }


    @Override
    public String toString () {
        return "KitchenHelper {" +
                "ingredients: " + ingredients +
                '}';
    }
}
