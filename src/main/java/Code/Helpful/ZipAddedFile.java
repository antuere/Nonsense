package Code.Helpful;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/*
Добавление файла в архив
*/
public class ZipAddedFile {

    public static void main(String[] args) throws IOException {

        String file = args[0];
        String zipFile = args[1];
        Path path = Paths.get(file);

        Map<ZipEntry, ByteArrayOutputStream> data = new HashMap<>();

        try (FileInputStream fileInputStream = new FileInputStream(zipFile);
             ZipInputStream zis = new ZipInputStream(fileInputStream)) {

            ZipEntry zipEntry;
            while ((zipEntry = zis.getNextEntry()) != null) {
                System.out.println(zipEntry.getName());
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                outputStream.write(zis.readAllBytes());
                data.put(zipEntry, outputStream);
            }
        }


        try (FileInputStream resIs = new FileInputStream(file);
             FileOutputStream resOs = new FileOutputStream(zipFile);
             ZipOutputStream zipOutputStream = new ZipOutputStream(resOs)) {

            for (Map.Entry<ZipEntry, ByteArrayOutputStream> entry : data.entrySet()) {
                zipOutputStream.putNextEntry(entry.getKey());
                zipOutputStream.write(entry.getValue().toByteArray());
                zipOutputStream.closeEntry();
            }

            zipOutputStream.putNextEntry(new ZipEntry("new/" + path.getFileName().toString()));
            zipOutputStream.write(resIs.readAllBytes());
            zipOutputStream.closeEntry();
        }

    }
}

