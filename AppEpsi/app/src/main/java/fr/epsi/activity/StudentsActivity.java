package fr.epsi.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import fr.epsi.R;
import fr.epsi.activity.HomeActivity;
import fr.epsi.activity.MainActivity;

public class StudentsActivity extends MainActivity {

    public static void displayActivity(MainActivity activity){
        Intent intent = new Intent(activity, fr.epsi.activity.StudentsActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_list);
        setTitle("Infos");
    }
}
