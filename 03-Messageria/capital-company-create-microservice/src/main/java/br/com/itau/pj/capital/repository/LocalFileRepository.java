package br.com.itau.pj.capital.repository;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.apache.catalina.AccessLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Paths;

@Repository
public class LocalFileRepository {
    @Autowired
    private ObjectMapper objectMapper;

    private static final String FILE_NAME = "D://Temp//accessLog.csv";

    public void saveFile(AccessLog accessLog) throws IOException {
        JsonNode accessLogTree = objectMapper.valueToTree(accessLog);

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(AccessLog.class).withUseHeader(true);

        csvMapper.writer(schema).writeValue(Paths.get(FILE_NAME).toFile(), accessLogTree);
    }
}