import java.util.Random;
import java.util.Scanner;

public class Game {
    private int numQuestions;
    private int numCorrectAnswers;
    private Random random;

    public Game() {
        numQuestions = 10; // Número de perguntas
        numCorrectAnswers = 0; // Número de respostas corretas
        random = new Random();
    }

    public void start() {
        System.out.println("Iniciando o jogo...");

        Scanner scanner = new Scanner(System.in); // Criar nova instância de Scanner

        for (int i = 1; i <= numQuestions; i++) {
            System.out.println("Pergunta " + i + ":");
            int num1 = random.nextInt(10) + 1; // Número aleatório de 1 a 10
            int num2 = random.nextInt(10) + 1; // Número aleatório de 1 a 10

            System.out.print(num1 + " + " + num2 + " = ? ");
            while (!scanner.hasNextInt()) {
                System.out.println("cona");
                scanner.next(); // Limpar entrada inválida
                System.out.println("Por favor, digite um número inteiro.");
            }
            int answer = scanner.nextInt(); // Ler a resposta do jogador

            int correctAnswer = num1 + num2; // Calcular a resposta correta

            if (answer == correctAnswer) {
                System.out.println("Resposta correta!");
                numCorrectAnswers++;
            } else {
                System.out.println("Resposta incorreta. A resposta correta era: " + correctAnswer);
            }

            try {
                Thread.sleep(10000); // Esperar 10 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        scanner.close(); // Fechar o Scanner após o jogo

        System.out.println("Fim do jogo.");
        System.out.println("Número de respostas corretas: " + numCorrectAnswers + " de " + numQuestions);
    }
}
