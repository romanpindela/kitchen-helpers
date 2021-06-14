package com.codecool.kitchenmanagement.employee;

import com.codecool.kitchenmanagement.kitchen.Kitchen;
import com.codecool.kitchenmanagement.util.MessageBroker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;

public class Chef extends Employee implements CanCook, CanRequestIngredient {

    protected Kitchen kitchen;

    public Chef(String name, LocalDate birthDay, BigDecimal salary) {
        super(name, birthDay, salary);
    }

    @Override
    public void cook() {
        // shouts or requests ingredients
        boolean randomCookOrShout = new Random().nextBoolean();
        if (randomCookOrShout){
            MessageBroker.messageConsole(printRequestedIngredients(requestIngredients()));
        } else { // shouts
            MessageBroker.messageConsole(this + " > Hey, Let's cook :)");
        }
    }

    private String printRequestedIngredients ( Map<Ingredient, Integer> requestIngredients ) {
        StringBuilder sb = new StringBuilder();
        sb.append(">> Received Ingredients: ");
        Iterator it = requestIngredients.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pair = (Map.Entry) it.next();
            sb.append(pair.getKey() + "(" + pair.getValue() + "), ");
        }
        sb.append("\n");
        return sb.toString();
    }

    public Map<Ingredient, Integer> requestIngredients () {
        Map<Ingredient, Integer> receivedIngredients = new TreeMap<>();
        for (Ingredient i : Ingredient.values()){
            receivedIngredients.put(i, requestIngredient(i));
        }
        return receivedIngredients;
    }

    @Override
    public Integer requestIngredient( Ingredient i) {
/*       Ingredient request
        When the chef requests an ingredient the kitchen helpers have to provide it.
                The first kitchen helper who has that ingredient should give the chef one piece.
                If none of them have any they should all yell "We're all out".*/
        Integer givenNumberOfReceivedIngredient = 0;
        for (Employee e : kitchen.getEmployees()){
            if (e instanceof KitchenHelper){
                Optional<Ingredient> maybeIngredient = ((KitchenHelper) e).giveUpIngredient(i);
                givenNumberOfReceivedIngredient += maybeIngredient.isPresent() ? 1: 0;
            }
        }

        if (givenNumberOfReceivedIngredient == 0) {
            MessageBroker.messageConsole("All Kitchen helpers: We're all out of " + i + " !");
        }
        System.out.println(i + " " + givenNumberOfReceivedIngredient);
        return givenNumberOfReceivedIngredient;
    }

    public Kitchen getKitchen () {
        return kitchen;
    }

    public void setKitchen ( Kitchen kitchen ) {
        this.kitchen = kitchen;
    }
}
