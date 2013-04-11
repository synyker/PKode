import ohtu.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;



description 'user can list all added articles in a readable form'
 
scenario "user can list all added articles in a readable form", {
    given 'command list all selected'
    when 'readable format selected'
    then 'information should be printed on the screen in readable form'
}
 
