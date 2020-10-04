package com.example.recipesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the ArrayLists
        ArrayList<String> recipeNames = new ArrayList<>(Arrays.asList("Recipe Test", "Recipe One",
                "Recipe Two", "Recipe Three", "Recipe Four", "Recipe Five", "Recipe Six",
                "Recipe Seven", "Recipe Eight", "Recipe Nine", "Recipe Ten", "Recipe Eleven",
                "Recipe Twelve", "Recipe Thirteen", "Recipe Fourteen", "Recipe Fifteen",
                "Recipe Sixteen"));
        ArrayList<String> recipeShortDescriptions = new ArrayList<>();
        ArrayList<String> recipes = new ArrayList<>();
        ArrayList<String> images = new ArrayList<>();

        // Fill the lists of short descriptions, recipes, and images
        for (int i = 0; i < recipeNames.size(); i++) {
            recipeShortDescriptions.add("This is a short description for this delicious recipe");
            // TODO: Replace with longer recipe text
            recipes.add("");
            // TODO: Replace with real image IDs
            images.add("");
        }

        // Create the RecylerView and corresponding adapter
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecipeListAdapter listAdapter = new RecipeListAdapter(recipeNames, recipeShortDescriptions,
                recipes, images, this);

        // Set the adapter and layout manager for the RecyclerView
        recyclerView.setAdapter(listAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}