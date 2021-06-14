package com.codecool.kitchenmanagement;

import com.codecool.kitchenmanagement.employee.Chef;
import com.codecool.kitchenmanagement.employee.Cook;
import com.codecool.kitchenmanagement.employee.Employee;
import com.codecool.kitchenmanagement.employee.KitchenHelper;
import com.codecool.kitchenmanagement.kitchen.Kitchen;
import com.codecool.kitchenmanagement.util.MessageBroker;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Employee Cook1 = new Cook("Andy",LocalDate.parse("1985-04-04"),new BigDecimal(2200));
        Employee Cook2 = new Cook("Andrew",LocalDate.parse("1988-05-03"),new BigDecimal(2100));
        Employee Chef1 = new Chef("Kate",LocalDate.parse("1970-08-10"),new BigDecimal(3200));
        Employee Chef2 = new Chef("Nancy",LocalDate.parse("1986-03-13"),new BigDecimal(3000));
        Employee KitchHelper1 = new KitchenHelper("Johny",LocalDate.parse("1991-04-04"),new BigDecimal(1200));
        Employee KitchHelper2 = new KitchenHelper("Kevin",LocalDate.parse("1995-05-01"),new BigDecimal(1100));
        Employee KitchHelper3 = new KitchenHelper("Whitney",LocalDate.parse("1987-12-03"),new BigDecimal(1170));
        Employee KitchHelper4 = new KitchenHelper("Bob",LocalDate.parse("1978-02-19"),new BigDecimal(1320));



        Kitchen kitchen = new Kitchen();
        kitchen.produceMeal();
        MessageBroker.messageConsole("---------------------------------");

        kitchen.hireEmployee(Cook1);
        kitchen.hireEmployee(Cook2);
        kitchen.hireEmployee(Chef1);
        kitchen.hireEmployee(Chef2);
        kitchen.hireEmployee(KitchHelper1);
        kitchen.hireEmployee(KitchHelper2);
        kitchen.hireEmployee(KitchHelper3);
        kitchen.hireEmployee(KitchHelper4);
        MessageBroker.messageConsole("---------------------------------");

        kitchen.showEmployees();
        MessageBroker.messageConsole("---------------------------------");

        kitchen.fireEmployee(KitchHelper3);
        kitchen.fireEmployee(Chef1);
        kitchen.fireEmployee(KitchHelper4);
        kitchen.hireEmployee(Chef2);

        MessageBroker.messageConsole("---------------------------------");
        kitchen.showEmployees();
        MessageBroker.messageConsole("---------------------------------");
        kitchen.produceMeal();


//        System.out.println("Ramsay: WHAT ARE YOU?");
//        System.out.println("Kitchen helper: An idiot sandwich.");
//		System.out.println("Ramsay: IDIOT SANDWICH WHAT?");
//		System.out.println("Kitchen helper: An idiot sandwich, chef Ramsay.");
    }
}
