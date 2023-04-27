import lombok.Data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The Logger class provides a simple and customizable logging solution for Java applications.
 * It allows for the configuration of multiple log targets with different logging levels.
 */
@Data
public class Logger {

    private LogLevel minimumLogLevel = LogLevel.DEBUG;
    private Map<LogTarget, LogLevel> logLevelMap = new HashMap<>();
    private List<LogTarget> logTargets = new ArrayList<>();

    public Logger() {
        this.addLogTarget(new LogTarget("console"));
    }

    /**
     * Logs the given message with the default logging level (INFO) to all log targets.
     * @param message the message to log
     */
    public void log(String message) {
        log(message, LogLevel.INFO);
    }

    /**
     * Logs the given message with the given logging level to all log targets that have a logging level equal to or greater than the given logging level.
     * @param message the message to log
     * @param logLevel the logging level
     */
    public void log(String message, LogLevel logLevel) {
        if (logLevel.ordinal() >= minimumLogLevel.ordinal()) {
            for (LogTarget logTarget : logTargets) {
                LogLevel targetLogLevel = logLevelMap.getOrDefault(logTarget, minimumLogLevel);
                if (logLevel.ordinal() >= targetLogLevel.ordinal()) {
                    System.out.println(formatMessage(logLevel, message));
                }
            }
        }
    }

    /**
     * Sets the minimum logging level for all log targets.
     * @param minimumLogLevel the minimum logging level
     */
    public void setMinimumLogLevel(LogLevel minimumLogLevel) {
        this.minimumLogLevel = minimumLogLevel;
    }

    /**
     * Sets the logging level for the given log target.
     * @param logTarget the log target
     * @param logLevel the logging level
     */
    public void setLogLevel(LogTarget logTarget, LogLevel logLevel) {
        logLevelMap.put(logTarget, logLevel);
    }

    /**
     * Adds a new log target.
     * @param logTarget the log target to add
     */
    public void addLogTarget(LogTarget logTarget) {
        logTargets.add(logTarget);
    }

    /**
     * Removes an existing log target.
     * @param logTarget the log target to remove
     */
    public void removeLogTarget(LogTarget logTarget) {
        logTargets.remove(logTarget);
    }

    /**
     * Formats the given message with the logging level and timestamp.
     * @param level the logging level
     * @param message the message to format
     * @return the formatted message
     */
    public String formatMessage(LogLevel level, String message) {
        LocalDateTime timestamp = LocalDateTime.now();
        String formattedTimestamp = timestamp.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        return String.format("[%s] [%s] %s", level.name(), formattedTimestamp, message);
    }
}