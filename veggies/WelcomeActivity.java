package bg.ittalents.veggies;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);



        FragmentManager fm = getSupportFragmentManager();
        if(fm.getFragments() == null || fm.getFragments().isEmpty()) {
            fm.beginTransaction()
                    .add(R.id.activity_welcome, new FragmentA(), "FragA0")
                    .add(R.id.activity_welcome, new FragmentA(), "FragA1")
                    .add(R.id.activity_welcome, new FragmentA(), "FragA2")
                    .add(R.id.activity_welcome, new FragmentA(), "FragA3")
                    .add(R.id.activity_welcome, new FragmentA(), "FragA4")
                    .commit();
        }
    }
}
