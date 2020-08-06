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
import java.time.format.DateTimeFormatter;

@Repository
public class LocalFileRepository {
    @Autowired
    private ObjectMapper objectMapper;

    private static final String FILE_NAME = "D://Temp//access_log-%s.csv";

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");

    public void saveFile(AccessLog accessLog) throws IOException {
        JsonNode accessLogTree = objectMapper.valueToTree(accessLog);

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(AccessLog.class).withUseHeader(true);

        String file = String.format(FILE_NAME, formatter.format(LocalDateTime.now()).toString());

        csvMapper.writer(schema).writeValue(Paths.get(file).toFile(), accessLogTree);

        System.out.println(String.format("+++ Saved: %s", file));
    }
}