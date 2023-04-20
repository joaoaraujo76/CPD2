import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bem-vindo à aplicação de login e registro!");
        System.out.println("Digite 1 para fazer login, 2 para se registrar ou 0 para sair:");

        int opcao = scanner.nextInt();
        boolean loggedIn = false;

        while (opcao != 0) {
            if (opcao == 1) {
                System.out.print("Digite o username de usuário: ");
                String username = scanner.next();

                System.out.print("Digite a senha: ");
                String password = scanner.next();

                if (Login.verify(username, password)) {
                    System.out.println("Login bem-sucedido!");
                    loggedIn = true;
                    break;
                }
                else {
                    System.out.println("Username de usuário ou senha incorretos.");
                }
            }
            else if (opcao == 2) {
                System.out.print("Digite o nome de usuário: ");
                String name = scanner.next();

                System.out.print("Digite a senha: ");
                String password = scanner.next();

                Register.userRegister(name, password);
            }

            System.out.println("Digite 1 para fazer login, 2 para se registrar ou 0 para sair:");
            opcao = scanner.nextInt();
        }
        scanner.close();

        if (loggedIn){
            Game game = new Game();
            game.start(); // Exemplo de método para iniciar o jogo

        }
    }
}