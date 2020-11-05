public class Pizza {
    private int pizzaNumber;
    private String pizzaName;
    private double pizzaPrice;
private String ingredients;

    public Pizza(int pizzaNumber, String pizzaName, String ingredients,  double pizzaPrice) {
        this.pizzaNumber = pizzaNumber;
        this.pizzaName = pizzaName;
        this.pizzaPrice = pizzaPrice;
        this.ingredients = ingredients;
    }

    public int getPizzaNumber() {
        return pizzaNumber;
    }

    public double getPizzaPrice() {
        return pizzaPrice;
    }

    public String getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return pizzaNumber + ". " + pizzaName + ": " + ingredients + " " + pizzaPrice + ",-" + "\n";
    }
}
