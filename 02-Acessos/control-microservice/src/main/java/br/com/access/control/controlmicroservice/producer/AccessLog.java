package br.com.access.control.controlmicroservice.producer;

import java.time.LocalDateTime;

public class AccessLog {
    private LocalDateTime accessTime;
    private Long customerId;
    private Long doorId;

    public LocalDateTime getAccessTime() {
        return accessTime;
    }

    public void setAccessTime(LocalDateTime accessTime) {
        this.accessTime = accessTime;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getDoorId() {
        return doorId;
    }

    public void setDoorId(Long doorId) {
        this.doorId = doorId;
    }

    @Override
    public String toString() {
        return "AccessLog {" +
                "accessTime=" + accessTime +
                ", customerId=" + customerId +
                ", doorId=" + doorId +
                '}';
    }
}