package com.naveenautomation.Reports;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportListener extends TestListenerAdapter {

	public ExtentSparkReporter htmlSparkReporter;
	public ExtentTest test;
	public ExtentReports extent;

	@Override
	public void onStart(ITestContext testContext) {
		// Time on which report was generated
		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		// Name of the report
		String repName = "Extent_Report_" + timeStamp + ".html";

		// Defines the location of extent report
		htmlSparkReporter = new ExtentSparkReporter("./Extent Report/" + repName);

		// Loading the config XML
		try {
			htmlSparkReporter.loadXMLConfig("./extent-config.xml");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		htmlSparkReporter.config().setReportName("Regression Suite");
		htmlSparkReporter.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();

		extent.attachReporter(htmlSparkReporter);

		extent.setSystemInfo("Name of the host", "Localhost");
		extent.setSystemInfo("Tester Name", "Sahib");
		extent.setSystemInfo("Env", "Prod");

	}

	@Override
	public void onTestSuccess(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
	}

	@Override
	public void onTestFailure(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
	}

	@Override
	public void onTestSkipped(ITestResult tr) {
		test = extent.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
	}

	@Override
	public void onFinish(ITestContext testContext) {
		extent.flush();
	}

}
