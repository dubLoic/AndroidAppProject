package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.epsi.R;
import fr.epsi.entity.Category;

public class CategoriesActivity extends MainActivity{
    CategoryService es = new CategoryServiceImplementation();

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
    }
}
