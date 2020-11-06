import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Ordre {
    static int counter = 0;
    int ordreID;
    String name;
    LocalDateTime createTime;
    List<Pizza> pizzaer;
    String status;

    public Ordre(){
        this.ordreID = counter;
        this.createTime = LocalDateTime.now();
        this.pizzaer = new ArrayList<>();
        this.status = "BESTILT";
        counter++;
    }

    public int getOrdreID() {
        return ordreID;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public List<Pizza> getPizzaer() {
        return pizzaer;
    }

    public String getStatus() {
        return status;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    public void addPizza(Pizza pizza) {
        this.pizzaer.add(pizza);
    }
    public int getPrice() {
        int price = 0;
        for(Pizza thisPizza: pizzaer) {
            price += thisPizza.getPizzaPrice();
        }
        return price;
    }




    public String toString() {
        int price = this.getPrice();
        String tekstUdsnit = "";
        String pizzaerStr = "";
        for(Pizza thisPizza: pizzaer) {
            pizzaerStr += thisPizza.toString();
        }

        pizzaerStr += "";
        tekstUdsnit = "Ordre id: " + ordreID + "....... Kundenavn: " + name +
                " Bestilte pizzaer......:" + "\n" + pizzaerStr
                + "At betale: " + price + " kr......" + " Status på ordre: " + status
        + " " + createTime;
        return tekstUdsnit;

    }



}
