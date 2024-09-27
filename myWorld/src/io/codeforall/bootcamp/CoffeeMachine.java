package io.codeforall.bootcamp;

import java.util.ArrayList;
import java.util.Arrays;

public class CoffeeMachine {
    private String brand;
    private float weight;
    private float price;
    private String color;
    private ArrayList<String> actions; // Using ArrayList to easily manage actions
    private boolean isOn; // Status of the coffee machine

    // Constructor of the CoffeeMachine class
    public CoffeeMachine(String brand, float weight, float price, String color, String[] actions) {
        this.brand = brand;
        this.weight = weight;
        this.price = price;
        this.color = color;
        this.actions = new ArrayList<>(Arrays.asList(actions));
        this.isOn = false; // Initially, the machine is off
    }

    // Getter methods
    public String getBrand() {
        return brand;
    }

    public float getWeight() {
        return weight;
    }

    public float getPrice() {
        return price;
    }

    public String getColor() {
        return color;
    }

    public ArrayList<String> getActions() {
        return actions;
    }

    // Method to perform a specific action
    public void performAction(String action) {
        if (actions.contains(action)) {
            switch (action) {
                case "Start":
                    turnOn();
                    break;
                case "Stop":
                    turnOff();
                    break;
                case "Refill":
                    refill();
                    break;
                default:
                    System.out.println("Performing action: " + action);
                    break;
            }
        } else {
            System.out.println("Action '" + action + "' not available.");
        }
    }

    // Method to turn the coffee machine on
    public void turnOn() {
        if (!isOn) {
            isOn = true;
            System.out.println("The machine has been started.");
        } else {
            System.out.println("The machine is already on.");
        }
    }

    // Method to turn the coffee machine off
    public void turnOff() {
        if (isOn) {
            isOn = false;
            System.out.println("The machine has been stopped.");
        } else {
            System.out.println("The machine is already off.");
        }
    }

    // Method to refill the coffee machine
    public void refill() {
        System.out.println("The machine has been refilled.");
    }

    // Method to add a new action
    public void addAction(String action) {
        if (!actions.contains(action)) {
            actions.add(action);
            System.out.println("Action '" + action + "' added to the machine.");
        } else {
            System.out.println("Action '" + action + "' already exists.");
        }
    }

    // Method to show the status of the machine
    public void showStatus() {
        String status = isOn ? "on" : "off";
        System.out.println("\nMachine Status:");
        System.out.println("Brand: " + brand);
        System.out.println("Weight: " + weight + " kg");
        System.out.println("Price: " + price + " EUR");
        System.out.println("Color: " + color);
        System.out.println("Status: " + status);
        System.out.println("Available actions: " + String.join(", ", actions));
    }
}
