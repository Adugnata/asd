import adapter.ILoggerAdapter;
import adapter.LogLevel;
import adapter.LoggerAdapter;

public class Application {
	private static final ILoggerAdapter logger =  LoggerAdapter.getInstance(Application.class);
	
	public static void main(String[] args) {
		logger.log(LogLevel.ERROR, "Logging...");
	}

}
