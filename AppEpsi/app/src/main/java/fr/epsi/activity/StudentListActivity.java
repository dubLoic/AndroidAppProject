package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONException;

import java.util.ArrayList;

import fr.epsi.R;
import fr.epsi.entity.Etudiant;
import fr.epsi.service.EtudiantService;
import fr.epsi.service.EtudiantServiceImplementation;

public class EtudiantListActivity extends MainActivity implements View.OnClickListener{
    EtudiantService es = new EtudiantServiceImplementation();

    ArrayList<Etudiant> etudiants;
    RecyclerView recyclerView;

    public static void displayActivity(MainActivity activity){
        Intent intent = new Intent(activity, EtudiantListActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant_list);
        /*findViewById(R.id.Student1).setOnClickListener(this);
        findViewById(R.id.Student2).setOnClickListener(this);*/
        setTitle("Infos");
        showBack();

        etudiants = es.getEtudiants();

        if(etudiants.size() > 0){
            etudiantAdapter = new EtudiantAdapter(this, etudiants);
        }
    }

    String avatar1 = "https://cdn4.iconfinder.com/data/icons/basic-ui-pack-flat-s94-1/64/Basic_UI_Icon_Pack_-_Flat_user-512.png";
    String avatar2 = "https://png.pngtree.com/png-vector/20190223/ourmid/pngtree-vector-avatar-icon-png-image_695765.jpg";

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.Student1:
                EtudiantInfoActivity.displayActivity(this, avatar1, "Donatello", "Matéo", "matéo.donatello@epsi.fr", "Dev2", "http://www.epsi.fr/");
                break;
            case R.id.Student2:
                EtudiantInfoActivity.displayActivity(this, avatar2, "Legland", "Marin", "marin.legland@epsi.fr", "Dev2", "http://www.epsi.fr/");
                break;
        }
    }
}
