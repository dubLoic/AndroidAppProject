package fr.epsi.service;

import java.util.ArrayList;

import fr.epsi.entity.Rayon;

public interface RayonService {
    Rayon getRayon(String path, String id);
    ArrayList<Rayon> getRayons(String path);
}
