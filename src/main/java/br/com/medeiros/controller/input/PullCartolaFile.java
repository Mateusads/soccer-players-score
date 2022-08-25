package br.com.medeiros.controller.input;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class PullCartolaFile {

  public String createFile(int numberOfround) throws IOException {
    String url;
    URL fetchWebsite = null;
    fetchWebsite = new URL(
        "https://raw.githubusercontent.com/henriquepgomide/caRtola/master/data/01_raw/2022/rodada-"
            + numberOfround + ".csv");
    ReadableByteChannel readableByteChannel = Channels.newChannel(fetchWebsite.openStream());
    url = "src/main/resources/rodada-" + numberOfround + ".csv";
    FileOutputStream fos = new FileOutputStream(url);
    fos.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);

    return url;
  }
}
