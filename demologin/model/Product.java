package bg.ittalents.demologin.model;

import java.io.Serializable;

/**
 * Created by Daskalski on 3/14/17.
 */

public class Product implements Serializable {
    private String name;
    private int price;
    private int imageId;

    public Product(String name, int price, int imageId) {
        this.name = name;
        this.price = price;
        this.imageId = imageId;
    }
}
