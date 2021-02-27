package fr.epsi.activity;

import android.content.Intent;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import fr.epsi.R;
import fr.epsi.entity.Student;
import fr.epsi.service.StudentService;
import fr.epsi.service.StudentServiceImplementation;

public class StudentListActivity extends MainActivity{
    StudentService es = new StudentServiceImplementation();

    ArrayList<Student> students;
    StudentAdapter studentAdapter;
    RecyclerView recyclerView;

    public static void displayActivity(MainActivity activity){
        Intent intent = new Intent(activity, StudentListActivity.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_etudiant_list);
        setTitle("Infos");
        showBack();
        recyclerView=findViewById(R.id.recyclerView);

        students = es.getEtudiants();
        if(students.size() > 0){
            studentAdapter = new StudentAdapter(this, students);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(studentAdapter);
        }
    }
}
