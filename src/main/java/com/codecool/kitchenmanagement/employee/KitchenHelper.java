package com.codecool.kitchenmanagement.employee;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;

public class KitchenHelper extends Employee{

    private Map<Ingredient, Integer> ingredients;

    public KitchenHelper(String name, LocalDate birthDay, BigDecimal salary) {
        super(name, birthDay, salary);
    }


}
