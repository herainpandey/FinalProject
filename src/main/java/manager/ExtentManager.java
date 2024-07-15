package manager;

import com.aventstack.extentreports.AnalysisStrategy;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

    public static final ExtentReports extentReports = new ExtentReports();
    public synchronized static ExtentReports createExtentReports(){
        ExtentSparkReporter reporter = new ExtentSparkReporter("./target/test-output/extent-reports/extent-report.html");
        reporter.config().setTheme(Theme.STANDARD);
        reporter.config().setEncoding("UTF-8");
        extentReports.attachReporter(reporter);
        return extentReports;
    }
}
