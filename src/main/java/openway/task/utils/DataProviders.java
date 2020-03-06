package openway.task.utils;


import org.testng.annotations.DataProvider;

import static openway.task.utils.DataGenerators.testDataList;

public class DataProviders {


    DataGenerators dataGenerators = new DataGenerators();

    @DataProvider(name = "fuzzDataProvider")
    public static Object[][] fuzzDataProvider() {
        Object[][] currentArray = new Object[testDataList.size()][3];

        for (int i = 0; i < currentArray.length; i++) {
            TestDataObject currentObj = testDataList.get(i);
            currentArray[i][0] = currentObj.getDescription();
            currentArray[i][1] = currentObj.getTestValue();
            currentArray[i][2] = currentObj.getExpectedValue();
        }

        return currentArray;
    }

    @DataProvider(name = "stringDataProvider")
    public Object[][] getData(){
        return new Object[][]{
                {dataGenerators.generateRandomString()},
                {"9 * 9"},
                {"2 / 3"}
        };
    }


}
