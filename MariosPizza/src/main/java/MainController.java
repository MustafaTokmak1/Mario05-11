import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainController {
    MenuImp menuImp = new MenuImp();
    Scanner scanner;
    List<Pizza> pizzaer = new ArrayList<>();
    List<Ordre> bestillinger = new ArrayList<>();
    
    public void runProgram() throws IOException {
        pizzaer = ImportData.readPizzaCSV();
        int choice = 0;
        int exitValue = 9;

        scanner = new Scanner(System.in);
        while (choice != exitValue){
            menuImp.printMainMenu();
            choice = scanner.nextInt();
            //Kører hovedloopet
            
            switch(choice){
                case 1: visMenukort();break;
                case 2: lavOrdre();break;
                /*case 3: afslutOrdre();break;
                case 4: visAktiveOrdre();break;
                case 5: visOmsætning();break;
                case 6: afslutDagen();break;
                case 9: exit();
                default: fejl();break;

                 */
                
            }
        }
        System.out.println("farvel og tak");
        
    }



    private void lavOrdre() throws IOException {
        Ordre ordre = new Ordre();
        List<Pizza> pizzaer = new ArrayList<>();
        String name = "";
        int choice = 0;
        boolean verify = false;
        int pizzaNumber = 0;
        Pizza pizza = null;
        scanner = new Scanner(System.in);
        System.out.println("Navn?");
        name = scanner.nextLine();
        ordre.setName(name);

       while (pizzaNumber!=99) {

                System.out.println("Pizza nr (99 for exit)");
                pizzaNumber = scanner.nextInt();

                if (pizzaNumber != 99) {
                    try {
                        pizza = getPizzaByNumber(pizzaNumber);
                        ordre.addPizza(pizza);
                    } catch (NoSuchPizzaException e) {
                        e.printStackTrace();
                        choice = 99;
                    }
                }

            }
       /*
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File("src/main/resources1/gemtPizza.csv")));
       writer.write(String.valueOf(pizza));
       writer.close();*/

       while(!verify){
            verify = editOrder(ordre);
        }
        bestillinger.add(ordre);
        //menuImp.printMainMenu();
    }

    private boolean editOrder(Ordre ordre) {
        boolean retval = true;
        return retval;
    }

    private Pizza getPizzaByNumber(int pizzaNumber) throws NoSuchPizzaException {
        Pizza pizza = null;
        try {
            pizza = pizzaer.get(pizzaNumber);
    }  catch (IndexOutOfBoundsException e) {
            throw new NoSuchPizzaException("Pizza findes ikke");
        }
        if (pizza == null){
            throw new NoSuchPizzaException("Pizza findes ikke");

        }
        return pizza;
        }


    private void visMenukort() throws IOException {
        ImportData.format();
       // menuImp.printMainMenu();
    }
}
