package openway.task.utils;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TestDataObject<T, R> {

    String description;

    T testValue;

    R expectedValue;

}