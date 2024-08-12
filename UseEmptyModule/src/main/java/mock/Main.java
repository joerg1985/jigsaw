package mock;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.tracing.opentelemetry.OpenTelemetryTracer;

public class Main {

    public static void main(String[] args) {
        // the logic is working but you must not hit the missing classes
        {
            ChromeOptions opts = new ChromeOptions();
            opts.addArguments("--disable-search-engine-choice-screen");

            ChromeDriver cd = new ChromeDriver(opts);

            cd.get("https://www.openjdk.org");

            cd.quit();
        }

        // calling static stuff works as long as you do not reach missing classes
        OpenTelemetryTracer.getHttpLogs();

        // java.lang.NoClassDefFoundError as soon as you try call code using these missing classes
        OpenTelemetryTracer.getInstance();
    }
}
