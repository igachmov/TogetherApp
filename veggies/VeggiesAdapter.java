package bg.ittalents.veggies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import bg.ittalents.veggies.model.Vegetable;

/**
 * Created by Daskalski on 3/27/17.
 */

public class VeggiesAdapter extends ArrayAdapter {

    private Context context;
    private List<Vegetable> veggies;
    private List<Vegetable> ordered = new ArrayList<>();

    public int getOrderedNumber() {
        return ordered.size();
    }

    class VeggiesViewHolder{
        View row;
        ImageView image;
        TextView name;
        TextView calories;
        CheckBox checkBox;

        VeggiesViewHolder(View row){
            this.row = row;
            image = (ImageView) row.findViewById(R.id.veggie_image);
            name = (TextView) row.findViewById(R.id.veggie_name);
            calories = (TextView) row.findViewById(R.id.veggie_calories);
            checkBox = (CheckBox) row.findViewById(R.id.order_checkbox);
        }

        void clear(){
            checkBox.setChecked(false);    
            row.findViewById(R.id.veggie_desc_layout).setBackgroundResource(android.R.color.white);

        }
    }

    public VeggiesAdapter(Context context, List veggies) {
        super(context, R.layout.my_veggies_row, veggies);
        this.context = context;
        this.veggies = veggies;
    }

    @NonNull
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater li = LayoutInflater.from(context);
        final View row;
        VeggiesViewHolder vh;
        if(convertView == null) {
            row = li.inflate(R.layout.my_veggies_row, parent, false);
            vh = new VeggiesViewHolder(row);
            row.setTag(vh);
        }
        else{
            row = convertView;
            vh = (VeggiesViewHolder) row.getTag();
            vh.clear();

        }
        Log.e("krasi", "getView for position " + position + ", convert available " + (convertView != null));
        ImageView image = vh.image;
        TextView name = vh.name;
        TextView calories = vh.calories;
        CheckBox checkBox = vh.checkBox;

        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean checked) {
                if(checked){
                    ordered.add(veggies.get(position));
                    row.findViewById(R.id.veggie_desc_layout).setBackgroundResource(R.color.colorGold);
                }
                else{
                    ordered.remove(veggies.get(position));
                    row.findViewById(R.id.veggie_desc_layout).setBackgroundResource(android.R.color.white);
                }
            }
        });

        Vegetable veg = veggies.get(position);


        image.setImageResource(veg.getImage());
        name.setText(veg.getName());
        calories.setText(veg.getCalories() + " calories");

        return row;
    }
}
