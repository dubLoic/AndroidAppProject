package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.epsi.R;
import fr.epsi.activity.MainActivity;

public class ProduitListActivity extends MainActivity implements View.OnClickListener{

    public static void displayActivity(MainActivity activity, String imgUrl, String nomProduit, String description){
        Intent intent = new Intent(activity, fr.epsi.activity.ProduitListActivity.class);
        intent.putExtra("imgUrl",imgUrl);
        intent.putExtra("nomProduit",nomProduit);
        intent.putExtra("description",description);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produit_list);
       /* findViewById(R.id.rayon1).setOnClickListener(this);
        findViewById(R.id.rayon2).setOnClickListener(this);*/
        setTitle("Rayons");
        showBack();

        String imgUrl = getIntent().getExtras().getString("imgUrl","");
        String nomProduit = getIntent().getExtras().getString("nomProduit","");
        String description = getIntent().getExtras().getString("description","");

        ImageView imageView = findViewById(R.id.imageViewProduit);
        Picasso.get().load(imgUrl).into(imageView);

        TextView textViewName = findViewById(R.id.textViewNomProduit);
        if(textViewName !=null)
            textViewName.setText(nomProduit);

        TextView textViewEmail = findViewById(R.id.textViewDescriptionContent);
        if(textViewEmail !=null)
            textViewEmail.setText(description);

    }

    String avatar1 = "https://cdn4.iconfinder.com/data/icons/basic-ui-pack-flat-s94-1/64/Basic_UI_Icon_Pack_-_Flat_user-512.png";
    String avatar2 = "https://png.pngtree.com/png-vector/20190223/ourmid/pngtree-vector-avatar-icon-png-image_695765.jpg";

    @Override
    public void onClick(View v) {
        /*switch (v.getId()){
            case R.id.Student1:
                EtudiantInfoActivity.displayActivity(this, avatar1, "Donatello", "Matéo", "matéo.donatello@epsi.fr", "Dev2", "http://www.epsi.fr/");
                break;
            case R.id.Student2:
                EtudiantInfoActivity.displayActivity(this, avatar2, "Legland", "Marin", "marin.legland@epsi.fr", "Dev2", "http://www.epsi.fr/");
                break;
        }*/
    }
}
