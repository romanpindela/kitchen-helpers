package com.codecool.kitchenmanagement.kitchen;

import com.codecool.kitchenmanagement.employee.*;
import com.codecool.kitchenmanagement.util.MessageBroker;

import java.util.ArrayList;
import java.util.List;

public class Kitchen {
    private int knifeSetsCounter;
    protected Chef chef;
    protected List<Cook> cooks;
    protected List<KitchenHelper> kitchenHelpers;

    public Chef getChef () {
        return chef;
    }

    public List<Cook> getCooks () {
        return cooks;
    }

    public List<KitchenHelper> getKitchenHelpers () {
        return kitchenHelpers;
    }

    public List<Employee> getEmployees () {
        return employees;
    }

    protected List<Employee> employees;

    public Kitchen() {
        cooks = new ArrayList<Cook>();
        kitchenHelpers = new ArrayList<KitchenHelper>();
        employees = new ArrayList<Employee>();
        chef = null;
    }


    public void hireEmployee ( Employee e ) {
        if (employees.contains(e)){
            return;
        }
        if ( e instanceof Chef ) {
            hireChef(e);
        } else if ( e instanceof Cook ) {
            hireCook(e);
        } else if ( e instanceof KitchenHelper ) {
            hireKitchenHelper(e);
        }
        employees.add(e);
    }

    private void hireKitchenHelper(Employee e) {
        kitchenHelpers.add((KitchenHelper) e);
        MessageBroker.messageConsole("HIRED Kitchen helper: " + e);

    }

    private void hireCook(Employee e) {
        cooks.add((Cook) e);
        provideKnifeSet(e);
        MessageBroker.messageConsole("HIRED Cook: " + e);

    }

    private void hireChef(Employee e) {
        if (chef == null){
            chef = (Chef) e;
            chef.setKitchen(this);
            provideKnifeSet(e);
        } else {
            fireEmployee(chef);
            hireChef(e);
            MessageBroker.messageConsole("HIRED Chef: " + e);

        }
    }


    public void fireEmployee ( Employee e ) {
        if (!employees.contains(e)){
            return;
        }
        employees.remove(e);
        if ( e instanceof Chef ) {
            fireChef(e);
        } else if ( e instanceof Cook ) {
            fireCook(e);
        } else if ( e instanceof KitchenHelper ) {
            fireKitchenHelper(e);
        }
    }

    private void fireKitchenHelper ( Employee e ) {
        kitchenHelpers.remove(e);
        MessageBroker.messageConsole("FIRED Kitchen helper: " + e);
    }

    private void fireCook ( Employee e ) {
        cooks.remove(e);
        takeBackKnifesSet(e);
        MessageBroker.messageConsole("FIRED Cook: " + e);

    }

    private void fireChef ( Employee e ) {
        chef = null;
        takeBackKnifesSet(e);
        MessageBroker.messageConsole("FIRED Chef: " + e);

    }

    private void takeBackKnifesSet ( Employee e ) throws IllegalStateException {
        if (e instanceof CanCook) {
            knifeSetsCounter--;
            e.setHasKnifesSet(false);
            MessageBroker.messageConsole("Employee was taken back knife set: " + e);

        } else {
            throw new IllegalStateException("Error - This employe can't have knifes set!");
        }
    }


    public void produceMeal(){
/*        The chef

        Role of the chef
        A kitchen has only one chef.
        A kitchen can't produce meals without a chef.*/

        if (validateStartCondition()){
            startCooking();
        }
    }

    protected void startCooking () {
        for (Employee e : employees){
            if (e instanceof CanCook ){
                MessageBroker.messageConsole("Started cooking: " + e);
                ((CanCook)e).cook();
            }
        }
    }

    protected boolean validateStartCondition () {
        boolean chefNullCondition = chef == null;
        if (chefNullCondition){
            MessageBroker.messageConsole("ERROR START CONDITION: Kitchen has no chef! Hire one!");
        }

        boolean allCooksChefHasKnifesSet = true;
        for (Employee e : employees){
            if (e instanceof CanCook){
                allCooksChefHasKnifesSet = e.getHasKnifesSet() && allCooksChefHasKnifesSet;
//                MessageBroker.messageConsole(">> " + e + " has knife set to: " + e.getHasKnifesSet());
            }
        }
        if(!allCooksChefHasKnifesSet){
            MessageBroker.messageConsole("Starting cooking: ERROR START CONDITION: Not all cooks and chef has knife set! Give it to them!");
        }
/*      2nd way of checking allCooksChefHasKnifesSet condition:

        boolean allCooksChefHasKnifesSet = true;
        List<Employee> cooksAndChef = new ArrayList<>(cooks);
        cooksAndChef.add(chef);

        for (Employee e : cooksAndChef){
            if (!e.getHasKnifesSet()) {
                allCooksChefHasKnifesSet = false;
            }
        }
        if(!allCooksChefHasKnifesSet){
            MessageBroker.messageConsole("ERROR START CONDITION: Not all cooks and chef has knife set! Give it to them!");
        }*/

        return !chefNullCondition && allCooksChefHasKnifesSet;
    }


    protected void provideKnifeSet(Employee e) throws IllegalStateException{
        if (e instanceof Chef || e instanceof Cook){ // or e instanceof CanCook
            e.setHasKnifesSet(true);
            knifeSetsCounter++;
            MessageBroker.messageConsole("Provided employe with knife set: " + e);
        } else {
            throw new IllegalStateException("Error - This employe can't have knifes set!");
        }

    }


    public void showEmployees(){
        for (Employee e : employees){
            System.out.println(e);
        }
    }


}
