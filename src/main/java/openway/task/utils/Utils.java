package openway.task.utils;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Data
@Component
public class Utils {


    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
    private static final SecureRandom RANDOM = new SecureRandom();


    public String generateRandomString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 10; ++i) {
            sb.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return sb.toString();
    }

    public Integer generateRandomInteger() {
        return RANDOM.nextInt();
    }

    public Double generateRandomDouble() {
        return RANDOM.nextDouble();
    }



}
