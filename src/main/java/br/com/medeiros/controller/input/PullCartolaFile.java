package br.com.medeiros.controller.input;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class PullCartolaFile {

  public String downloadFile(int numberOfMatches) throws IOException {

    int countMatches = 0;
    URL fetchWebsite = null;
    while (countMatches > numberOfMatches - 1) {
      try {
        fetchWebsite = new URL(
            "https://raw.githubusercontent.com/henriquepgomide/caRtola/master/data/01_raw/2022/rodada-"
                + countMatches + ".csv");
      } catch (MalformedURLException e) {
        throw new RuntimeException(e);
      }
    }

    ReadableByteChannel readableByteChannel = Channels.newChannel(fetchWebsite.openStream());
    try {
      var url = "src/main/resources/rodada-0.csv";
      FileOutputStream fos = new FileOutputStream(url);
      fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
      return url;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
