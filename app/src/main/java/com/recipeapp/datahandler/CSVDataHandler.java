package com.recipeapp.datahandler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import com.recipeapp.model.Ingredient;
import com.recipeapp.model.Recipe;

public class CSVDataHandler implements DataHandler{
    
    private String filePath;

    public CSVDataHandler(){
        this.filePath = "app/src/main/resources/recipes.csv";
    }

    public CSVDataHandler(String filePath){
        this.filePath = filePath;
    }

    @Override
    public String getMode(){
        return "CSV";
    }

    @Override
    public ArrayList<Recipe> readData()throws IOException{
        ArrayList<Recipe> recipe = new ArrayList<>();

       String line;
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
             while((line = reader.readLine()) != null){
                ArrayList<Ingredient> ingredients = new ArrayList<>();
                String[] word = line.split(",");
                for(int i = 1; i < word.length; i++){
                    Ingredient a = new Ingredient(word[i]);
                    ingredients.add(a);
                }
                Recipe b = new Recipe(word[0], ingredients);
                recipe.add(b);
             }
             if(recipe.isEmpty()){
                return null;
             }

        }catch(IOException e){
            System.out.println("Error reading file: " + e);
        }
        return recipe;
    }

    @Override
    public void writeData(Recipe recipe)throws IOException{
        String line;
        String text = "";
        String word = "";
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            while((line = reader.readLine()) != null){
                text += line + "\n";
            }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){

            for (Ingredient ingredient : recipe.getIngredients()){
                word += ingredient.getName() + ", ";
            }
            writer.write(text + recipe.getName() + "," + word);
         }catch(IOException e){
            System.out.println("Failed to add new recipe: " + e);
        }
    
    }
    }
    @Override
    public ArrayList<Recipe> sarchData(String keyword)throws IOException{
        return null;
    }
}
