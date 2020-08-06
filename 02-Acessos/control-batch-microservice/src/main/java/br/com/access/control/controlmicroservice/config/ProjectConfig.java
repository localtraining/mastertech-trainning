package br.com.access.control.controlmicroservice.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("project")
public class ProjectConfig {
    private String localFilesPath;

    public String getLocalFilesPath() {
        return localFilesPath;
    }

    public void setLocalFilesPath(String localFilesPath) {
        this.localFilesPath = localFilesPath;
    }
}