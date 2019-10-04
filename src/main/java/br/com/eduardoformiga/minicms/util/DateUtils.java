package br.com.eduardoformiga.minicms.util;

import java.time.LocalDate;
import java.time.Period;

public class DateUtils {

    public static int calculaIdade(LocalDate birthDate, LocalDate currentDate) {
        return (birthDate != null && currentDate != null)
                ? Period.between(birthDate, currentDate).getYears()
                : null;
    }
}
