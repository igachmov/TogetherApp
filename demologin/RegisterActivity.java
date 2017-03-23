package bg.ittalents.demologin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import bg.ittalents.demologin.model.User;

public class RegisterActivity extends AppCompatActivity {

    public static final int RESULT_CODE_CANCELED = 5;
    public static final int RESULT_CODE_SUCCESS = 3;
    private Button registerConfirmButton;
    private Button cancelButton;
    private EditText user;
    private EditText pass1;
    private EditText pass2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        registerConfirmButton = (Button) findViewById(R.id.reg_confirm_button);
        cancelButton = (Button) findViewById(R.id.cancel_button);
        user = (EditText) findViewById(R.id.reg_user);
        pass1 = (EditText) findViewById(R.id.reg_pass1);
        pass2 = (EditText) findViewById(R.id.reg_pass2);

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(RESULT_CODE_CANCELED);//canceled
                finish();
            }
        });

        registerConfirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validations
                User u = new User(user.getText().toString(), pass1.getText().toString());
                MainActivity.registeredUsers.add(u);
                Toast.makeText(RegisterActivity.this, "reg successful", Toast.LENGTH_SHORT).show();

                //return added data and a result code
                Intent intent = new Intent();
                intent.putExtra("user", u.getUsername());
                intent.putExtra("pass", u.getPassword());
                setResult(RESULT_CODE_SUCCESS, intent);//ok
                finish();
            }
        });
    }
}
