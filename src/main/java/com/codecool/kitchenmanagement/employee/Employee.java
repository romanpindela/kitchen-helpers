package com.codecool.kitchenmanagement.employee;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Employee {
    private static final BigDecimal SALARY_TAX = BigDecimal.valueOf(0.99);
    private String name;
    private LocalDate birthDay;
    private BigDecimal salary;
    private boolean hasKnifesSet = false;


    public boolean getHasKnifesSet () {
        return hasKnifesSet;
    }

    public void setHasKnifesSet ( boolean hasKnifesSet ) {
        this.hasKnifesSet = hasKnifesSet;
    }

    public Employee(String name, LocalDate birthDay, BigDecimal salary) {
        this.name = name;
        this.birthDay = birthDay;
        this.salary = salary;
    }

    public String getTax(){
        StringBuilder sb = new StringBuilder();
        sb.append(name + "'s tax: ");
        sb.append( salary.multiply(SALARY_TAX).toString() + " \n");
        return sb.toString();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +" > Employee{" +
                "name='" + name + '\'' +
                ", birthDay=" + birthDay +
                ", salary=" + salary +
                "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

}
