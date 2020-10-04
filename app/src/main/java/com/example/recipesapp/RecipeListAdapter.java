package com.example.recipesapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * The RecipeListAdapter used to provide data for the RecycleView that displays our recipe list
 */
public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder> {
    private final ArrayList<String> recipeNames;
    private final ArrayList<String> shortDescriptions;
    private final ArrayList<String> longDescriptions;
    private final ArrayList<Integer> images;
    private LayoutInflater layoutInflater;
    private Context context;

    /**
     * Constructor for our RecipeListAdapter
     * @param recipeNames The array of recipe names
     * @param shortDescriptions The array of short descriptions for the recipes
     * @param longDescriptions The array of long descriptions, containing the actual recipes
     * @param images The array of image IDs, used to display the images
     * @param context The app Context
     */
    public RecipeListAdapter(ArrayList<String> recipeNames, ArrayList<String> shortDescriptions,
                             ArrayList<String> longDescriptions, ArrayList<Integer> images,
                             Context context) {
        this.recipeNames = recipeNames;
        this.shortDescriptions = shortDescriptions;
        this.longDescriptions = longDescriptions;
        this.images = images;
        this.context = context;
        this.layoutInflater = LayoutInflater.from(context);
    }

    /**
     * Called when the RecipeViewHolder is being created
     * @param parent The parent ViewGroup
     * @param viewType The view type, unused in our case
     * @return The RecipeViewHolder
     */
    @NonNull
    @Override
    public RecipeListAdapter.RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                                 int viewType) {
        View recipeView = layoutInflater.inflate(R.layout.recipelist_item, parent,
                false);
        return new RecipeViewHolder(recipeView, this);
    }

    /**
     * Sets the name and description in the RecipeViewHolder when necessary
     * @param holder The RecipeViewHolder
     * @param position The position in the list
     */
    @Override
    public void onBindViewHolder(@NonNull RecipeListAdapter.RecipeViewHolder holder, int position) {
        String currentName = recipeNames.get(position);
        String currentDescription = shortDescriptions.get(position);

        holder.recipeTitleView.setText(currentName);
        holder.recipeDescriptionView.setText(currentDescription);
    }

    /**
     * Returns the item count for the list
     * @return The size of the recipeNames list, as this will dictate the number of items
     */
    @Override
    public int getItemCount() {
        return recipeNames.size();
    }

    /**
     * The RecipeViewHolder, which holds the view for each item in the list
     */
    public class RecipeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public final TextView recipeTitleView;
        public final TextView recipeDescriptionView;
        final RecipeListAdapter adapter;

        /**
         * Constructor for the RecipeViewHolder
         * @param itemView The view for the individual list item
         * @param adapter The RecipeListAdapter being used
         */
        public RecipeViewHolder(@NonNull View itemView, RecipeListAdapter adapter) {
            super(itemView);
            recipeTitleView = itemView.findViewById(R.id.title);
            recipeDescriptionView = itemView.findViewById(R.id.description);
            this.adapter = adapter;
            itemView.setOnClickListener(this);
        }

        /**
         * Open the recipe in a new view when the user clicks
         * @param v The view, unused for our purposes
         */
        @Override
        public void onClick(View v) {
            int position = getLayoutPosition();
            String recipe = longDescriptions.get(position);
            Integer imageID = images.get(position);

            // Create an intent and pass in the recipe and image ID
            Intent recipeIntent = new Intent(context, RecipeActivity.class);
            recipeIntent.putExtra("recipe", recipe);
            recipeIntent.putExtra("image", imageID);
            context.startActivity(recipeIntent);
        }
    }
}
