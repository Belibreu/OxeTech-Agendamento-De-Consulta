package policlínica;

public class Pessoa {
    String nome;
    String cpf;

    Pessoa(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }
    
    public String getNome() {
        return this.nome;
    }
}
