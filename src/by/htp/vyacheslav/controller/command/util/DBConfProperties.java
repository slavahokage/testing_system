package by.htp.vyacheslav.controller.command.util;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Properties;

public class DBConfProperties {

    protected static FileInputStream fileInputStream;

    protected static Properties PROPERTIES;

    static {
        try {

            String classpathLocation = "resources/db.properties";
            URL classpathResource = Thread.currentThread().getContextClassLoader().getResource(classpathLocation);

            InputStream input = Thread.currentThread().getContextClassLoader().getResourceAsStream(classpathLocation);

            //fileInputStream = new FileInputStream( "../../../../../../../resources/db.properties");

            PROPERTIES = new Properties();

            PROPERTIES.load(input);

        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            if (fileInputStream != null)
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
    }

    public static String getProperty(String key) {

        return PROPERTIES.getProperty(key);
    }
}