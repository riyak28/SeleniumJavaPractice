package org.example.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Screenshot {
    public static void captureScreenshot(WebDriver driver) throws IOException {
        TakesScreenshot ts= (TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File screenshotfolder=new File("screenshots");
        if (!screenshotfolder.exists())
            screenshotfolder.mkdirs();
        String timestamp= new SimpleDateFormat("yyyy-MM-dd_HHmmss").format(new Date());
        File destination=new File("screenshots/"+timestamp+".jpg");
       // File destination=new File("screenshots/riya.jpg");
        Files.copy(source.toPath(),destination.toPath());
        System.out.println("Screenshot captured successfully" + destination);

    }


}
