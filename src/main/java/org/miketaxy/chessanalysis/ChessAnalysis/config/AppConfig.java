package org.miketaxy.chessanalysis.ChessAnalysis.config;

import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.net.http.HttpRequest;

@AutoConfiguration
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "org.miketaxy.chessanalysis.*")
public class AppConfig {
}
