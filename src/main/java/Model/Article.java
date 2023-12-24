package Model;

public class Article {
    private int id;
    private String name;
    private int quantite;
    private double prix;



    public Article(int id,String name,int quantite ,double prix){
        this.id=id;
        this.name=name;
        this.quantite=quantite;
        this.prix=prix;
    }
    public Article(String name,int quantite ,double prix){
       // this.id=id;
        this.name=name;
        this.quantite=quantite;
        this.prix=prix;
    }
    public Article() {
        // Default constructor with no parameters
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantite=" + quantite +
                ", prix=" + prix +
                '}';
    }
}


