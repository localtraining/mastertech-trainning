package br.com.access.control.controlmicroservice.repository;

import br.com.access.control.controlmicroservice.helper.ObjectConverterHelper;
import br.com.access.control.controlmicroservice.producer.AccessLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

@Repository
public class LocalFileRepository {
    @Autowired
    private ObjectConverterHelper objectConverterHelper;

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH.mm.ss");

    public void saveFile(AccessLog accessLog) throws IOException {
        String file = objectConverterHelper.toCsvLocalFile(accessLog);

        System.out.println(String.format("+++ Saved: %s", file));
    }
}