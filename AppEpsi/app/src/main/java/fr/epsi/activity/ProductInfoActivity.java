package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.epsi.R;
import fr.epsi.entity.Product;
import fr.epsi.entity.Student;

public class ProductInfoActivity extends MainActivity{

    public static void displayActivity(MainActivity activity, Product product){
        Intent intent = new Intent(activity, ProductInfoActivity.class);
        intent.putExtra("Image", product.getPicture_url());
        intent.putExtra("Nom", product.getName());
        intent.putExtra("Description", product.getDescription());
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant_info);
        setTitle("Infos Etudiant");
        showBack();

        String ImageUrl = getIntent().getExtras().getString("Image","");
        String Nom = getIntent().getExtras().getString("Nom","");
        String Description = getIntent().getExtras().getString("Description","");

        ImageView imageView = findViewById(R.id.imgAvatar);
        Picasso.get().load(ImageUrl).into(imageView);

        TextView textViewName = findViewById(R.id.Name);
        if(textViewName !=null)
            textViewName.setText(Nom);

        TextView textViewDescription = findViewById(R.id.Description);
        if(textViewDescription !=null)
            textViewDescription.setText(Description);
    }
}
