package com.alura.conversordemonedas.Util;

import com.alura.conversordemonedas.Api.ApiConversor;
import com.alura.conversordemonedas.Modelos.DivisasDto;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class UtilConversor {



    public static Object obtenerValoresDeLasDivisas() throws IOException {
        ApiConversor apiConversor = new ApiConversor();
        Object valorDeLasDivisas =  apiConversor.convertirAJson();

        return valorDeLasDivisas;

    }

    public static Map<String, Double> convertirTipoMap(Object valorDeLasDivisas){
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, Double>>() {}.getType();
        Map<String, Double> divisas = gson.fromJson(valorDeLasDivisas.toString(), type);
        return divisas;
    }

    public static void realizarConversion(Map<String, Double> divisas, String pais, Double valor, String tipoDeConversion){
        DivisasDto divisasDto = new DivisasDto(divisas);
        System.out.println(divisasDto);
        Optional<Map.Entry<String,Double>>existePais = divisasDto.valorDivisa().entrySet()
               .stream()
               .filter(paises-> paises.getKey().equals(pais))
               .findFirst();

       if(existePais.isPresent()){

           if(tipoDeConversion.equals("1")){
               Double resultado =  existePais.get().getValue() * valor;
               DecimalFormat decimalFormat = new DecimalFormat("#.00");
               String resultadoFormateado = decimalFormat.format(resultado);

               System.out.println("El valor en " +existePais.get().getKey()+":"+resultadoFormateado);
           }else{
               System.out.println("El valor en USD es: $"+ String.format("%.0f",valor/existePais.get().getValue()));
           }


       }else{
           System.out.println("La abreviatura de la moneda no existe "+ existePais.get().getKey());
       }

    }


    public static void menu(){

        System.out.println("*************MENU******************");
        System.out.println("***********************************");
        System.out.println("Sea bienvenido al conversor de Moneda");
        System.out.println("1) Dólar =>> Peso Argentino");
        System.out.println("2) Peso Argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real Brasileño");
        System.out.println("4) Real Brasileño =>> Dólar");
        System.out.println("5) Dólar =>> Peso Méxicano");
        System.out.println("6) Peso Méxicano =>> Dólar");
        System.out.println("7) Salir");
        System.out.println("Elija una opción valida:");
        System.out.println("***********************************");




    }




}
