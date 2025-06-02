package fr.eseo.e3.poo.projet.blox.controleur;

import fr.eseo.e3.poo.projet.blox.vue.VuePuits;
import fr.eseo.e3.poo.projet.blox.modele.Puits;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gravite implements ActionListener {
    private static final int DEFAULT_PERIODICITE = 500; // en ms

    private final VuePuits vuePuits;
    private final Puits puits;
    private final Timer timer;

    public Gravite(VuePuits vuePuits) {
        this(vuePuits, DEFAULT_PERIODICITE);
    }

    public Gravite(VuePuits vuePuits, int periodicite) {
        this.vuePuits = vuePuits;
        this.puits = vuePuits.getPuits();
        this.timer = new Timer(periodicite, this);
        this.timer.start(); // démarre la gravité automatiquement
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        puits.gravite();
        vuePuits.repaint();
    }

    public int getPeriodicite() {
        return timer.getDelay();
    }

    public void setPeriodicite(int periodicite) {
        this.timer.setDelay(periodicite);
    }
}
