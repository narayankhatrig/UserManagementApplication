package com.userRegistration;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Run {

    public static void main(String[] args) {
        DataBaseStore dataBaseStore = new DataBaseStore();
        //UserStore us = new UserStore();

        while(true) {
            System.out.println("\n1. Add User");
            System.out.println("2. Delete User");
            System.out.println("3. Modify");
            System.out.println("4. Display");
            System.out.println("5. Search");

            Scanner input = new Scanner(System.in);
            System.out.println("\nEnter Your Choice:");
            int option = input.nextInt();
            if (option == 1) {
                addUsers(dataBaseStore);

            }
            if (option ==2){
                deleteUsers(dataBaseStore);
            }
            if(option == 3){
                updateUsers(dataBaseStore);
            }
            if (option == 4) {
                displayUsers(dataBaseStore);
            }
            if(option == 5){
                searchUsers(dataBaseStore);

            }
        }




    }

    public static void addUsers(DataBaseStore st){

        User user = new User();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the name:");
        user.setName(input.next());
        System.out.println("Enter Your address:");
        user.setAddress(input.next());

        st.addUser(user);


    }
    public static void deleteUsers(DataBaseStore st){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id to be deleted\n");
        int id = input.nextInt();

        st.deleteUser(id);
        System.out.println("The record is deleted\n");

    }

    public static void updateUsers(DataBaseStore st){
        User user = new User();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the id to be updated:");
        int id = input.nextInt();
        System.out.println("Enter new name");
        user.setName(input.next());
        System.out.println("Enter new name");
        user.setAddress(input.next());
        st.editUsers(user,id);
    }
    public static void displayUsers(DataBaseStore st){
        User user = new User();
        Map<Integer,User> m1 = st.display();
        for(int key:m1.keySet()){
            System.out.println("The users are given below:");
            System.out.println(m1.get(key).getName());
            System.out.println(m1.get(key).getAddress());

        }


    }

    public static void searchUsers(DataBaseStore st){
        User user = new User();
        Scanner input = new Scanner(System.in);
        System.out.println("1. Search by name");
        System.out.println("2. Search by address");
        int choice = input.nextInt();
        if(choice == 1){
            System.out.println("Enter name for search");
            String name = input.next();

            Map<Integer,User> m1 = st.searchByName(name);
            for (int key:m1.keySet()){
                System.out.println("The name is : \n");
                System.out.println(m1.get(key).getName());

            }
        }
        else if (choice == 2){
            System.out.println("Enter address for search");
            String address = input.next();

            Map<Integer,User> m2 = st.searchByAddress(address);
            for (int key:m2.keySet()){
                System.out.println("The address is : \n");
                System.out.println(m2.get(key).getAddress());

            }
        }
    }
}

