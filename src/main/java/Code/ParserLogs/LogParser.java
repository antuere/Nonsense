package Code.ParserLogs;

import Code.ParserLogs.query.IPQuery;

import java.io.*;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class LogParser implements IPQuery {
    private Path logDir;

    private ArrayList<Log> logs = new ArrayList<>();

    public LogParser(Path logDir) {
        this.logDir = logDir;
    }

    public ArrayList<Log> getStringLogs() {
        return logs;
    }

    public void setLogs() throws IOException, ParseException {
        File[] files = logDir.toFile().listFiles(x -> x.toString().endsWith(".log"));
        for (File log : files) {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(log));
            while (bufferedReader.ready()) {
                String[] logString = bufferedReader.readLine().split("\\t");

                String ip = logString[0];
                String user = logString[1];
                SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy hh:mm:ss");
                Date date = format.parse(logString[2]);

                String[] evStr = logString[3].split(" ");
                Event event = Event.valueOf(evStr[0]);
                int task = 0;
                if (evStr.length > 1 && evStr[1] != null) {
                    task = Integer.parseInt(evStr[1]);
                }

                Status status = Status.valueOf(logString[4]);

                logs.add(new Log(ip, user, date, event, task, status));

            }
        }
    }


    public boolean dateBetweenDates(Date current, Date after, Date before) {
        if (after == null) {
            after = new Date(0);
        }
        if (before == null) {
            before = new Date(Long.MAX_VALUE);
        }

        return current.after(after) && current.before(before);
    }

    @Override
    public int getNumberOfUniqueIPs(Date after, Date before) {
        return logs.stream().filter(x -> dateBetweenDates(x.getDate(), after, before))
                .map(x -> x.getIp())
                .collect(Collectors.toSet()).size();
    }

    @Override
    public Set<String> getUniqueIPs(Date after, Date before) {
        return logs.stream().filter(x -> dateBetweenDates(x.getDate(), after, before))
                .map(x -> x.getIp())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForUser(String user, Date after, Date before) {
        return logs.stream().filter(x -> x.getUser().equals(user))
                .filter(x -> dateBetweenDates(x.getDate(), after, before))
                .map(x -> x.getIp())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForEvent(Event event, Date after, Date before) {
        return logs.stream().filter(x -> x.getEvent().equals(event))
                .filter(x -> dateBetweenDates(x.getDate(), after, before))
                .map(x -> x.getIp())
                .collect(Collectors.toSet());
    }

    @Override
    public Set<String> getIPsForStatus(Status status, Date after, Date before) {
        return logs.stream().filter(x -> x.getStatus().equals(status))
                .filter(x -> dateBetweenDates(x.getDate(), after, before))
                .map(x -> x.getIp())
                .collect(Collectors.toSet());
    }
}