package io.codeforall.bootcamp;

public class Sandbox {

    public static void main(String[] args) {
        // Initializing the array of actions with some values (or empty, if preferred)
        String[] actions = new String[]{"Start", "Stop", "Refill"};

        // Creating an instance of the CoffeeMachine class
        CoffeeMachine machine = new CoffeeMachine("Nespresso", 2.3F, 89.99F, "Yellow", actions);

        // Showing the initial status of the machine
        machine.showStatus();

        // Performing some actions
        machine.performAction("Start");
        machine.performAction("Refill");
        machine.performAction("Stop");

        // Adding a new action to the machine
        machine.addAction("Self-clean");

        // Trying to perform the new action
        machine.performAction("Self-clean");

        // Checking the status of the machine after performing actions
        machine.showStatus();
    }
}








