package br.com.briansiervi.spring_batch_08_desafio_leitores.util;

import java.text.NumberFormat;
import java.util.Locale;

public class Util {
  public static String imprimeReal(double valor) {
    Locale locale = new Locale("pt", "BR");
    NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);
    return numberFormat.format(valor).toString();
  }
}
