package openway.task.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;

import java.lang.invoke.MethodHandles;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;

@Data
@Slf4j
public class DataGenerators {

    public static List<TestDataObject> testDataList = new ArrayList<>();

    private static final String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
    private static final SecureRandom RANDOM = new SecureRandom();

    int testDataSetSize = 10;

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

    public TestDataObject<String, ConversionFailedException> stringCreator() {
        String value = generateRandomString();

        return new TestDataObject.TestDataObjectBuilder<String, ConversionFailedException>()
                .description("Random string")
                .testValue(value)
                .expectedValue(new ConversionFailedException(TypeDescriptor.valueOf(String.class),
                        TypeDescriptor.valueOf(double.class), value, new NumberFormatException("For input string: \"" + value + "\"")))
                .build();

    }

    public TestDataObject<Integer, Double> integerCreator() {
        Integer value = generateRandomInteger();
        return new TestDataObject.TestDataObjectBuilder<Integer, Double>()
                .description("Random Integer")
                .testValue(value)
                .expectedValue(1 / (double) value)
                .build();
    }

    public TestDataObject<Double, Double> doubleCreator() {
        Double value = generateRandomDouble();
        return new TestDataObject.TestDataObjectBuilder<Double, Double>()
                .description("Random double")
                .testValue(value)
                .expectedValue(1 / value)
                .build();
    }

    public void fillUpCurrentTestDataContainer() {

        for (int i = 0; i < testDataSetSize; i++) {

            testDataList.add(integerCreator());
            testDataList.add(doubleCreator());
        }

        log.debug("Generating data in " + MethodHandles.lookup().lookupClass().getSimpleName());
    }
}
