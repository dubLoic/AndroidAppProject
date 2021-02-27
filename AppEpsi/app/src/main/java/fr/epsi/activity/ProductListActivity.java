package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import fr.epsi.R;
import fr.epsi.adapters.ProductAdapter;
import fr.epsi.entity.Category;
import fr.epsi.entity.Product;
import fr.epsi.service.Connection;
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
        recyclerView=findViewById(R.id.recyclerView);
        products = new ArrayList<>();

        Connection connection= new Connection(getIntent().getExtras().getString("products_url",""), new Connection.Callback() {
            @Override
            public void onComplete(String result) {
                products = ps.getProducts(result);

                productAdapter = new ProductAdapter(ProductListActivity.this, products);
                recyclerView.setLayoutManager(new LinearLayoutManager(ProductListActivity.this));
                recyclerView.setAdapter(productAdapter);
            }

            @Override
            public void onError(Exception e) {
                Toast.makeText(ProductListActivity.this,e.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
        connection.run();
    }
}
