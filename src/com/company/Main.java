package com.company;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("1234567");

    public static void main(String[] args) {
        boolean quit = false;

        startPhone();
        printActions();

        while (!quit) {
            System.out.println("Enter action (6 to show availabe actions): ");
            int action = scanner.nextInt();
            scanner.nextLine();

            switch (action) {
                case 0:
                    System.out.println("Shutting down..");
                    quit = true;
                    break;
                case 1:
                    mobilePhone.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateConatact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    System.out.println("Please select the correct action");
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter new contact name: ");
        String name = scanner.nextLine();

        System.out.println("Enter phone number: ");
        String phone = scanner.nextLine();

        Contact newContact = Contact.createContact(name, phone);

        if (mobilePhone.addNewContact(newContact)) {
            System.out.println("New contact added: " + "Name: " + name + ", " + ", Phone: " + phone);
        } else {
            System.out.println("Cannot add, " + name + ", it already exists in your contact list");
        }
    }

    private static void startPhone() {
        System.out.println("Starting phone..");
    }

    private static void printActions() {
        System.out.println("\nActions: \nPress:\n" +
                "\t 0 - to shutdown \n" +
                "\t 1 - to print your contacts \n" +
                "\t 2 - to add a new contact \n" +
                "\t 3 - to update an existing contact \n" +
                "\t 4 - to remove an existing contact \n" +
                "\t 5 - to query if a contact exists \n" +
                "\t 6 - to print list of actions available \n" +
                "\n Choose your action: ");
    }
}
