package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    // locators
    SelenideElement firstnameInput = $("#firstName");
    SelenideElement lastnameInput = $("#lastName");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement usernumberInput = $("#userNumber");
    SelenideElement currentAddressInput = $("#currentAddress");
    SelenideElement resultsTable = $(".table-responsive");


    // actions\
    public void setFirstName(String firstName) {
        firstnameInput.setValue(firstName);

    }
    public void setLastName(String lastName) {
        lastnameInput.setValue(lastName);

    }
    public void setEmail(String email) {
        emailInput.setValue(email);

    }
    public void setUserNumber(String usernumber) {
        usernumberInput.setValue(usernumber);

    }
    public void setcurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);

    }
    public void checkForm(String value) {
        resultsTable.shouldHave(text(value));

    }
}
