package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.epsi.R;

public class EtudiantInfoActivity extends MainActivity{

    public static void displayActivity(MainActivity activity, String AvatarUrl, String Nom, String Prenom, String Email, String Groupe, String profileUrl){
        Intent intent = new Intent(activity, EtudiantInfoActivity.class);
        intent.putExtra("AvatarUrl",AvatarUrl);
        intent.putExtra("Nom",Nom);
        intent.putExtra("Prenom",Prenom);
        intent.putExtra("Email",Email);
        intent.putExtra("Groupe",Groupe);
        intent.putExtra("profileUrl",profileUrl);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant_info);
        setTitle("Infos Etudiant");
        showBack();

        String AvatarUrl = getIntent().getExtras().getString("AvatarUrl","");
        String Nom = getIntent().getExtras().getString("Nom","");
        String Prenom = getIntent().getExtras().getString("Prenom","");
        String Email = getIntent().getExtras().getString("Email","");
        String Groupe = getIntent().getExtras().getString("Groupe","");
        String profileUrl = getIntent().getExtras().getString("profileUrl","");

        ImageView imageView = findViewById(R.id.imgAvatar);
        Picasso.get().load(AvatarUrl).into(imageView);

        TextView textViewName = findViewById(R.id.Name);
        if(textViewName !=null)
            textViewName.setText(Nom+" "+Prenom);

        TextView textViewEmail = findViewById(R.id.Email);
        if(textViewEmail !=null)
            textViewEmail.setText(Email);

        TextView textViewGroupe = findViewById(R.id.Groupe);
        if(textViewGroupe !=null)
            textViewGroupe.setText(Groupe);


        TextView textViewProfileLink = findViewById(R.id.ProfileLink);
        if(textViewProfileLink !=null)
            textViewProfileLink.setText(profileUrl);
    }
}
