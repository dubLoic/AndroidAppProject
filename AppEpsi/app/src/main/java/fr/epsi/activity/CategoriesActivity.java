package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import fr.epsi.R;

public class CategoriesActivity extends MainActivity implements View.OnClickListener{

    public static void displayActivity(MainActivity activity){
        Intent intent = new Intent(activity, CategoriesActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        findViewById(R.id.rayon1).setOnClickListener(this);
        setTitle("Rayons");
        showBack();
    }

    String avatar1 = "https://cdn4.iconfinder.com/data/icons/basic-ui-pack-flat-s94-1/64/Basic_UI_Icon_Pack_-_Flat_user-512.png";
    String nomProduit = "Coca cola";
    String description = "description intéressante du produit";

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rayon1:
                ProduitListActivity.displayActivity(this, avatar1, nomProduit, description);
                break;
        }
    }
}
