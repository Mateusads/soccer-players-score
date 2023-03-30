package br.com.medeiros.external;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Buffer {

  public BufferedReader createBuffer(final String filePath) throws IOException {
    BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
    return bufferedReader;
  }
}


