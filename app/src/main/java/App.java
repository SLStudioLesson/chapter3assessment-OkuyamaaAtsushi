import com.recipeapp.datahandler.CSVDataHandler;
import com.recipeapp.datahandler.DataHandler;
import com.recipeapp.datahandler.JSONDataHandler;
import com.recipeapp.ui.RecipeUI;
import java.io.*;

public class App {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Choose the file format:");
            System.out.println("1. CSV");
            System.out.println("2. JSON");
            System.out.print("Select (1/2): ");
            String choice = reader.readLine();

            switch(choice){
                case "1":
                DataHandler csvDataHandler = new CSVDataHandler();
                RecipeUI recipeUI = new RecipeUI(csvDataHandler);
                RecipeUI.displayMenu();
                break;

                case "2":
                DataHandler jsonDataHandler = new JSONDataHandler();
                recipeUI = new RecipeUI(jsonDataHandler);
                RecipeUI.displayMenu();
                break;

                default:
                csvDataHandler = new CSVDataHandler();
                recipeUI = new RecipeUI(csvDataHandler);
                RecipeUI.displayMenu();
                break;

            }


            

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        
    }
    
}