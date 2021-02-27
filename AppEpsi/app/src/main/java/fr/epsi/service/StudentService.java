package fr.epsi.service;

import java.util.ArrayList;

import fr.epsi.entity.Student;

public interface EtudiantService {
    Student getEtudiant(String name);
    ArrayList<Student> getEtudiants();
}
