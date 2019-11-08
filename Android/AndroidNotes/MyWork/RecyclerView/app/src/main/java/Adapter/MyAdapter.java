package Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.amarted.recyclerview.DetailsActivity;
import com.amarted.recyclerview.R;

import java.util.ArrayList;
import java.util.List;

import Model.ListItem;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    // Define your variables
    private Context context;
    private List<ListItem> listItems;

    // Create your Constructor(s)
    public MyAdapter(Context context, List listItem) {
        this.context = context;
        this.listItems = listItem;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder holder, int postion) {
        // Create "list item model object"
        ListItem item = listItems.get(postion);

        // Bind views to the data source and then the recycler viewer
        holder.name.setText(item.getName());
        holder.description.setText(item.getDescription());
        holder.rating.setText(item.getRating());


    }

    @Override
    public int getItemCount() {
        // Return the size of listItems
        return listItems.size();
    }

    // Creating "ViewHolder" which is being called in the top line - public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>  <--that last part
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        // Set-up "objects" in the view - similar to what you'd do in the design view
        public TextView name;
        public TextView description;
        public TextView rating;

        //Constructor for the ViewHolder class
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            //listItems = items;
            //get the Activity Context
            //context = ctx;

            // Pass items to detail view
            itemView.setOnClickListener(this);

            name = (TextView) itemView.findViewById(R.id.title);
            description = (TextView)itemView.findViewById(R.id.description);
            rating = (TextView) itemView.findViewById(R.id.rating);
        }

        @Override
        public void onClick(View v) {
            //Get position of row clicked or tapped (int)
            int position = getAdapterPosition();
            ListItem item = listItems.get(position);
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("name",item.getName());
            intent.putExtra("description",item.getDescription());
            intent.putExtra("rating",item.getRating());

            context.startActivity(intent);

            Toast.makeText(context, item.getName(), Toast.LENGTH_LONG).show();
        }
    }
}
