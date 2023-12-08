package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class FormResultComponent {
    private final static SelenideElement RESULTS_TABLE = $(".table-responsive");

    public void checkRegistrationResults(String label, String value) {
        RESULTS_TABLE.$(byText(label)).parent().shouldHave(text(value));
    }
}
