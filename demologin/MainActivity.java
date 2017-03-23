package bg.ittalents.demologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import bg.ittalents.demologin.model.Product;
import bg.ittalents.demologin.model.User;

//login ama aide
public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private Button registerButton;
    private EditText user;
    private EditText pass;
    public static ArrayList<User> registeredUsers = new ArrayList<>();
    public static User loggedUser = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        User ivan = new User("ivan", "ivo123");
        ivan.addProduct(new Product("NorthFace", 300, R.drawable.northface));
        ivan.addProduct(new Product("Nike", 345, R.drawable.nike));
        registeredUsers.add(ivan);
        User gosho = new User("gosho", "ggg");
        gosho.addProduct(new Product("Adidas", 222, R.drawable.adidas));
        gosho.addProduct(new Product("NorthFace", 221, R.drawable.northface));
        registeredUsers.add(gosho);

        loginButton = (Button) findViewById(R.id.login_button);
        user = (EditText) findViewById(R.id.login_user);
        pass = (EditText) findViewById(R.id.login_pass);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean loginOk = false;
                for(User u : registeredUsers){
                    Log.e("krasi", u.getUsername());
                    if(u.getUsername().equals(user.getText().toString()) &&
                       u.getPassword().equals(pass.getText().toString()) ){
                        Toast.makeText(MainActivity.this, "Login successful", Toast.LENGTH_SHORT).show();
                        loginOk = true;
                        loggedUser = u;

                        Intent intent = new Intent(MainActivity.this, SellersActivity.class);
                        Bundle bagaj = new Bundle();
                        bagaj.putSerializable("user", u);
                        intent.putExtras(bagaj);
                        startActivity(intent);
                        break;
                    }

                }
                if(!loginOk){
                    Toast.makeText(MainActivity.this, "You do not exist!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        registerButton = (Button) findViewById(R.id.reg_button);
        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RegisterActivity.RESULT_CODE_CANCELED){
            Toast.makeText(this, "e za kvo se otkaza ot registracia?", Toast.LENGTH_SHORT).show();
        }
        if(resultCode == RegisterActivity.RESULT_CODE_SUCCESS){
            if(data != null){
                user.setText(data.getStringExtra("user"));
                pass.setText(data.getStringExtra("pass"));
            }
        }
    }
}
