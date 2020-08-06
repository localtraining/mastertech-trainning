package br.com.access.control.controlmicroservice.helper;

import br.com.access.control.controlmicroservice.config.ProjectConfig;
import br.com.access.control.controlmicroservice.producer.AccessLog;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class ObjectConverterHelper {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private ProjectConfig projectConfig;

    private DateTimeFormatter formatter;

    private static final String FILE_NAME = "%s/access_log-%s.csv";

    public ObjectConverterHelper() {
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");
    }

    public String toCsvLocalFile(AccessLog accessLog) throws IOException {
        JsonNode accessLogTree = objectMapper.valueToTree(accessLog);

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(AccessLog.class).withUseHeader(true);

        String file = String.format(FILE_NAME, projectConfig.getLocalFilesPath(), formatter.format(LocalDateTime.now()).toString());

        File fileToSave = Paths.get(file).toFile();

        csvMapper.writer(schema).writeValue(fileToSave, accessLogTree);

        return fileToSave.toString();
    }
}