package listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryListner implements IRetryAnalyzer {

    int max =3;
    int min=0;
    @Override
    public boolean retry(ITestResult iTestResult) {
        if(min<max){
            System.out.println("I'm going to try"+ min + "times");
            min++;
            return true;
        }
        return false;
    }
}
