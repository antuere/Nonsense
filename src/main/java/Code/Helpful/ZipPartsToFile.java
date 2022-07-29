package Code.Helpful;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipPartsToFile {

    public static void main(String[] args) throws IOException {

        List<FileInputStream> fileInputStreams = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            fileInputStreams.add(new FileInputStream(args[i]));
        }


        try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(args[0], true));
             ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams)))) {
            ZipEntry current;
            while ((current = zipInputStream.getNextEntry()) != null) {
                outputStream.write(zipInputStream.readAllBytes());


        }

    }


//public class Solution {
//    public static void main(String[] args) throws IOException {
//        File result = new File(args[0]);    //Файл результата, по совместительству имя этого файла мы ищем в архиве
//        if (!result.exists()) {
//            result.createNewFile();
//        }
//        List<FileInputStream> fileInputStreams = new ArrayList<>(); //Список входящих стримов из разных кусков архива
//
//        //Расставляем имена файлов архива в нужном нам порядке
//        List<String> fileNames = new ArrayList<>();
//        fileNames.addAll(Arrays.asList(args).subList(1, args.length));
//        Collections.sort(fileNames);
//
//        //Создаем входящий стрим для каждого куска архива
//        for (String name : fileNames) {
//            fileInputStreams.add(new FileInputStream(name));
//        }
//
//        try (ZipInputStream is = new ZipInputStream(new SequenceInputStream(Collections.enumeration(fileInputStreams))))    //Входящий стрим общего архива
//        {
//            while (true) {
//                ZipEntry entry = is.getNextEntry();
//                if (entry == null) break;
//
//                try (OutputStream os = new BufferedOutputStream(new FileOutputStream(result, true))) {
//                    final int bufferSize = 2048;
//                    byte[] buffer = new byte[bufferSize];
//                    for (int readBytes; (readBytes = is.read(buffer, 0, bufferSize)) > -1; ) {
//                        os.write(buffer, 0, readBytes);
//                    }
//                    os.flush();
//                }
//            }
//        }
//    }
//}
}
