package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    public String firstName = "Andrey",
                  lastName = "Pugachev",
                  email = "Andrey_zamer@mail.ru",
                  userNumber = "1234567890",
                  currentAddress = "Ufa",
                  gender = "Male",
                  subjectInput = "P",
                  subject = "Physics",
                  hobby = "Reading",
                  state = "Haryana",
                  city = "Karnal";


    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }
}