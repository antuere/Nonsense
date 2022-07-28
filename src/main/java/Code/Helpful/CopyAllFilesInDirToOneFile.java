package Code.Helpful;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CopyAllFilesInDirToOneFile {


//Проход по дереву файлов



    public List<File> allFiles = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        File directory = new File(args[0]);
        File file = new File(args[1]);
        File resultFile = new File(file.getParent() + "//allFilesContent.txt");

        CopyAllFilesInDirToOneFile solution = new CopyAllFilesInDirToOneFile();
        solution.workWithDir(directory);
        if (FileUtils.isExist(file) && FileUtils.isExist(directory)) {
            FileUtils.renameFile(file, resultFile);
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(resultFile, true));
            for (File currentFile : solution.allFiles) {
                if (currentFile.length() < 50) {
                    try (BufferedReader bufferedReader = new BufferedReader(new FileReader(currentFile))) {

                        while (bufferedReader.ready()) {
                            bufferedWriter.write(bufferedReader.readLine());
                        }
                        bufferedWriter.write("\n");
                    }
                }
            }
            bufferedWriter.close();
        }


    }

    public void workWithDir(File file) {
        if (!file.isDirectory()) {
            allFiles.add(file);
        }

        for (File files : file.listFiles()) {
            if (files.isDirectory()) {
                workWithDir(files);
            } else {
                allFiles.add(files);
            }
        }

    }
}

