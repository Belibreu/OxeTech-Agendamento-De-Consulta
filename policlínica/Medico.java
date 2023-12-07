package policlínica;

public class Medico extends Pessoa{
    String crm;
    double salario;
    String especialidade;

    Medico(String nome, String cpf, String crm, double salario, String especialidade){
        super(nome, cpf);
        this.crm = crm;
        this.salario = salario;
        this.especialidade = especialidade;

    }
    
}
