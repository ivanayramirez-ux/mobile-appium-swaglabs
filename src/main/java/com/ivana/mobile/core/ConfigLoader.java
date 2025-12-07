package com.ivana.mobile.core;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigLoader {

    private static Properties props;

    public static Properties load() {
        if (props == null) {
            props = new Properties();

            try {
                
                Path path = Paths.get(
                        System.getProperty("user.dir"),
                        "config",
                        "env-local.properties"
                );

                try (InputStream is = Files.newInputStream(path)) {
                    props.load(is);
                }

            } catch (IOException e) {
                throw new RuntimeException("Could not load env-local.properties from /config", e);
            }
        }

        return props;
    }
}
