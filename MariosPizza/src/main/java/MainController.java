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
                case 3: visAktiveOrdre();break;
                //case 4: visDagenOrdrer();break;
                //case 4: afslutOrdre();break;

                /*case 5: visOmsætning();break;
                case 6: afslutDagen();break;
                case 9: exit();*/
                default: exit();break;


                
            }
        }
        System.out.println("Farvel og tak");
        
    }



    private void exit() {
        System.out.println("Farvel og tak");
    }

    private void visAktiveOrdre() {
        int choice = 0;
        scanner = new Scanner(System.in);
        System.out.println("Vælg ordre-id for at færdiggøre ordre (99 for at forlade)");

        for (Ordre ordre: bestillinger ) {
            System.out.println(ordre);
        }
        choice = scanner.nextInt();
        if (choice != 99) {
            try {
                Ordre ordre = getOrderById(choice);
                ordre.setStatus("FÆRDIG");
                saveOrder(ordre, "src/main/resources1/færdigeOrdrer.csv");
            }catch (IOException e) {
                e.printStackTrace();
            }catch (NoSuchOrderException e) {
                e.getMessage();
            }
        }

    }


    private void saveOrder(Ordre ordre, String path) throws IOException {
        File file = new File(path);
        FileWriter fw = new FileWriter(file,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(ordre.toString());
        bw.newLine();
        bw.close();
        fw.close();
    }


    private Ordre getOrderById(int id) throws NoSuchOrderException {
            Ordre retVal = null;
            for(Ordre ordre:bestillinger) {
                if (ordre.getOrdreID() == id) {
                    return ordre;
                }
            }
            if (retVal == null) {
                throw new NoSuchOrderException("Ingen ordrer med id: " + id);
            }
            return retVal;
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

                System.out.println("Pizza nr? (99 for at forlade)");
                pizzaNumber = scanner.nextInt();

                if (pizzaNumber != 99) {
                    try {
                        pizza = getPizzaByNumber(pizzaNumber-1);
                        ordre.addPizza(pizza);
                    } catch (NoSuchPizzaException e) {
                        e.printStackTrace();
                        choice = 99;
                    }
                }

            }

       while(!verify){
            verify = editOrder(ordre);
        }
        bestillinger.add(ordre);
        saveOrder(ordre,"src/main/resources1/aktiveOrdrer.csv");
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
