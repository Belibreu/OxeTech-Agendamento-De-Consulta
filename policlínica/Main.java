package policlínica;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Paciente> pacientes = new ArrayList<>();
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Consulta> consultas = new ArrayList<>();

        while(true){
            System.out.println("1 ♠ Cadastrar Paciente");
            System.out.println("2 ♦ Cadastrar Médico");
            System.out.println("3 ♣ Agendar Consulta");
            System.out.println("4 ♥ Sair");
            System.out.println("•Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarPaciente(scanner, pacientes);
                    break;
            
                case 2:
                    cadastrarMedico(scanner, medicos);
                    break;
                case 3:
                    cadastrarConsultas(scanner, consultas);
                    break;
                case 4:
                    System.out.println("Saindo do programa, valeu flw");//corrigir dps
                    System.exit(0);
                default:
                    System.out.println("Opção inexistente - Tente novamente!");
            }
        }
    }
    
}
