public class CaesarCipher {
    public static String encrypt(String text, int shift, boolean direction) {
        StringBuilder result = new StringBuilder();
        shift = direction ? shift : -shift;
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';

                character = (char) ((character - base + shift + 26) % 26 + base);
            }
            result.append(character);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        String text = "Hello, World!";
        int shift = 3;
        boolean direction = true;
        String encryptedText = encrypt(text, shift, direction);
        System.out.println("Encrypted: " + encryptedText);
    }
}
