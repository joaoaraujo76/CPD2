import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Login {
    public static boolean verify(String username, String password) {
        try {
            FileReader fileReader = new FileReader("users.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String linha;
            while ((linha = bufferedReader.readLine()) != null) {
                String[] partes = linha.split(",");
                String name = partes[0];
                String key = partes[1];

                // Verificar se o nome de usuário corresponde a alguma entrada no arquivo
                if (name.equals(username)) {
                    String hashedPassword;
                    try {
                        hashedPassword = hashPassword(password);
                    } catch (NoSuchAlgorithmException e) {
                        System.out.println("Erro ao verificar senha: " + e.getMessage());
                        return false;
                    }

                    // Comparar os hashes de senha
                    if (key.equals(hashedPassword)) {
                        bufferedReader.close();
                        return true;
                    } else {
                        bufferedReader.close();
                        return false;
                    }
                }
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Erro ao fazer login: " + e.getMessage());
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