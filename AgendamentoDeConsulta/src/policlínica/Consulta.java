package policlínica;

public class Consulta {
    private Paciente paciente;
    private Medico medico;

    public Consulta(Paciente paciente, Medico medico) {
        this.paciente = paciente;
        this.medico = medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Medico getMedico() {
        return medico;
    }
}