package openway.task.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataGenerator {

    @Autowired
    Utils utils;

    static List<TestDataObject> testDataList = new ArrayList<>();

    public TestDataObject<String> stringCreater(){
        String value = utils.generateRandomString();
        return new TestDataObject.TestDataObjectBuilder<String>()
                .description("Random string")
                .testValue(utils.generateRandomString())
                .expectedValue("NumberFormatException exception")
                .build();
    }

    public TestDataObject<Integer> integerCreater(){
        Integer value = utils.generateRandomInteger();
        return new TestDataObject.TestDataObjectBuilder<Integer>()
                .description("Random Integer")
                .testValue(value)
                .expectedValue(1/value)
                .build();
    }

    public TestDataObject<Double> doubleCreater(){
        Double value = utils.generateRandomDouble();
        return new TestDataObject.TestDataObjectBuilder<Double>()
                .description("Random string")
                .testValue(value)
                .expectedValue(1/value)
                .build();
    }




}
