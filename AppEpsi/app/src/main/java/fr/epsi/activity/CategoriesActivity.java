package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.epsi.R;
import fr.epsi.adapters.CategoryAdapter;
import fr.epsi.entity.Category;
import fr.epsi.service.CategoryService;
import fr.epsi.service.CategoryServiceImplementation;
import fr.epsi.service.Connection;

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
        Log.d("Categories","############## Categories : ################# :");

        setContentView(R.layout.activity_categories);
        setTitle("Categories");
        showBack();
        recyclerView=findViewById(R.id.recyclerView);

        categories = new ArrayList<>();

        Connection connection= new Connection("https://djemam.com/epsi/categories.json", new Connection.Callback() {
            @Override
            public void onComplete(String result) {
                Log.d("Categories","############## " + result + " ################# :");
                categories = cs.getCategories(result);

                categoryAdapter = new CategoryAdapter(CategoriesActivity.this, categories);
                recyclerView.setLayoutManager(new LinearLayoutManager(CategoriesActivity.this));
                recyclerView.setAdapter(categoryAdapter);
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(CategoriesActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        connection.run();
    }
}
