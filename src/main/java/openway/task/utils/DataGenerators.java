package openway.task.utils;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.lang.invoke.MethodHandles;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
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

    public TestDataObject<String> stringCreator(){
        String value = generateRandomString();
        return new TestDataObject.TestDataObjectBuilder<String>()
                .description("Random string")
                .testValue(value)
                .expectedValue("NumberFormatException exception")
                .build();
    }

    public TestDataObject<Integer> integerCreator(){
        Integer value = generateRandomInteger();
        return new TestDataObject.TestDataObjectBuilder<Integer>()
                .description("Random Integer")
                .testValue(value)
                .expectedValue(1/value)
                .build();
    }

    public TestDataObject<Double> doubleCreator(){
        Double value = generateRandomDouble();
        return new TestDataObject.TestDataObjectBuilder<Double>()
                .description("Random string")
                .testValue(value)
                .expectedValue(1/value)
                .build();
    }


    public void fillUpCurrentTestDataContainer() {
        testDataList.addAll(Collections.nCopies(testDataSetSize, stringCreator()));
        testDataList.addAll(Collections.nCopies(testDataSetSize, integerCreator()));
        testDataList.addAll(Collections.nCopies(testDataSetSize, doubleCreator()));

        log.debug("Generating data in " + MethodHandles.lookup().lookupClass().getSimpleName());
    }
}
