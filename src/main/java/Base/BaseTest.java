package Base;

import java.io.File;
import java.io.IOException;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import Factory.DriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class BaseTest {

	//private static final int OutputType = 0;
	protected WebDriver driver;
	
	
	
	
	@BeforeMethod
	public synchronized void StartDriver()
	{
		driver =new DriverManager().initializeDriver();
	}
	
	@AfterMethod
	public synchronized void quitDriver(ITestResult result) throws InterruptedException, IOException
	{
		Thread.sleep(2000);

		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			File Path=new File("scr"+ File.separator +"Chrome"+ File.separator+result.getTestClass().getRealClass().getSimpleName()+"_"+
		result.getMethod().getMethodName()+".png");
			takeScreenshotusingAshot(Path);
			
		
		}
		driver.quit();
		
	}

	/*
	 * private void takeScreenshot(File Path) throws IOException { TakesScreenshot
	 * TakesScreenshot= (TakesScreenshot)driver; File SrcFile=(File)
	 * TakesScreenshot.getScreenshotAs((org.openqa.selenium.OutputType.FILE));
	 * FileUtils.copyFile(SrcFile, Path); }
	 */	private void takeScreenshotusingAshot(File path)
	{
		Screenshot screenshot=new AShot()
        .shootingStrategy(ShootingStrategies.viewportPasting(1500))
        .takeScreenshot(driver);
		try {
ImageIO.write(screenshot.getImage(), "PNG", path);
		} catch (IOException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

	}
	

