package com.teste.wayonTiago;

import com.teste.wayonTiago.Dto.TesteRecord;
import com.teste.wayonTiago.exceptions.CharacterException;
import com.teste.wayonTiago.exceptions.EmptyException;
import com.teste.wayonTiago.exceptions.NotFoundException;
import com.teste.wayonTiago.exceptions.NumericException;
import com.teste.wayonTiago.service.TesteService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class TesteServiceTest {

    private final TesteService testeService = new TesteService();

    @DisplayName("Teste de exception de input numerico")
    @Test
    void whenThrowNumericException() {
        TesteRecord testeRecord = new TesteRecord("1a");

        Exception exception = Assertions.assertThrows(NumericException.class, () -> {
            testeService.getAnagrama(testeRecord);
        });

        String expectedMessage = "Error: Valor numérico não aceito!";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("Teste de exception de input nulo")
    @Test
    void whenThrowNotFoundException() {
        TesteRecord testeRecord = new TesteRecord(null);

        Exception exception = Assertions.assertThrows(NotFoundException.class, () -> {
            testeService.getAnagrama(testeRecord);
        });

        String expectedMessage = "Error: Valor nulo não aceito!";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("Teste de exception de input caractere")
    @Test
    void whenThrowCharacterException() {
        TesteRecord testeRecord = new TesteRecord("a");

        Exception exception = Assertions.assertThrows(CharacterException.class, () -> {
            testeService.getAnagrama(testeRecord);
        });

        String expectedMessage = "Error: Valor de caractere não aceito!";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("Teste de exception de input vazio")
    @Test
    void whenThrowEmptyException() {
        TesteRecord testeRecord = new TesteRecord("");

        Exception exception = Assertions.assertThrows(EmptyException.class, () -> {
            testeService.getAnagrama(testeRecord);
        });

        String expectedMessage = "Error: Valor vazio não aceito!";
        String actualMessage = exception.getMessage();

        Assertions.assertTrue(actualMessage.contains(expectedMessage));
    }

    @DisplayName("Teste de anagrama")
    @Test
    void producesAnagrama() {
        TesteRecord testeRecord = new TesteRecord("ABC");
        List<String> lista = Arrays.asList("ABC", "ACB", "BAC", "BCA", "CAB", "CBA");

        List<String> listaTesteService = testeService.getAnagrama(testeRecord);

        Assertions.assertEquals(listaTesteService, lista);
    }

}

