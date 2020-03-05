package openway.task.utils;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class TestDataObject <T>{

    String description;

    T testValue;

    T expectedValue;

}