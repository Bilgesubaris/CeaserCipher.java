public class CaesarCipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Metni giriniz: ");
        String inputText = scanner.nextLine();

        System.out.print("Anahtarı giriniz: ");
        int key = scanner.nextInt();

        String encryptedText = encrypt(inputText, key);
        String decryptedText = decrypt(encryptedText, key);

        System.out.println("Şifrelenmiş Metin: " + encryptedText);
        System.out.println("Çözülmüş Metin: " + decryptedText);

        scanner.close();
    }

    public static String encrypt(String text, int key) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                encrypted.append((char) ((c - base + key) % 26 + base));
            } else {
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    public static String decrypt(String text, int key) {
        StringBuilder decrypted = new StringBuilder();

        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                decrypted.append((char) ((c - base - key + 26) % 26 + base));
            } else {
                decrypted.append(c); // Harf olmayan karakterler olduğu gibi eklenir
            }
        }

        return decrypted.toString();
    }
}
