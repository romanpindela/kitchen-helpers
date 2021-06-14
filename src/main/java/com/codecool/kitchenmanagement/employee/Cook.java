package com.codecool.kitchenmanagement.employee;

import com.codecool.kitchenmanagement.util.MessageBroker;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Cook extends Employee implements CanCook{
    public Cook(String name, LocalDate birthDay, BigDecimal salary) {
        super(name, birthDay, salary);
    }

    @Override
    public void cook () {
        MessageBroker.messageConsole(this + " I'm cooking !!!");
    }
}
