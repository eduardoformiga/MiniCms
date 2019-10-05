package br.com.eduardoformiga.minicms.util;

import java.time.LocalDate;
import java.time.Period;

public class DateUtils {

    public static Integer calculaIdade(LocalDate birthDate) {
        LocalDate currentDate = LocalDate.now();
        return (birthDate != null)
                ? Period.between(birthDate, currentDate).getYears()
                : null;
    }
}
