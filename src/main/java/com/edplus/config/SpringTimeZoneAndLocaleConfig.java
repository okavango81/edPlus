package com.edplus.config;

import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

import java.util.Locale;
import java.util.TimeZone;

@Configuration
public class SpringTimeZoneAndLocaleConfig {

    @PostConstruct
    public void timeZoneConfig(){
        TimeZone.setDefault(TimeZone.getTimeZone("America/Sao_Paulo"));
    }

    @PostConstruct
    public void localeConfig(){
        Locale.setDefault(Locale.forLanguageTag("pt-BR"));
    }
}
