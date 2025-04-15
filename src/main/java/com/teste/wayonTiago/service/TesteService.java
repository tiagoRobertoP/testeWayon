package com.teste.wayonTiago.service;

import com.teste.wayonTiago.Dto.TesteRecord;
import com.teste.wayonTiago.exceptions.CharacterException;
import com.teste.wayonTiago.exceptions.EmptyException;
import com.teste.wayonTiago.exceptions.NotFoundException;
import com.teste.wayonTiago.exceptions.NumericException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TesteService {

    public List<String> getAnagrama(TesteRecord testeRecord) {
        if (testeRecord.input() == null)  //verificar se nulo
            throw new NotFoundException( "Error: Valor nulo não aceito!");
        String input = testeRecord.input().trim();
        if (input.equals("")) // verifica se veio vazio
            throw new EmptyException("Error: Valor vazio não aceito!");
        if (input.matches(".*\\d.*")) //verifica se tem numero
            throw new NumericException( "Error: Valor numérico não aceito!");
        if (input.length() == 1) // verifica se contem apenas uma letra
            throw new CharacterException( "Error: Valor de caractere não aceito!");

        return permutation(input, "", new ArrayList<>());
    }


    private List<String> permutation(String input, String resultado, List<String> lista) {
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (input.indexOf(c, i + 1) != -1)
                continue;
            permutation(input.substring(0, i) + input.substring(i + 1), resultado + c, lista);
        }
        //adiciona resultado na lista
        if (input.equals("")) {
            lista.add(resultado);
        }

        return lista;
    }
}
