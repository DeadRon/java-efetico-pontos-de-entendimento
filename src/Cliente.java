public class Cliente {

    private String nome;
    private String sobrenome;

    public Cliente (String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public static Cliente getInstance(String nome, String sobrenome){
        return new Cliente(nome, sobrenome);
    }
}
