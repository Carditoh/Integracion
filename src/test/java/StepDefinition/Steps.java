package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;


public class Steps {
	WebDriver driver;
	
	@Given("abrir Chrome")
	public void abrir_Chrome() {
		System.out.println("En este paso abre el navegador google chrome");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ricardo\\Downloads\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8081/Integracion/index.jsp");
	}
	
	@When("ingresa Username {string} y Password {string}")
	public void ingresa_Username_y_Password(String string1, String string2) {
		System.out.println("En este paso ingresa las credenciales de usuario");
		driver.findElement(By.id("username")).sendKeys(string1);
		driver.findElement(By.id("password")).sendKeys(string2);
	}
	
	@Then("inicia sesion")
	public void inicia_sesion() {
		System.out.println("En este paso inicia sesion con los datos ingresados desde el archivo MyTest.feature");
		driver.findElement(By.id("Enviar")).click();
	}
}
