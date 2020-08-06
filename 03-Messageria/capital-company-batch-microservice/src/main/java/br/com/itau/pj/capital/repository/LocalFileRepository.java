package br.com.itau.pj.capital.repository;

import br.com.itau.pj.capital.producer.Company;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;

@Repository
public class LocalFileRepository {
    @Autowired
    private ObjectMapper objectMapper;

    private static final String FILE_NAME = "D://Temp//cnpj-%s-at-%s.csv";

    public void saveFile(Company company) throws IOException {
        JsonNode accessLogTree = objectMapper.valueToTree(company);

        CsvMapper csvMapper = new CsvMapper();
        CsvSchema schema = csvMapper.schemaFor(Company.class).withUseHeader(true);

        String file = String.format(FILE_NAME, company.getCnpj(), LocalDate.now().toString());

        csvMapper.writer(schema).writeValue(Paths.get(file).toFile(), accessLogTree);

        System.out.println(" +++ File Saved: " + file);
    }
}