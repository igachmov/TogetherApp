package bg.ittalents.veggies.model;

/**
 * Created by Daskalski on 3/27/17.
 */

public class Vegetable {

    private String name;
    private int calories;
    private int image;

    public Vegetable(String name, int calories, int image) {
        this.name = name;
        this.calories = calories;
        this.image = image;
    }

    public int getCalories() {
        return calories;
    }

    public int getImage() {
        return image;
    }

    public String getName() {
        return name;
    }
}
