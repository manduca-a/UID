package lab;

import java.util.Objects;

public class Prodotto {
    private String id;
    private String tipo;
    private String marca;
    private String modello;
    private int anno_prod;
    private double prezzo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return Objects.equals(id, prodotto.id);
    }

    public Prodotto(String i, String tip, String marc, String modell, int anno, double pre){
        id=i;
        tipo=tip;
        marca=marc;
        modello=modell;
        anno_prod=anno;
        prezzo=pre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public int getAnno_prod() {
        return anno_prod;
    }

    public void setAnno_prod(int anno_prod) {
        this.anno_prod = anno_prod;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    public String toString() {
        return "ID = " + id + " tipo: " + tipo + " marca: " + marca + " modello: " + modello + " Anno di Produzione : " + anno_prod + " prezzo€ = " + prezzo;
    }
}

