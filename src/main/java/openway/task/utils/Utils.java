package openway.task.utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.qameta.allure.Attachment;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static openway.task.utils.DataGenerators.testDataList;

@Data
@Component
public class Utils {

    @Attachment(value = "Generated data", type = "xml/xslt")
    public static byte[] testDataSetToXmlAndAttach() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        File file = new File("test_dataset.xml");
        xmlMapper.writeValue(file, testDataList);

        return Files.readAllBytes(file.toPath());
    }

    public static void deleteTestDataSetToXml() throws IOException {
        Files.deleteIfExists(Paths.get("test_dataset.xml"));
    }
}
