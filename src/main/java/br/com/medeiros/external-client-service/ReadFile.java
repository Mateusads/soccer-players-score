package br.com.medeiros.input.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ReadFile {

  public BufferedReader createPlayers(final String filePath) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
    return bufferedReader;
  }
}


