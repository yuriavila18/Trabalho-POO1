package Julho.Trabalho2507.modelo;

public class Cliente {
    private String id;
    private String nome;
    private String email;
    private boolean premium;

    public Cliente(String id, String nome, String email, boolean premium) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.premium = premium;
    }

    public String getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public boolean isPremium() {
        return premium;
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id + ", nome=" + nome + ", email=" + email + ", premium=" + premium + "]";
    }
}
