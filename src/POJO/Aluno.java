package POJO;

public class Aluno {
    private int id;
    private String codigoMatricula;
    private String nome;
    private String telefone;
    private String serie;
    private float notaMatematica;
    private float notaPortugues;
    private float notaCiencias;
    private float notaHistoria;
    
    public Aluno() {
        
    }
    
    // Construtor
    public Aluno(String codigoMatricula, String nome, String telefone, String serie) {
        this.codigoMatricula = codigoMatricula;
        this.nome = nome;
        this.telefone = telefone;
        this.serie = serie;
    }

    // Getters e Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(String codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public void setNotaMatematica(float notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    public void setNotaPortugues(float notaPortugues) {
        this.notaPortugues = notaPortugues;
    }

    public void setNotaCiencias(float notaCiencias) {
        this.notaCiencias = notaCiencias;
    }

    public void setNotaHistoria(float notaHistoria) {
        this.notaHistoria = notaHistoria;
    }
    
    public float getNotaMatematica() {
        return notaMatematica;
    }

    public float getNotaPortugues() {
        return notaPortugues;
    }

    public float getNotaCiencias() {
        return notaCiencias;
    }

    public float getNotaHistoria() {
        return notaHistoria;
    }

    @Override
    public String toString() {
        return "Aluno{" + "id=" + id + ", codigoMatricula=" + codigoMatricula + ", nome=" + nome + ", telefone=" + telefone + ", serie=" + serie + ", notaMatematica=" + notaMatematica + ", notaPortugues=" + notaPortugues + ", notaCiencias=" + notaCiencias + ", notaHistoria=" + notaHistoria + '}';
    }
    
}
