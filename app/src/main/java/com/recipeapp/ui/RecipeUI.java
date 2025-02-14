package com.recipeapp.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;


public class RecipeUI {
    private static BufferedReader reader;
    private static DataHandler dataHandler;

    public RecipeUI(DataHandler dataHandler) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.dataHandler = dataHandler;
    }
    
    public static void displayMenu() {
        System.out.println("Current mode: " + dataHandler.getMode());

        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":displayRecipes();
                        break;
                    case "2":
                        break;
                    case "3":
                        break;
                    case "4":
                        System.out.println("Exiting the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    private static void displayRecipes(){
        try{ArrayList<Recipe> recipes = dataHandler.readData();
            System.out.println("Recipes: ");
            for(Recipe recipes2 : recipes){
                System.out.println("-----------------------------------");
                System.out.println("Recipe Name: " + recipes2.getname());
                for(Ingredient ingredients : recipes2.getIngredients()){
                    System.out.print(ingredients.getName());
                }
            }
           
        }catch(IOException e){
            System.out.println("Error reading file: " + e);
        }
    }

    private void addNewRecipe(Recipe recipe){
        String line
        
    }
}
