package fr.epsi.service;

import java.util.ArrayList;

import fr.epsi.entity.Student;

public interface StudentService {
    Student getEtudiant(String name);
    ArrayList<Student> getEtudiants();
}
