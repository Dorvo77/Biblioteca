package entidades;

public class Libro {
    private String titulo;
    private String autor;
    private Integer nroEjemplares;
    private Integer cantPrestada;

    public Libro() {
    }

    public Libro(String titulo, String autor, Integer nroEjemplares) {
        this.titulo = titulo;
        this.autor = autor;
        this.nroEjemplares = nroEjemplares;
        this.cantPrestada = 0;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getNroEjemplares() {
        return nroEjemplares;
    }

    public void setNroEjemplares(Integer nroEjemplares) {
        this.nroEjemplares = nroEjemplares;
    }

    public Integer getCantPrestada() {
        return cantPrestada;
    }

    public void setCantPrestada(Integer cantPrestada) {
        this.cantPrestada = cantPrestada;
    }
    public  void prestaLibro(){
        cantPrestada +=1;
        nroEjemplares -=1;
    }
    public boolean devuelveLibro(){

        if(!(cantPrestada==0)){
            cantPrestada -=1;
            nroEjemplares +=1;
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", nroEjemplares=" + nroEjemplares +
                ", cantPrestada=" + cantPrestada +
                '}';
    }
}
