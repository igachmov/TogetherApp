package bg.ittalents.demologin.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by Daskalski on 3/14/17.
 */

public class User implements Serializable {

    private String username;
    private String password;
    private ArrayList<Product> kolichka;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.kolichka = new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public List<Product> getKolichka() {
        return Collections.unmodifiableList(kolichka);
    }

    public void addProduct(Product p){
        kolichka.add(p);
    }
}
