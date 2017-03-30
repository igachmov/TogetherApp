package bg.ittalents.veggies;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import bg.ittalents.veggies.model.Vegetable;

/**
 * Created by Daskalski on 3/28/17.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewAdapter.MyViewHolder> {

    private List<Vegetable> veggies;
    private Context context;

    public MyRecyclerViewAdapter(Context context, List<Vegetable> veggies){
        this.veggies =veggies;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(context);
        View row = li.inflate(R.layout.my_veggies_row, parent, false);
        MyViewHolder vh = new MyViewHolder(row);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Vegetable veg = veggies.get(position);
        holder.image.setImageResource(veg.getImage());
        holder.name.setText(veg.getName());
        holder.calories.setText(veg.getCalories() + " calories");
    }

    @Override
    public int getItemCount() {
        return veggies.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder{

        View row;
        ImageView image;
        TextView name;
        TextView calories;
        CheckBox checkBox;

        MyViewHolder(View row){
            super(row);
            this.row = row;
            image = (ImageView) row.findViewById(R.id.veggie_image);
            name = (TextView) row.findViewById(R.id.veggie_name);
            calories = (TextView) row.findViewById(R.id.veggie_calories);
            checkBox = (CheckBox) row.findViewById(R.id.order_checkbox);
        }
    }
}
