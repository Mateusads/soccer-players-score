package br.com.medeiros.application;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.StartupEvent;
import io.quarkus.runtime.annotations.QuarkusMain;
import java.util.concurrent.atomic.AtomicInteger;
import javax.enterprise.event.Observes;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@QuarkusMain
public class SoccerPlayerScoreApplicationQuarkus {

  private static final AtomicInteger start = new AtomicInteger(0);

  public static void main(final String... args) {
    start.set((int) System.currentTimeMillis());
    Quarkus.run(args);
  }

  void onStart(@Observes final StartupEvent startupEvent) {
    final var elapsedTime = (int) (System.currentTimeMillis() - start.get());
    start.getAndSet(elapsedTime);
    log.info("The application is starting: {} seconds", elapsedTime);
  }

}