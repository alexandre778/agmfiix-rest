package com.agmfiix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@SpringBootApplication
public class AgmfiixRestApplication {

    public static void main(String[] args) {
        criarBancoSeNaoExistir();
        SpringApplication.run(AgmfiixRestApplication.class, args);
    }

    private static void criarBancoSeNaoExistir() {
        String url = "jdbc:mysql://localhost:3306/?useSSL=false&serverTimezone=UTC";
        String user = "root";
        String password = "81225573";
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS agmfiix");
            System.out.println("Banco 'agmfiix' verificado/criado com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
