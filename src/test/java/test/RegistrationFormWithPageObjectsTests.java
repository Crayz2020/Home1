package test;


import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import static test.TestData.*;


public class RegistrationFormWithPageObjectsTests extends TestBase {
    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void successFillTest() {
        //Ввод данных
        registrationPage
                        .OpenPage()
                        .setFirstName(firstName)
                        .setLastName(lastName)
                        .setEmail(email)
                        .setUserNumber(userNumber)
                        .setGender(gender)
                        .setBirthDate("17" ,"September" ,"1993")
                        .setSubjects(subject)
                        .setHobbies(hobby)
                        .uploadFile(file)
                        .setcurrentAddress(currentAddress)
                        .selectState(state)
                        .selectCity(city)
                        .checkResoults()




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
                .checkForm(state + " " + city);

    }
}
