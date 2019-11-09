package data;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.amarted.mycaloriecounter.FoodItemDetailsActivity;
import com.amarted.mycaloriecounter.R;

import java.util.ArrayList;

import model.Food;

public class CustomListviewAdapter extends ArrayAdapter<Food> {
    private int layoutResource;
    private Activity activity;
    private ArrayList<Food> foodList = new ArrayList<>();


    public CustomListviewAdapter(Activity act, int resource, ArrayList<Food> data) {
        super(act, resource, data);
        layoutResource = resource;
        activity = act;
        foodList = data;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Food getItem(int position) {
        return foodList.get(position);
    }

    @Override
    public int getPosition(Food item) {
        return super.getPosition(item);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        //   ***  THIS IS WHERE WE INFLATE ALL OUR VIEWS ***
        //TODO: Inflate your views

        // THIS IS HOW WE ARE POPULATING EACH "ROW" IN OUR MAIN VIEW
        View row = convertView;
        ViewHolder holder = null;

      //if (row is null OR rog.getTag is null
        if (row == null || (row.getTag() == null)) {
            //then create this row - instantiate this object
            LayoutInflater inflater = LayoutInflater.from(activity);
            row = inflater.inflate(layoutResource,null);

            holder = new ViewHolder();
            //              ^-  the class we created down below
            holder.foodName = row.findViewById(R.id.name);
                    //         ^- now contains our list_row.xml file
            holder.foodDate = row.findViewById(R.id.dateText);
            holder.foodCalories = row.findViewById(R.id.calories);

            row.setTag(holder);
        }else {
            holder = (ViewHolder) row.getTag();
        }

        holder.food = getItem(position);

        holder.foodName.setText(holder.food.getFoodName());
        holder.foodCalories.setText(String.valueOf(holder.food.getCalories()));
        holder.foodDate.setText(holder.food.getRecordDate());

        final ViewHolder finalHolder = holder; // <- to 'finalize' so we can call it from the onClickListener

        // SET ON-CLICK LISTENER TO DISPLAY DETAIL VIEW
        row.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create intent
                Intent i = new Intent(activity, FoodItemDetailsActivity.class);
                //                       |                  ^- where we want to go
                //                       |- instance variable created at the top, set to the activity that calls the method

                // "Freeze" the 'food' object and pass it on to the FoodItemDetailsActivity
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("userObj", finalHolder.food);
                //                         |             |- what we are "freezing" - from above
                //                         |- whatever you want
                i.putExtras(mBundle);

                activity.startActivity(i);
       //          ^- current activiy we're in
            }
        });

        return row;
    }



    public class ViewHolder {
        Food food;
        TextView foodName;
        TextView foodCalories;
        TextView foodDate;
    }
}
