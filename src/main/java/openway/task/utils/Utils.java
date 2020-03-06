package openway.task.utils;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import io.qameta.allure.Attachment;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.SecureRandom;
import java.util.Objects;

import static openway.task.utils.DataGenerators.testDataList;

@Data
@Component
public class Utils {

    @Attachment(value = "Generated data", type = "xml/xslt")
    public static byte[] testDataSetToXmlAndAttach() throws IOException {
        XmlMapper xmlMapper = new XmlMapper();
        xmlMapper.writeValue(new File("test_dataset.xml"), testDataList);

        File file = new File(Objects.requireNonNull(Utils.class.getClassLoader()
                .getResource("test_dataset.xml")).getFile());
        return Files.readAllBytes(file.toPath());
    }

    public static void deleteTestDataSetToXml() {
        File file = new File("simple_bean.xml");
        file.delete();
    }
}
