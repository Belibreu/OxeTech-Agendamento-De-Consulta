package policlínica;

public class Consulta{
    Paciente paciente;
    Medico medico;

    Consulta(Paciente paciente, Medico medico){
        super(paciente.getNome(), paciente.getCpf());
        this.paciente = paciente;
        this.medico = medico;
    }
    
}
