package com.codecool.kitchenmanagement.employee;

import java.util.Random;

public enum Ingredient {
    MEAT, POTATO, CARROT;

    int getRandomNumber(){
        int i =  new Random().nextInt(Ingredient.values().length);
        return i;
    }
}
