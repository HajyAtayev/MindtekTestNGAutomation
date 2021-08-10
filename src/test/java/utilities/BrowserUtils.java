package utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BrowserUtils {
    /*
   Method that will accept dropdown WebElement
   and value of that dropdown, and it will select
   that value which is provided in parameter.
   Ex:
       .selectByValue(dropdownElement, "1"); -> void
    */
    public static void selectByValue(WebElement element, String value){
        Select select = new Select(element);
        select.selectByValue(value);
    }
}
