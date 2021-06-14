package org.acme;

import io.quarkus.runtime.StartupEvent;
import org.eclipse.microprofile.config.ConfigProvider;

import javax.enterprise.event.Observes;
import java.util.concurrent.CompletableFuture;

public class MyApp {

    void startup(@Observes StartupEvent event) {
        String myProperty = ConfigProvider.getConfig().getValue("my.property", String.class);
        System.out.println("my.property=" + myProperty);
        CompletableFuture.runAsync(() -> {
            ConfigProvider.getConfig().getValue("my.property", String.class);
        }).join();
    }
}
