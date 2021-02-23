package edu.sanvalero.manuel.aulaabierta23feb;

public class Texto {
    private int maxLength;
    private String payload = "";

    public Texto(int maxLength) {
        this.maxLength = maxLength;
    }

    public Texto setText(String newPayload) {
        payload = newPayload;
        return this;
    }

    public Texto addChar(char newChar) {
        if (payload.length() < maxLength) {
            payload = payload.concat(String.valueOf(newChar));
        }
        return this;
    }

    public Texto addTextAtBegin(String newText) {
        if (payload.length() + newText.length() <= maxLength) {
            payload = payload.concat(newText);
        }
        return this;
    }

    public Texto addTextAtEnd(String newText) {
        if (payload.length() + newText.length() <= maxLength) {
            payload = newText.concat(payload);
        }
        return this;
    }

    public int numVocals() {
        int result = 0;
        for (int i = 0; i < payload.length(); i++) {
            if (isVocal(payload.substring(i, i + 1))) {
                result++;
            }
        }
        return result;
    }

    private boolean isVocal(String character) {
        String vocals = "AEIOU";
        return vocals.indexOf(character.toUpperCase()) != -1;
    }

    @Override
    public String toString() {
        return payload;
    }

    public static void main(String[] args) {
        Texto tests = new Texto(10);
        System.out.println(tests.setText("Hola"));
        System.out.println(tests.addChar('!'));
        System.out.println(tests.addTextAtBegin("x"));
        System.out.println(tests.addTextAtEnd("xa"));
        System.out.println(tests.numVocals());
    }
}
