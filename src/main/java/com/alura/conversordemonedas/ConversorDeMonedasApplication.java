package com.alura.conversordemonedas;


import com.alura.conversordemonedas.Api.ApiConversor;
import com.alura.conversordemonedas.Modelos.DivisasDto;
import com.alura.conversordemonedas.Util.UtilConversor;
import com.google.gson.Gson;
import jdk.jshell.execution.Util;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.Map;
import java.util.Scanner;


@SpringBootApplication
public class ConversorDeMonedasApplication {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(ConversorDeMonedasApplication.class, args);
        Object valorDeLasDivisas = UtilConversor.obtenerValoresDeLasDivisas();
        Map<String, Double> divisas = UtilConversor.convertirTipoMap(valorDeLasDivisas);
        String eleccion = "0";
        double valor=0;


        while(!eleccion.equals("7")){
            Scanner scanner = new Scanner(System.in);

            UtilConversor.menu();
            eleccion = scanner.nextLine();

            if(!eleccion.equals("7")){
                System.out.println("***************************************************");
                System.out.println("Ingrese el valor que quiere convertir");
                valor = scanner.nextDouble();
            }


            switch (eleccion){
                case "1":
                    UtilConversor.realizarConversion(divisas, "ARS",valor,"1");
                    break;
                case "2":
                    UtilConversor.realizarConversion(divisas, "ARS",valor,"2");
                    break;
                case "3":
                    UtilConversor.realizarConversion(divisas, "BRL",valor,"1");
                    break;
                case "4":
                    UtilConversor.realizarConversion(divisas, "BRL",valor,"2");
                    break;
                case "5":
                    UtilConversor.realizarConversion(divisas, "MXN",valor,"1");
                    break;
                case "6":
                    UtilConversor.realizarConversion(divisas, "MXN",valor,"2");
                    break;
                case "7":
                    eleccion ="7";
                    break;

            }


        }


        System.out.println("HA SALIDO CORRECTAMENTE");

    }

}
