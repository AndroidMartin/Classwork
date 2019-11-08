package com.amarted.grocerylist.UI;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.amarted.grocerylist.Activities.DetailsActivity;
import com.amarted.grocerylist.Data.DatabaseHandler;
import com.amarted.grocerylist.Model.Grocery;
import com.amarted.grocerylist.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private Context context;
    private List<Grocery> groceryItems;

    /*   These next few lines are for our deletion confirmation (confirmation_dialog.xml)    */
    private AlertDialog.Builder alertDialogBuilder;
    private AlertDialog dialog;
    private LayoutInflater inflater;
    /* END OF SECTION */

    public RecyclerViewAdapter(Context context, List<Grocery> groceryItems) {
        this.context = context;
        this.groceryItems = groceryItems;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_row,viewGroup,false);
        return new ViewHolder(view, context);
    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        // THIS IS WHERE WE BIND THE DATA AND VIEWS
        Grocery grocery = groceryItems.get(position);
        holder.groceryItemName.setText(grocery.getName());
        holder.groceryItemQuantity.setText(grocery.getQuantity());
        holder.dateAdded.setText(grocery.getDateItemAdded());
        //  ^- "holder" refers to the variable created in the first line below "@Override" in this method

    }

    @Override
    public int getItemCount() {
        return groceryItems.size();
    }

    //Constructor to view each entry of the database
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //declare variables to populate each entry
        public TextView groceryItemName;
        public TextView groceryItemQuantity;
        public TextView dateAdded;
        public Button editButton;
        public Button deleteButton;
        //other variables we wish to use
        public int id;  // <--will hold the id of each item from the database

        public ViewHolder(@NonNull View view, Context ctx) {
            super(view);
            context = ctx;

            //instantiate variables to GUI objects
            groceryItemName = view.findViewById(R.id.nameID);
            groceryItemQuantity = view.findViewById(R.id.quantityID);
            dateAdded = view.findViewById(R.id.dateAddedID);
            editButton = view.findViewById(R.id.editButtonID);
            deleteButton = view.findViewById(R.id.deleteButtonID);

            //set on-click listeners for the edit and delete buttons
            editButton.setOnClickListener(this);
            deleteButton.setOnClickListener(this);
            //  using "this" allows us to pass the ID to the onClick method
            //    [note below in the "OnClick" method that we can use the "switch" clause because of this]

            //set on-click listener for the whole row
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //go to next screen --> Details Screen (DetailsActivity)
                    int position = getAdapterPosition();
                    Grocery grocery = groceryItems.get(position);
                    Intent intent = new Intent(context, DetailsActivity.class);
                    intent.putExtra("name",grocery.getName());
                    intent.putExtra("qty",grocery.getQuantity());
                    intent.putExtra("id",grocery.getId());
                    intent.putExtra("date",grocery.getDateItemAdded());
                    // intents are how you pass on to another view

                    // start activity
                    context.startActivity(intent);
                }
            });

        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.editButtonID:
                    int position = getAdapterPosition();
                    Grocery grocery = groceryItems.get(position);
                    editItem(grocery);
                    break;
                case R.id.deleteButtonID:
                    position = getAdapterPosition();
                    grocery = groceryItems.get(position);
                    deleteItem(grocery.getId());
                    break;
            }
        }

        // CREATE DELETE METHOD
        public void deleteItem(final int id){
            // create confirmation dialog
            alertDialogBuilder = new AlertDialog.Builder(context);
            inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.confirmation_dialog,null);

            Button noButton = view.findViewById(R.id.buttonDenyID);
            Button yesButton = view.findViewById(R.id.buttonConfirmID);

            alertDialogBuilder.setView(view);
            dialog = alertDialogBuilder.create();
            dialog.show();

            noButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.dismiss();
                }
            });

            yesButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    // delete the item
                    DatabaseHandler db = new DatabaseHandler(context);
                    db.deleteGrocery(id);
                    groceryItems.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                    dialog.dismiss();
                }
            });
        }

        // CREATE EDIT METHOD
        public void editItem(final Grocery grocery){
            alertDialogBuilder = new AlertDialog.Builder(context);
            inflater = LayoutInflater.from(context);
            View view = inflater.inflate(R.layout.popup,null);

            final EditText groceryItem = view.findViewById(R.id.groceryItem);
            final EditText groceryQty = view.findViewById(R.id.groceryQty);
            final TextView title = view.findViewById(R.id.title);
            Button saveButton = view.findViewById(R.id.saveButton);

            title.setText("Edit Grocery Item");
            groceryItem.setText(grocery.getName());
            groceryQty.setText (grocery.getQuantity());

            alertDialogBuilder.setView(view);
            dialog = alertDialogBuilder.create();
            dialog.show();

            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    DatabaseHandler db = new DatabaseHandler(context);

                    //Update item
                    grocery.setName(groceryItem.getText().toString());
                    grocery.setQuantity(groceryQty.getText().toString());

                    // Make sure the textViews are not empty
                    if (!groceryItem.getText().toString().isEmpty() && !groceryItemQuantity.getText().toString().isEmpty()) {
                        db.updateGrocery(grocery);
                        notifyItemChanged(getAdapterPosition(),grocery);
                    }else {
                        Snackbar.make(view, "Add Grocery and Quantity",Snackbar.LENGTH_LONG).show();
                    }

                    dialog.dismiss();
                    Toast.makeText(context, "Your item has been updated", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
