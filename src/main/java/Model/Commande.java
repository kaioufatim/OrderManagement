package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Commande {
    private int id;
    private String etat;
    private Client client;
    private LocalDate date;
    private List<LigneCommande> lignes;




//    public Commande () {
//        date = LocalDate.now();
//    }
//
//    public Commande(int id,String etat,  Client client, LocalDate date) {
//        this.id = id;
//        this.etat=etat;
//        this.client = client;
//        this.date = date;
//        this.lignes = new ArrayList<>();
//    }
    public Commande(int id, String etat, Client client, LocalDate date) {
        this.id = id;
        this.etat = etat;
        this.client = client != null ? client : new Client(); // Initialize with an empty Client object if null
        this.date = date;
        this.lignes = new ArrayList<>();
    }



    public Commande(String etat, Client client, LocalDate date) {

    }

    public void addLigneDeCommande(LigneCommande ligneDeCommande) {
        lignes.add(ligneDeCommande);
    }

    public List<LigneCommande> getLignesDeCommande() {
        return lignes;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }



    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }


}
