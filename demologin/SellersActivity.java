package bg.ittalents.demologin;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

import bg.ittalents.demologin.model.User;

public class SellersActivity extends AppCompatActivity {

    private ArrayList<String> sellers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sellers);

        User u = (User) getIntent().getExtras().getSerializable("user");

        Button b1 = (Button) findViewById(R.id.b1);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:0888035686"));
                if (ActivityCompat.checkSelfPermission(SellersActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    // TODO: Consider calling
                    //    ActivityCompat#requestPermissions
                    // here to request the missing permissions, and then overriding
                    //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
                    //                                          int[] grantResults)
                    // to handle the case where the user grants the permission. See the documentation
                    // for ActivityCompat#requestPermissions for more details.
                    return;
                }
                SellersActivity.this.startActivity(intent);
            }
        });
        Button b2 = (Button) findViewById(R.id.b2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.abv.bg"));
                startActivity(intent);
            }
        });
        Button b3 = (Button) findViewById(R.id.b3);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent("zaiobaio");
                intent.addCategory(Intent.CATEGORY_DEFAULT);
                startActivity(intent);
            }
        });

        int x = 3;

        for(int i = 0; i < x; i++){
            sellers.add(u.getPassword());
        }

        switch (sellers.size()){
            case 3:
                b3.setText(sellers.get(2));
                b3.setVisibility(View.VISIBLE);
            case 2:
                b2.setText(sellers.get(1));
                b2.setVisibility(View.VISIBLE);
            case 1:
                b1.setText(sellers.get(0));
                b1.setVisibility(View.VISIBLE);
                break;
            default:
                if(sellers.isEmpty()){
                    return;
                }
                int rand1 = new Random().nextInt(sellers.size());
                ArrayList<String> copiedSellers = (ArrayList<String>) sellers.clone();
                String seller1 = copiedSellers.remove(rand1);
                b1.setText(seller1);
                int rand2 = new Random().nextInt(sellers.size());
                String seller2 = copiedSellers.remove(rand2);
                b2.setText(seller2);
                int rand3 = new Random().nextInt(sellers.size());
                String seller3 = copiedSellers.remove(rand3);
                b3.setText(seller3);
                b1.setVisibility(View.VISIBLE);
                b2.setVisibility(View.VISIBLE);
                b3.setVisibility(View.VISIBLE);

        }
    }
}
