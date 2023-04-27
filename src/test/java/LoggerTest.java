
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoggerTest {

    private Logger logger;

    @BeforeEach
    public void setUp() {
        logger = new Logger();
    }

    /**
     * Tests the log() method of the Logger class with a default logging level.
     */
    @Test
    public void testLogDefaultLogLevel() {
        String message = "Test log message";
        String expectedLogMessage = "[DEBUG]";

        logger.log(message);
        String actualLogMessage = logger.formatMessage(LogLevel.DEBUG, message).substring(0, 7);

        assertEquals("[DEBUG]", expectedLogMessage, actualLogMessage);
    }

    /**
     * Tests the log() method of the Logger class with a custom logging level.
     */
    @Test
    public void testLogCustomLogLevel() {
        String message = "Test log message";
        String expectedLogMessage = "[ERROR]";

        logger.setMinimumLogLevel(LogLevel.ERROR);
        logger.log(message, LogLevel.ERROR);
        String actualLogMessage = logger.formatMessage(LogLevel.INFO, message).substring(0, 7);

        assertEquals("[ERROR]", expectedLogMessage, actualLogMessage);
    }

    /**
     * Tests the setMinimumLogLevel() method of the Logger class.
     */
    @Test
    public void testSetMinimumLogLevel() {
        LogLevel expectedLevel = LogLevel.ERROR;

        logger.setMinimumLogLevel(expectedLevel);
        LogLevel actualLevel = logger.getMinimumLogLevel();

        assertEquals(expectedLevel, actualLevel, "Expected minimum LogLevel: ERROR");
    }

    /**
     * Tests the setLogLevel() method of the Logger class.
     */
    @Test
    public void testSetLogLevel() {
        LogTarget logTarget = new LogTarget("newTarget");
        LogLevel expectedLevel = LogLevel.WARNING;

        logger.setLogLevel(logTarget, expectedLevel);
        LogLevel actualLevel = logger.getLogLevelMap().get(logTarget);

        assertEquals(expectedLevel, actualLevel, "Expected LogLevel: WARNING");
    }

    /**
     * Tests the addLogTarget() method of the Logger class.
     */
    @Test
    public void testAddLogTarget() {
        LogTarget logTarget = new LogTarget("testLogTarget");
        int expectedSize = 2;

        logger.addLogTarget(logTarget);
        int actualSize = logger.getLogTargets().size();

        assertEquals(2, expectedSize, actualSize);
    }

    /**
     * Tests the removeLogTarget() method of the Logger class.
     */
    @Test
    public void testRemoveLogTarget() {
        LogTarget logTarget = new LogTarget("console");
        int expectedSize = 0;

        logger.removeLogTarget(logTarget);
        int actualSize = logger.getLogTargets().size();

        assertEquals(0, expectedSize, actualSize);
    }
}
