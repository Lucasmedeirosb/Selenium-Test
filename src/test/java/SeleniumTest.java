import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class SeleniumTest {

	private WebDriver driver;

	@BeforeEach
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "driver/chromedriver.exe");
		driver = new ChromeDriver();
		assertNotNull(driver);
		driver.manage().window().maximize();
		driver.get("https://pt-br.facebook.com/");
	}

	@AfterEach
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void test1() {
		WebElement queryInput = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img"));
		assertNotNull(queryInput);

		String currentUrl = driver.getCurrentUrl();
		String expected = "https://pt-br.facebook.com/";

		assertEquals(expected, currentUrl);
	}

	@Test
	public void test2() {
		WebElement queryInput = driver.findElement(By.xpath("//*[@id=\"email\"]"));
		assertNotNull(queryInput);
		WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"pass\"]"));
		assertNotNull(searchButton);
		queryInput.sendKeys("kung fu whatsapp");
		searchButton.sendKeys("123456");
	}

	@Test
	public void test3() {
		WebElement campoUsuario = driver.findElement(By.name("email"));
		assertNotNull(campoUsuario);

		WebElement campoSenha = driver.findElement(By.name("pass"));
		assertNotNull(campoSenha);

		WebElement botaoLogin = driver.findElement(By.name("login"));
		assertNotNull(botaoLogin);

		campoUsuario.sendKeys("demo");
		campoSenha.sendKeys("demo");
		botaoLogin.click();

	}

	@Test
	public void test4() {

		WebElement contact = driver.findElement(By.xpath("//*[@id=\"reg_pages_msg\"]/a"));
		Actions actions = new Actions(driver);
		actions.moveToElement(contact).perform();
		contact.click();

		String urlAtual = driver.getCurrentUrl();
		String esperado = "https://pt-br.facebook.com/pages/create/?ref_type=registration_form";
		assertEquals(esperado, urlAtual);
	}

	@Test
	public void test5() {

		WebElement elemento = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[1]/div/img"));

		assertTrue(elemento.isDisplayed());
	}

	@Test
	public void test6() {

		boolean elementoAusente = !driver.findElements(By.id("content > div > div > div > div._8esl > div > img"))
				.isEmpty();

		assertFalse(elementoAusente);

	}

	@Test
	public void test7() {
		WebElement campoUsuario = driver.findElement(By.name("email"));
		WebElement campoSenha = driver.findElement(By.name("pass"));
		campoUsuario.sendKeys("Lucas Medeiros");
		campoSenha.sendKeys("123456");
		campoSenha.submit();

	}

	@Test
	public void test8() {
		driver.get(
				"https://www.facebook.com/campaign/landing.php?&campaign_id=1661784632&extra_1=s%7Cc%7C513440433289%7Ce%7Ccadastro%20facebook%7C&placement=&creative=513440433289&keyword=cadastro%20facebook&partner_id=googlesem&extra_2=campaignid%3D1661784632%26adgroupid%3D63686353363%26matchtype%3De%26network%3Dg%26source%3Dnotmobile%26search_or_content%3Ds%26device%3Dc%26devicemodel%3D%26adposition%3D%26target%3D%26targetid%3Dkwd-371326262796%26loc_physical_ms%3D1031854%26loc_interest_ms%3D%26feeditemid%3D%26param1%3D%26param2%3D&gclid=EAIaIQobChMInZz4qqGGgwMV4UVIAB0nTArmEAAYASAAEgKS3fD_BwE");
		WebElement newaccount = driver.findElement(By.xpath("//*[@id=\"day\"]"));
		Select select = new Select(newaccount);
		int indiceOpcaoDesejada = 3;
		select.selectByIndex(indiceOpcaoDesejada);

	}

	@Test
	public void test9() {
		WebElement contact = driver.findElement(By.xpath("//*[@id=\"pageFooter\"]/ul/li[2]/a"));
		Actions actions = new Actions(driver);
		actions.moveToElement(contact).perform();
		contact.click();
	}

	@Test
	public void test10() {
		WebElement contact = driver.findElement(By.xpath("//*[@id=\"pageFooterChildren\"]/ul/li[3]/a"));
		Actions actions = new Actions(driver);
		actions.moveToElement(contact).perform();
		contact.click();
		String urlAtual = driver.getCurrentUrl();
		String esperado = "https://www.messenger.com/";
		assertEquals(esperado, urlAtual);
	}
}
