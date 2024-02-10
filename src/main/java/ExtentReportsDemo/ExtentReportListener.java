package ExtentReportsDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener {


    public static ExtentReports initExtentReportObject()
    {
        ExtentReports reports;
        ExtentSparkReporter reporter= new ExtentSparkReporter("Report/report.html");
        reports =  new ExtentReports();
        reports.attachReporter(reporter);
        reporter.config().setDocumentTitle("Stock Management System");
        reporter.config().setReportName("Regression Testing");
        reports.setSystemInfo("Project Title","Stock Management");
        reports.setSystemInfo("Testers Name","Shobith JL");
        reports.setSystemInfo("Developers Name","Santosh KL");
        reports.setSystemInfo("Project DeadLine","20Aug2023");
        reports.setSystemInfo("Client Name","CSX");
        return reports;

    }

}
