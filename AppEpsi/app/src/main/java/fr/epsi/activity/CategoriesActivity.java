package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.epsi.R;
import fr.epsi.entity.Category;
import fr.epsi.service.CategoryService;
import fr.epsi.service.CategoryServiceImplementation;

public class CategoriesActivity extends MainActivity{
    CategoryService cs = new CategoryServiceImplementation();

    ArrayList<Category> categories;
    CategoryAdapter categoryAdapter;
    RecyclerView recyclerView;

    public static void displayActivity(MainActivity activity){
        Intent intent = new Intent(activity, CategoriesActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        setTitle("Categories");
        showBack();
        recyclerView=findViewById(R.id.recyclerView);

        categories = cs.getCategories("https://djemam.com/epsi/categories.json");
        if(categories.size() > 0){
            categoryAdapter = new CategoryAdapter(this, categories);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(categoryAdapter);
        }
    }
}
