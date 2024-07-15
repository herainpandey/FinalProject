package manager;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import java.util.HashMap;
import java.util.Map;

public class ExtentTestManager {
    static Map<Integer, ExtentTest> extentTestMap = new HashMap<>();
    static ExtentReports extent = ExtentManager.createExtentReports();

    public static synchronized ExtentTest getTest() {
        return extentTestMap.get((int) Thread.currentThread().getId());
    }


    public static synchronized ExtentTest startTest(String testName, String className) {
        ExtentTest test = extent.createTest(testName, className);
        extentTestMap.put((int) Thread.currentThread().getId(), test);
        return test;
    }
}
