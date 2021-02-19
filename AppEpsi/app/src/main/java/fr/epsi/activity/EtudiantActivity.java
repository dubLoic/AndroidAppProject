package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;

import fr.epsi.R;

public class EtudiantActivity extends MainActivity {

    public static void displayActivity(MainActivity activity){
        Intent intent = new Intent(activity, EtudiantActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant_list);
        setTitle("Infos");
        showBack();
    }
}
