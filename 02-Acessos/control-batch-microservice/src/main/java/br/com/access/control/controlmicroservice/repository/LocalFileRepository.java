package br.com.access.control.controlmicroservice.repository;

import br.com.access.control.controlmicroservice.producer.AccessLog;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;

@Repository
public class LocalFileRepository {
    @Autowired
    private ObjectMapper objectMapper;

    private static final String FILE_NAME = "D://Temp//access_log-%s.csv";

    public void saveFile(AccessLog accessLog) throws IOException {
        JsonNode accessLogTree = objectMapper.valueToTree(accessLog);

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(AccessLog.class).withUseHeader(true);

        String file = String.format(FILE_NAME, LocalDateTime.now().toString());

        csvMapper.writer(schema).writeValue(Paths.get(file).toFile(), accessLogTree);

        System.out.println(String.format("    +++ Saved: %s = %s - %s", file, LocalDateTime.now(), accessLog.toString()));
    }
}