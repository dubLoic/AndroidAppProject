package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import fr.epsi.R;
import fr.epsi.entity.Student;

public class StudentInfoActivity extends MainActivity{

    public static void displayActivity(MainActivity activity, Student student){
        Intent intent = new Intent(activity, StudentInfoActivity.class);
        intent.putExtra("AvatarUrl", student.getUrl());
        intent.putExtra("Nom", student.getName());
        intent.putExtra("Email", student.getEmail());
        intent.putExtra("Groupe", student.getGroup());
        intent.putExtra("profileUrl", student.getWebsite());
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
        String Email = getIntent().getExtras().getString("Email","");
        String Groupe = getIntent().getExtras().getString("Groupe","");
        String profileUrl = getIntent().getExtras().getString("profileUrl","");

        ImageView imageView = findViewById(R.id.imgAvatar);
        Picasso.get().load(AvatarUrl).into(imageView);

        TextView textViewName = findViewById(R.id.Name);
        if(textViewName !=null)
            textViewName.setText(Nom);

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
