package test;


import io.qameta.allure.Allure;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static io.qameta.allure.Allure.step;
import static test.TestData.*;


public class RegistrationFormWithPageObjectsTests extends TestBase {


    @Test
    public void successFillTest() {

        //Ввод данных

        step("Open page", () -> registrationPage.OpenPage());
        step("Set First name", () -> registrationPage.setFirstName(firstName));
        step("Set Last name", () -> registrationPage.setLastName(lastName));
        step("Set Number", () -> registrationPage.setUserNumber(userNumber));
        step("Set Email", () -> registrationPage.setEmail(email));
        step("Set Gender", () -> registrationPage.setGender(gender));
        step("Set Birthday", () -> registrationPage.setBirthDate("17", "September", "1993"));
        step("Set Subjects", () -> registrationPage.setSubjects(subject));
        step("Set Hobbies", () -> registrationPage.setHobbies(hobby));
        step("Upload File", () -> registrationPage.uploadFile(file));
        step("Set Address", () -> registrationPage.setcurrentAddress(currentAddress));
        step("Select State", () -> registrationPage.selectState(state));
        step("Select City", () -> registrationPage.selectCity(city));
        step("Submit", () -> registrationPage.checkResoults());
        step("Check Results", () -> registrationPage
                    // Проверка формы
                    .modalHeader()
                    .checkForm(firstName + " " + lastName)
                    .checkForm(email)
                    .checkForm(gender)
                    .checkForm(userNumber)
                    .checkForm(birthDate)
                    .checkForm(subject)
                    .checkForm(hobby)
                    .checkForm(file)
                    .checkForm(currentAddress)
                    .checkForm(state + " " + city));


        }
    }