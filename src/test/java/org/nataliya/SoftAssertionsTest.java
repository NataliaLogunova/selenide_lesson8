package org.nataliya;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class SoftAssertionsTest {

    @BeforeAll
    static void beforeAllBase() {
        Configuration.holdBrowserOpen = true;
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1080x720";
    }

    @Test
    @DisplayName("Раздел JUnit5 присутствует в Soft assertions на GitHub")
    public void wikiSearch() {
        Selenide.open("/selenide/selenide");
        $("#wiki-tab").click();
        $(".wiki-pages-box").click();
        $(".wiki-more-pages-link button").click();
        $$("#wiki-pages-box .flex-1").filterBy(text("SoftAssertions")).first()
                .shouldBe(visible).click();
        $(".markdown-body").shouldHave(text("JUnit5"));


       // $(".wiki-pages-box").find(byText("Soft assertions"));


                //("Soft assertions")).click();

    }
}
