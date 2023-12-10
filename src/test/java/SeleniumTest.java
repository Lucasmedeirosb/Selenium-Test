import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SeleniumTest {

	private WebDriver driver;

	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		assertNotNull(driver);
		driver.manage().window().maximize();
		driver.get("https://demo.testfire.net/login.jsp");
	}

	@AfterEach
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void test1() {
		WebElement queryInput = driver.findElement(By.xpath("//*[@id='query']"));
		assertNotNull(queryInput);

		String currentUrl = driver.getCurrentUrl();
		String expected = "https://demo.testfire.net/login.jsp";

		assertEquals(expected, currentUrl);
	}

	@Test
	public void test2() {
		WebElement queryInput = driver.findElement(By.xpath("//*[@id='query']"));
		assertNotNull(queryInput);
		WebElement searchButton = driver.findElement(By.xpath("//*[@id='frmSearch']/table/tbody/tr[1]/td[2]/input[2]"));
		assertNotNull(searchButton);
		queryInput.sendKeys("kung fu whatsapp");
		searchButton.click();
		String currentUrl = driver.getCurrentUrl();
		String expected = "https://demo.testfire.net/search.jsp?query=kung+fu+whatsapp";

		assertEquals(expected, currentUrl);
	}

	@Test
	public void test3() {
		WebElement campoUsuario = driver.findElement(By.name("uid"));
		assertNotNull(campoUsuario);

		WebElement campoSenha = driver.findElement(By.name("passw"));
		assertNotNull(campoSenha);

		WebElement botaoLogin = driver.findElement(By.name("btnSubmit"));
		assertNotNull(botaoLogin);

		campoUsuario.sendKeys("demo");
		campoSenha.sendKeys("demo");
		botaoLogin.click();

		String urlAtual = driver.getCurrentUrl();
		String esperado = "https://demo.testfire.net/login.jsp";

		assertEquals(esperado, urlAtual);
	}

	@Test
	public void test4() {

		WebElement contact = driver.findElement(By.xpath("//*[@id=\"MenuHyperLink14\"]"));
		Actions actions = new Actions(driver);
		actions.moveToElement(contact).perform();
		contact.click();

		String urlAtual = driver.getCurrentUrl();
		String esperado = "https://demo.testfire.net/index.jsp?content=inside_contact.htm";
		assertEquals(esperado, urlAtual);
	}

	@Test
	public void test5() {

	}

	@Test
	public void test6() {
		// Seu código de teste para test4
	}

	@Test
	public void test7() {
		// Seu código de teste para test4
	}

	@Test
	public void test8() {
		// Seu código de teste para test4
	}

	@Test
	public void test9() {
		// Seu código de teste para test4
	}

	@Test
	public void test10() {
		// Seu código de teste para test4
	}
}
