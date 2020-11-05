import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ImportData {

   public static ArrayList<Pizza> readPizzaCSV() throws IOException {
        String file = "src/main/resources1/pizzas.csv";
        ArrayList<Pizza> pizzas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] lineArr = line.split(";");

                Pizza pizza = new Pizza(Integer.parseInt(lineArr[0]), lineArr[1], lineArr[2], Double.parseDouble(lineArr[3]));
                pizzas.add(pizza);

            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }catch (IOException e ) {
            e.printStackTrace();
        }
        return pizzas;
    }
    public static void format() throws IOException{
       ArrayList<Pizza> tempPizza = readPizzaCSV();
        System.out.println(tempPizza.stream().map(i -> i.toString()).collect(Collectors.joining("")));
    }


}
