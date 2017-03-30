package bg.ittalents.veggies;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import bg.ittalents.veggies.model.Vegetable;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.veggies_list);
        final List<Vegetable> veggies = new ArrayList<>();
        for(int i = 0; i < 2000; i++) {
            veggies.add(new Vegetable("Potato", 320, R.drawable.potato));
            veggies.add(new Vegetable("Broccoli", 120, R.drawable.broccoli));
            veggies.add(new Vegetable("Lettuce", 4, R.drawable.lettuce));
            veggies.add(new Vegetable("Pumpkin", 444, R.drawable.pumpkin));
            veggies.add(new Vegetable("Broccoli", 120, R.drawable.broccoli));
        }

        MyRecyclerViewAdapter adapter = new MyRecyclerViewAdapter(this, veggies);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2, LinearLayoutManager.HORIZONTAL, false));


    }
}
