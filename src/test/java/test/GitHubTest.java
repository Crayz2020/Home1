package test;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class GitHubTest {

    @Test
    void softAssertionsShouldHaveJUnit5Example() {
        open("https://github.com/selenide/selenide/");
        Configuration.browserSize = "1920x1080";

        $("#wiki-tab").click();
        $(".wiki-rightbar").$(".js-wiki-more-pages-link").click();
        $(".wiki-rightbar").shouldHave(text("SoftAssertions"));
        $(byText("SoftAssertions")).click();
        $(".markdown-body").shouldHave(text("Using JUnit5 extend test class"));


    }
}
