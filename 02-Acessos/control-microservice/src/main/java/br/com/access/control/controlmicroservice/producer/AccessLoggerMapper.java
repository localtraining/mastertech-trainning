package br.com.access.control.controlmicroservice.producer;

import br.com.access.control.controlmicroservice.model.Control;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class AccessLoggerMapper {
    public AccessLog fromControl(Control control) {
        AccessLog accessLog = new AccessLog();

        accessLog.setAccessTime(LocalDateTime.now());
        accessLog.setCustomerId(control.getCustomerId());
        accessLog.setDoorId(control.getDoorId());

        return accessLog;
    }
}
