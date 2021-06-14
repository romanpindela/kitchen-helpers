package com.codecool.kitchenmanagement.employee;

import com.codecool.kitchenmanagement.util.MessageBroker;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Random;

public class Chef extends Employee implements CanCook, CanRequestIngredient {

    public Chef(String name, LocalDate birthDay, BigDecimal salary) {
        super(name, birthDay, salary);
    }

    @Override
    public void cook() {
        // shouts or requests ingredients
        boolean randomCookOrShout = new Random().nextBoolean();
        if (randomCookOrShout){

        } else { // shouts
            MessageBroker.messageConsole(this + " > Hey, Let's cook :)");
        }
    }

    @Override
    public void requestIngredient() {
/*        Ingredient request

        When the chef requests an ingredient the kitchen helpers have to provide it.
                The first kitchen helper who has that ingredient should give the chef one piece.
                If none of them have any they should all yell "We're all out".*/
    }
}
