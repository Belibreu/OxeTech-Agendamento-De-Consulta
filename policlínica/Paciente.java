package policlínica;

public class Paciente extends Pessoa{
    private String cartaoSUS;
    private String especialidade;

    public Paciente(String nome, String cpf, String cartaoSus, String especialidade) {
        super(nome, cpf);
        this.cartaoSUS = cartaoSUS;
        this.especialidade = especialidade;
    }
}
