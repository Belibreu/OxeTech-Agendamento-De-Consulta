package policlínica;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();

        while (true) {
            System.out.println("1 * Cadastrar Paciente");
            System.out.println("2 * Cadastrar Médico");
            System.out.println("3 * Agendar Consulta");
            System.out.println("4 * Listar Agendamentos");
            System.out.println("5 * Cancelar Consulta");
            System.out.println("6 * 4 * Sair");
            System.out.print(" Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarPaciente(scanner, pacientes);
                    break;
                case 2:
                    cadastrarMedico(scanner, medicos);
                    break;
                case 3:
                    cadastrarConsulta(scanner, pacientes, medicos, consultas);
                    break;
                case 4:
                    listarAgendamentos(consultas);
                    break;
                case 5:
                    cancelarConsulta(scanner, consultas);
                    break;
                case 6:
                    System.out.println("Saindo do programa, valeu flw");
                    System.exit(0);
                default:
                    System.out.println("Opção inexistente - Tente novamente!");
            }
        }
    }

    // PACIENTE
    private static void cadastrarPaciente(Scanner scanner, ArrayList<Paciente> pacientes) {
        System.out.println("Cadastro de Paciente: ");
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("CPF: ");
        String cpf = scanner.next();
        System.out.print("Cartão SUS: ");
        String cartaoSUS = scanner.next();
        System.out.print("Especialidade: ");
        String especialidade = scanner.next();

        Paciente paciente = new Paciente(nome, cpf, cartaoSUS, especialidade);
        pacientes.add(paciente);

        System.out.println("Paciente cadastrado");
    }

    // MEDICO
    private static void cadastrarMedico(Scanner scanner, ArrayList<Medico> medicos) {
        System.out.println("Cadastro de Médico:");
        System.out.print("Nome: ");
        String nome = scanner.next();
        System.out.print("CPF: ");
        String cpf = scanner.next();
        System.out.print("CRM: ");
        String crm = scanner.next();
        System.out.print("Salário: ");
        double salario = scanner.nextDouble();
        System.out.print("Especialidade: ");
        String especialidade = scanner.next();

        Medico medico = new Medico(nome, cpf, crm, salario, especialidade);
        medicos.add(medico);

        System.out.println("Médico cadastrado com sucesso!");
    }

    // CONSULTA
    private static void cadastrarConsulta(Scanner scanner, ArrayList<Paciente> pacientes, ArrayList<Medico> medicos, ArrayList<Consulta> consultas) {
        System.out.println("---Agendamento de Consulta:---");

        // paciente disponível
        System.out.println("---Pacientes disponíveis: ---");
        for (int i = 0; i < pacientes.size(); i++) {
            System.out.println((i + 1) + ". " + pacientes.get(i).getNome());
        }
        System.out.println("---Escolha o código do paciente: ---");
        int pacienteIndex = scanner.nextInt() - 1;
        Paciente pacienteSelecionado = pacientes.get(pacienteIndex);

        // médico com a mesma especialidade
        System.out.println("---Médicos com a mesma especialidade: ---");
        for (Medico medico : medicos) {
         if (medico.getEspecialidade().equalsIgnoreCase(pacienteSelecionado.getEspecialidade())) {
            System.out.println(medico.getNome());
            }
        }
        System.out.println("---Escolha o Médico: ---");
        String nomeMedico = scanner.next();
        Medico medicoSelecionado = null;
            for (Medico medico : medicos) {
                if (medico.getNome().equalsIgnoreCase(nomeMedico)) {
         medicoSelecionado = medico;
            break;
            }
        }
        if (medicoSelecionado != null && medicoSelecionado.getEspecialidade().equalsIgnoreCase(pacienteSelecionado.getEspecialidade())) {
            Consulta consulta = new Consulta(pacienteSelecionado, medicoSelecionado);
            consultas.add(consulta);
            System.out.println("Consulta agendada");
        } 
        else {
             System.out.println("Médico não compatível com paciente");
        }
    }
        //cancelar consulta
    private static void cancelarConsulta(Scanner scanner, ArrayList<Consulta> consultas) {
        System.out.println("---Cancelar consulta: ---");

        // consultas agendadas
    System.out.println("---Código - Consultas agendadas: ---");
        for (int i = 0; i < consultas.size(); i++) {
            Consulta consulta = consultas.get(i);
            String pacienteNome = "---Paciente não encontrado---";
            String medicoNome = "---Médico não encontrado---";

        if (consulta.getPaciente() != null) {
         pacienteNome = consulta.getPaciente().getNome();
        }

        if (consulta.getMedico() != null) {
        medicoNome = consulta.getMedico().getNome();
        }

       System.out.println((i + 1) + ". " + pacienteNome + " - " + medicoNome);
        }
        System.out.println("---Escolha a consulta para cancelar: ---");
        int consultaIndex = scanner.nextInt() - 1;

        if (consultaIndex >= 0 && consultaIndex < consultas.size()) {
        consultas.remove(consultaIndex);
        System.out.println("---Consulta cancelada---");
        } 
        else {
        System.out.println("---Código inválido---");
        }
    }
    //listar consultas
    private static void listarAgendamentos(ArrayList<Consulta> consultas) {
        System.out.println("---Agendamentos:---");
    
        if (consultas.isEmpty()) {
            System.out.println("---Sem agendamentos---");
        } else {
            for (Consulta consulta : consultas) {
                String pacienteNome = (consulta.getPaciente() != null) ? consulta.getPaciente().getNome() : "---Paciente não encontrado---";
                String medicoNome = (consulta.getMedico() != null) ? consulta.getMedico().getNome() : "---Médico não encontrado---";
    
                System.out.println("Paciente: " + pacienteNome + " - Médico: " + medicoNome);
            }
        }
    }
}
