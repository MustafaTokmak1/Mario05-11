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
        this.status = "CREATED";
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
        String show = "";
        String pizzaerStr = "@";
        for(Pizza thisPizza: pizzaer) {
            pizzaerStr += thisPizza.toString();
        }
        pizzaerStr += "@";
        //show = String.format("%d phone: %d, %s, price: %d, status: %s\n",ordreID,phone,buketterStr,price, status);
        show = String.format("%d;%d;%s;%d;%s",ordreID,name,pizzaerStr,price, status);
        return show;
    }
}
