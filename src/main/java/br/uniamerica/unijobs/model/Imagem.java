package br.uniamerica.unijobs.model;

public class Imagem {
    private Integer id;
    private String url;
    private Anuncio anuncio;

    public  Imagem(){

    }

    public Imagem(Integer id, String url, Anuncio anuncio) {
        this.id = id;
        this.url = url;
        this.anuncio = anuncio;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Imagem{" +
                "id=" + id +
                ", url='" + url + '\'' +
                '}';
    }
}
