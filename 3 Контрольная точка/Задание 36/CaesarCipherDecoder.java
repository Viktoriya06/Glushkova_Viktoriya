import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class CaesarCipherDecoder {
    public static void main(String[] args) {
        String url = "https://fish-text.ru/get?format=plain&number=10000";
        String text = fetchText(url);


        String encryptedText = "Khoor Zruog";
        int shift = 3;

        String decryptedText = decryptCaesarCipher(encryptedText, shift);
        System.out.println("Расшифрованный текст: " + decryptedText);
    }

    private static String fetchText(String urlString) {
        StringBuilder result = new StringBuilder();
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result.append(line).append("\n");
            }
            rd.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    private static String decryptCaesarCipher(String text, int shift) {
        StringBuilder decrypted = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';

                character = (char) ((character - base - shift + 26) % 26 + base);
            }
            decrypted.append(character);
        }
        return decrypted.toString();
    }
}
