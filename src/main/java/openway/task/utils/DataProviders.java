package openway.task.utils;


import org.testng.annotations.DataProvider;

import static openway.task.utils.DataGenerator.testDataList;

public class DataProviders {

    @DataProvider(name = "mainDataProvider")
    public Object[][] getData() {
        Object[][] currentArray = new Object[testDataList.size()][3];


        for (int i = 0; i < currentArray.length; i++) {
            TestDataObject currentObj = testDataList.get(i);
            currentArray[i][0] = currentObj.getDescription();
            currentArray[i][1] = currentObj.getTestValue();
            currentArray[i][2] = currentObj.getExpectedValue();
        }

        return currentArray;
    }


}
