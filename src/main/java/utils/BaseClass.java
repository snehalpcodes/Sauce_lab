package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import javax.print.attribute.standard.DateTimeAtCompleted;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.Date;

public class BaseClass {

    public static void takeScreenshot(WebDriver driver,String path) throws IOException {

        TakesScreenshot screenshot = (TakesScreenshot) driver;
        File src = screenshot.getScreenshotAs(OutputType.FILE);
        String filePath = System.getProperty("user.dir")+"//screenshot//"+path+".png";

        FileUtils.copyFile(src,new File(filePath));


    }
}
