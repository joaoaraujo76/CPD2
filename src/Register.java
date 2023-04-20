import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Register {

    public static void userRegister(String username, String password) {
        try {
            FileWriter fileWriter = new FileWriter("users.txt", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            // Verificar se o usuário já existe no arquivo
            if (verifyUser(username)) {
                System.out.println("Erro: Já existe um usuário com esse nome de usuário.");
            } else {
                // Registrar o usuário no arquivo
                String hashedPassword = hashPassword(password);
                printWriter.println(username + "," + hashedPassword);
                System.out.println("Usuário registrado com sucesso!");
            }

            printWriter.close();
        } catch (IOException | NoSuchAlgorithmException e) {
            System.out.println("Erro ao registrar usuário: " + e.getMessage());
        }
    }
    public static boolean verifyUser(String username) {
        try {
            FileReader fileReader = new FileReader("users.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] partes = linha.split(",");
                String nomeUsuario = partes[0];

                // Verificar se o username de usuário já existe no arquivo
                if (nomeUsuario.equals(username)) {
                    bufferedReader.close();
                    return true;
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Erro ao verificar existência de usuário: " + e.getMessage());
        }
        return false;
    }

    public static String hashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : hashedBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}