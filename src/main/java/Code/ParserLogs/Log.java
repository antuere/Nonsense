package Code.ParserLogs;

import java.util.Date;

public class Log {
    private String ip;
    private String user;
    private Date date;
    private Event event;

    private int task;

    private Status status;

    public Log(String ip, String user, Date date, Event event, int task, Status status) {
        this.ip = ip;
        this.user = user;
        this.date = date;
        this.event = event;
        this.task = task;
        this.status = status;
    }

    public String getIp() {
        return ip;
    }

    public String getUser() {
        return user;
    }

    public Date getDate() {
        return date;
    }

    public Event getEvent() {
        return event;
    }

    public Status getStatus() {
        return status;
    }


    public int getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "Log{" +
                "ip='" + ip + '\'' +
                ", user='" + user + '\'' +
                ", date=" + date +
                ", event=" + event +
                ", task=" + task +
                ", status=" + status +
                '}';
    }
}
