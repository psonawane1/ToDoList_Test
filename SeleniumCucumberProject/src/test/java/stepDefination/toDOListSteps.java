package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.*;
import org.junit.*;

public class toDOListSteps {
	
	WebDriver driver = null;
	public String TotalEleDispalyed=null;
	public String before_count = null;
	
	String driverPath = "../SeleniumCucumberProject3/drivers/chromedriver";
	
	@Given("I navigate to the ToDOList page")
	public void i_navigate_to_the_to_do_list_page() {
		
		System.setProperty("webdriver.chrome.driver", driverPath);
		driver = new ChromeDriver();
		driver.get("https://todomvc.com/examples/vue/");
	 
	}
	
	@Given("Verify page title")
	public void verify_page_title() {
	    String ExpectedPageTitle = "Vue.js • TodoMVC";
	    String ActualPageTitle = driver.getTitle();
	    Assert.assertEquals(ExpectedPageTitle, ActualPageTitle);
	}
	
	@When("I Verify caption on page")
	public void i_verify_caption_on_page() {
		String Caption = driver.findElement(By.cssSelector("header[class='header'] h1")).getText();
		Assert.assertEquals(Caption,"todos");       
	}
	
	@When("I enter activities name")
	public void i_enter_activities_name() {
		WebElement toDoTask1 = driver.findElement(By.cssSelector("input[placeholder='What needs to be done?']"));
		toDoTask1.sendKeys("Breakfast");
		toDoTask1.sendKeys(Keys.ENTER);
		toDoTask1.sendKeys("Lunch");
		toDoTask1.sendKeys(Keys.ENTER);
		toDoTask1.sendKeys("Dinner");
		toDoTask1.sendKeys(Keys.ENTER);
	   
	}
	
	@When("I validate activities listed")
	public void i_validate_activities_listed() {
		

		WebElement element = driver.findElement(By.tagName("ul"));
		List<WebElement> webEleList = element.findElements(By.xpath("//li[@class=\"todo\"]"));
		System.out.println(webEleList.size());
		
		boolean todotasks_isEmpty = webEleList.isEmpty();
		Assert.assertFalse(todotasks_isEmpty);	   
	}
	
	@When("I click on All")
	public void I_click_on_All() {
		driver.findElement(By.xpath("//a[@class=\"selected\"]")).click();		   
	}
	
	@Then("I should see all tasks listed")
	public void I_should_see_all_tasks_listed() {
		
		WebElement element = driver.findElement(By.tagName("ul"));
		List<WebElement> webEleList = element.findElements(By.xpath("//li[@class=\"todo\"]"));
		int totalElement =  webEleList.size();
		System.out.println("totalElement"+totalElement);	
		
		String TotalEleDispalyed = driver.findElement(By.xpath("//span[@class=\"todo-count\"]")).getText();
		System.out.println("TotalEleDispalyed "+TotalEleDispalyed);
		
		String stotalElement = String.valueOf(totalElement);
		TotalEleDispalyed.contains(stotalElement); 
	}
	
	
	@When("I search for drop down")
	public void i_search_for_drop_down() {
	  WebElement dropDown =  driver.findElement(By.cssSelector("label[for='toggle-all']"));
	  boolean dropdownValue = dropDown.isDisplayed();	  
	  Assert.assertFalse(dropdownValue);	  
	}
	
	@Then("I verify no tasks are added")
	public void i_verify_no_tasks_are_added() {
		i_search_for_drop_down();
	}
	

	@Then("I should see tasks listed under all, active and completed links")
	public void i_should_see_tasks_listed_under_all_active_and_completed_links() {
		//click on link 'all'
		driver.findElement(By.xpath("//a[@class=\"selected\"]")).click();		
		I_should_see_all_tasks_listed();
		
		//click on link Active
		driver.findElement(By.xpath("/html/body/section/footer/ul/li[2]/a")).click();		
		I_should_see_all_tasks_listed();
		
		//click on link Completed
		driver.findElement(By.xpath("//a[text()=\"Completed\"]")).click();
		I_should_see_all_tasks_listed();
		
	}
	
	
	@Then("I should see clear all link besides completed link only")
	public void i_should_see_clear_all_link_besides_completed_link_only() {
	    
		driver.findElement(By.xpath("//a[text()=\"Completed\"]")).click();			
		WebElement dropDown =  driver.findElement(By.cssSelector("label[for='toggle-all']"));
		dropDown.click();
		boolean ClearCompleted = driver.findElement(By.xpath("/html/body/section/footer/button")).isDisplayed();
		Assert.assertTrue(ClearCompleted);
	}
	
	@When("I click on the checkbox of the task")
	public void i_click_on_the_checkbox_of_the_task() {
		String before_count = get_total_count();
		driver.findElement(By.xpath("//li[1]//div[1]//input[1]")).click();
	}
	
	public String get_total_count() {
		String TotalEleDispalyed = driver.findElement(By.xpath("//span[@class=\"todo-count\"]")).getText();
		return TotalEleDispalyed;
	}
	
	
	@Then("I should see reduced todo task at bottom of list along with clear task link enabled")
	public void i_should_see_reduced_todo_task_at_bottom_of_list_along_with_clear_task_link_enabled() {
					
		I_should_see_all_tasks_listed();
		boolean ClearCompleted = driver.findElement(By.xpath("/html/body/section/footer/button")).isDisplayed();
		Assert.assertTrue(ClearCompleted);
	}
	
	@Then("I should see completed task added to completed tasks")
	public void i_should_see_completed_task_added_to_completed_tasks() {
		
		driver.findElement(By.xpath("//a[text()=\"Completed\"]")).click();
		WebElement element = driver.findElement(By.tagName("ul"));
		List<WebElement> webEleList = element.findElements(By.xpath("//li[@class=\"todo completed\"]"));
		int totalElement =  webEleList.size();
		
		System.out.println("totalElement"+totalElement);
		Assert.assertEquals(totalElement,1);		
	}

	
	@Then("close the browser")
	public void close_the_browser() {
		driver.close();
	
	}

}
