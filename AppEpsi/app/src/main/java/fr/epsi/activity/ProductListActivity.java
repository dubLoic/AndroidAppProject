package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fr.epsi.R;
import fr.epsi.entity.Category;
import fr.epsi.entity.Product;
import fr.epsi.service.ProductService;
import fr.epsi.service.ProductServiceImplementation;

public class ProductListActivity extends MainActivity{
    ProductService ps = new ProductServiceImplementation();

    ArrayList<Product> products;
    ProductAdapter productAdapter;
    RecyclerView recyclerView;

    public static void displayActivity(MainActivity activity, Category category){
        Intent intent = new Intent(activity, ProductListActivity.class);
        intent.putExtra("titre", category.getTitle());
        intent.putExtra("products_url", category.getProducts_url());
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit_list);

        setTitle(getIntent().getExtras().getString("titre",""));
        showBack();

        products = ps.getProducts(getIntent().getExtras().getString("products_url",""));
        if(products.size() > 0){
            productAdapter = new ProductAdapter(this, products);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(productAdapter);
        }
    }
}
