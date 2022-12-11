package com.example.sprinttrainingweb.repository;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.net.URLEncoder;

/*
      @Configuration : permet de déclarer la classe en tant que bean de configuration.
      @ConfigurationProperties(prefix = “com.openclassrooms.webapp”) : demande à Spring de charger les properties qui commencent par “com.openclassrooms.webapp” au sein des attributs de la classe.
      @Data : génère automatiquement getter/setter pour les attributs de classe.
*/
@Configuration
@ConfigurationProperties(prefix = "com.example.sprinttrainingweb")
@Data
public class CustomProperties {

    //private String apiUrl;
    private String apiUrl="http://localhost:9000";              //="localhost:9000";  //TODO: Fix not autoload from application.properties

    public String getApiUrl() {
        return apiUrl;
    }
}
