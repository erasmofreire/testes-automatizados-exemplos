
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import atu.testrecorder.ATUTestRecorder;

public class GravarAcesso {
	
	 
	
	 WebDriver driver;	
	 ATUTestRecorder recorder;
	 
	 @Before
	 public void setup() throws Exception {
	
		
		// Declaração e inicialização do webdriver para o navegador Chrome	
		 System.setProperty("webdriver.chrome.driver", "C:\\Meu robo\\chromedriver.exe");				
		 WebDriver driver = new ChromeDriver();	
	    	
		 // Formata a data e hora do video
	  DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy HH-mm-ss");
	  Date date = new Date();
	  
	  //Created object of ATUTestRecorder
	  //Provide path to store videos and file name format.
	  recorder = new ATUTestRecorder("C:\\Users\\13596800803\\Desktop\\GlobalWeb\\Testes\\Eclipse\\Gravar\\","TestVideo-"+dateFormat.format(date),false);
	  //To start video recording.
	  recorder.start(); 

	  // Acessa o site do teste, maximiza a tela e faz uma espera de 10 segundos
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://google.com/");
	   // q its the search box name/ID
			WebElement busca = driver.findElement(By.name("q"));
			 
			// Seaching for site Policia Militar
			busca.sendKeys("Automação de Testes");
			 
			// Submit the form
			busca.submit();
			
			WebElement site = driver.findElement(By.cssSelector(".g:nth-child(5) .ellip"));
	        site.click();
	 }
	 
	 @Test
	  public void getScrollStatus() throws Exception { 
		
		 /* driver.manage().window().setSize(new Dimension(400,768));
		  Thread.sleep(2000);  
		  
		  driver.manage().window().setSize(new Dimension(400,400));
		  Thread.sleep(2000);
		  
		  driver.manage().window().setSize(new Dimension(1024,400));  */    
		 } 
		 
	 @After
	     //Fecha a gravação
		 public void Close() throws Exception {
		 recorder.stop();
		// driver.quit();
		  
		  
		 }
		 }  
		  
	 
 
	
