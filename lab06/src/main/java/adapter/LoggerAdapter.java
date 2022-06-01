package adapter;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoggerAdapter implements ILoggerAdapter {
    private static final Map<Class<?>, ILoggerAdapter> INSTANCE_MAP = Collections.synchronizedMap(new HashMap<>());

    private Logger logger;

    private LoggerAdapter(Logger logger) {
        this.logger = logger;
    }

    public static ILoggerAdapter getInstance(Class<?> clazz) {
        ILoggerAdapter adapter = INSTANCE_MAP.get(clazz);
        if (null == adapter) {
            synchronized (LoggerAdapter.class) {
                adapter = INSTANCE_MAP.get(clazz);
                if (null == adapter) {
                    adapter = new LoggerAdapter(LogManager.getLogger(clazz));
                    INSTANCE_MAP.put(clazz, adapter);
                }
            }
        }

        return adapter;
    }

    public void log(LogLevel logLevel, String message) {
        Level level = switch (logLevel) {
            case DEBUG -> Level.DEBUG;
            case ERROR -> Level.ERROR;
            case FATAL -> Level.FATAL;
            case INFO -> Level.INFO;
            case TRACE -> Level.TRACE;
            case WARNING -> Level.WARN;
        };

        logger.log(level, message);

    }

}
