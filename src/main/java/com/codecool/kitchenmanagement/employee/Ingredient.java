package com.codecool.kitchenmanagement.employee;

import java.util.Random;

public enum Ingredient {
    MEAT, POTATO, CARROT;

    int getRandomNumber(){
        return new Random().nextInt(Ingredient.values().length);
    }
}
