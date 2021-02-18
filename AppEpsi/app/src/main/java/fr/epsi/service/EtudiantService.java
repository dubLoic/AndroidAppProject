package fr.epsi.service;

import java.util.ArrayList;

import fr.epsi.entity.Etudiant;

public interface EtudiantService {
    Etudiant getEtudiant(String name);
    ArrayList<Etudiant> getEtudiants();
}
