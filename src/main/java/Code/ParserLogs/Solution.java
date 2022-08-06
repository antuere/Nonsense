package Code.ParserLogs;

import java.io.IOException;
import java.nio.file.Paths;
import java.text.ParseException;
import java.util.Date;

public class Solution {
    public static void main(String[] args) throws IOException, ParseException {
        LogParser logParser = new LogParser(Paths.get("C:\\Users\\user\\Desktop\\logs"));

        logParser.setLogs();
        System.out.println(logParser.getUniqueIPs(null, new Date()));
    }
}