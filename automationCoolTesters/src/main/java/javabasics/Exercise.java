package javabasics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise {
	public static void main(String[] args) {
		/*
		  	Operators Java 8 meaning 
		  
		  	x += y is x = x + y
			x -= y is x = x - y
			x *= y is x = x * y
			x /= y is x = x / y
			x %= y is x = x % y
			x ^= y is x = x ^ y
			x &= y is x = x & y
			x |= y is x = x | y
			
			System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
       		WebDriver driver = new ChromeDriver();
    		driver.get("http://www.google.com")
    		
    		driver.findElement(By.xpath("//label[text()='User Name:']/following::div/input")).sendKeys("UserName");
 			driver.findElement(By.xpath("//label[text()='User Name:']/following::div/input")).sendKeys(Keys.TAB)
 			driver.findElement(By.name("submit")).click();
 			String Text = driver.findElement(By.id("myDiv")).getText();
 			
	 		WebElement source = driver.findElement(By.xpath("//select[@name='number']"));
	 		Select list = new Select(source);
			list.selectByVisibleText("4")
			
			List<WebElement> elements = driver.findElements(By.name("name"));
	    	System.out.println("Number of elements:" +elements.size());
	
			By mySelector = By.xpath("/html/body/div[1]/div/section/div/div[2]/form[1]/div/ul/li");
			List<WebElement> myElements = driver.findElements(mySelector);
			for(WebElement e : myElements) {
			System.out.println(e.getText());
			}
	    	
	    	Thread.sleep(2000);
			
		  */
	
		//ordena de menor a mayor
		
		 List<Integer> numeros = new ArrayList<>();
		    numeros.add(1);
		    numeros.add(29);
		    numeros.add(3);
		    numeros.add(8);
		    numeros.add(1);
		    numeros.add(1);
		    numeros.add(1);
		    
		   
		    System.out.println("Original list: " + numeros );
		    System.out.println("The Major Number : " + Collections.max(numeros));
		    System.out.println("The Minor Number : " + Collections.min(numeros)+"\n");
		    // Ordenando los numeros menor a mayor   
		    Collections.sort(numeros, Integer::compareTo);
		    System.out.println("short minor to major: " + numeros);
		    
		    //ordenar de mayor a menor
		    Collections.sort(numeros, Collections.reverseOrder());
		    System.out.println("Short major to Minor: "+ numeros+"\n");
		    
		    
		   //removiendo duplicados
		    Object last = null;
			Collections.sort(numeros);
			int numCount=0;
		       Iterator<Integer> i = numeros.iterator();
		       while(i.hasNext()) {
		           Object temp = i.next();
			           if (temp.equals(last)) {
			               i.remove();
			               numCount++;
			           } else {
			               last = temp;
			           }
		          }
		    System.out.println("Remove repeated numbers: " + numeros);
		    System.out.println("Amount of times that elemet is reapeated: "+ numCount +"\n");
		//comparar strings iguales y removerlos    
		List<String> nombre = new ArrayList<>();
	    nombre.add("Persona 1");
	    nombre.add("Persona 1");
	    nombre.add("Persona 1");
	    nombre.add("Persona 2");
	    nombre.add("Persona 3");
	    nombre.add("Persona 3");
	    nombre.add("Persona 3");
	    System.out.println("Original list: " + nombre);
	    
	    List<String> nombreSinDuplicados = nombre
	       .stream()
	       .distinct()
	       .collect(Collectors.toList());	    
	    
	    
	    int count = 0;
	    int count2 = 0;
	    System.out.println("Remove Repeated names:  "+ nombreSinDuplicados+"\n");
	    for(String names:  nombreSinDuplicados) {
	    	
	    	if(names.equals("Persona 1")) {
	    		count++;
	    	}
	    }
	    System.out.println("Amount of times that elemet is reapeated in list without duplicates numbers: " + count);
	   
	    for(String names:  nombre) {
	    	
	    	if(names.equals("Persona 1")) {
	    		count2++;
	    	}
	    }
	    System.out.println("Amount of times that elemet is reapeated in list with duplicates: " + count2);
	    

	}//end main
}
