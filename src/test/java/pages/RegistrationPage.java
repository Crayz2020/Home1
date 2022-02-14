package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    // locators
    SelenideElement
            headerTitle = $(".main-header"),
            firstnameInput = $("#firstName"),
            lastnameInput = $("#lastName"),
            emailInput = $("#userEmail"),
            usernumberInput = $("#userNumber"),
            currentAddressInput = $("#currentAddress"),
            resultsTable = $(".table-responsive");


    // actions
    public RegistrationPage OpenPage() {
        open("/automation-practice-form");
        headerTitle.shouldHave(text("Practice Form"));

        return this;
    }
    public RegistrationPage setFirstName(String firstName) {
        firstnameInput.setValue(firstName);

        return this;

    }
    public RegistrationPage setLastName(String lastName) {
        lastnameInput.setValue(lastName);

        return this;

    }
    public RegistrationPage setEmail(String email) {
        emailInput.setValue(email);

        return this;


    }
    public void setUserNumber(String usernumber) {
        usernumberInput.setValue(usernumber);

    }
    public void setcurrentAddress(String currentAddress) {
        currentAddressInput.setValue(currentAddress);


    }
    public RegistrationPage checkForm(String value) {
        resultsTable.shouldHave(text(value));

        return this;

    }
}
