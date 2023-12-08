package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    private final static SelenideElement SET_YEAR = $(".react-datepicker__year-select"),
            SET_MONTH = $(".react-datepicker__month-select");

    public void setDate(String day, String month, String year) {
        SET_MONTH.selectOption(month);
        SET_YEAR.selectOption(year);
        $(".react-datepicker__day--0"+ day +":not(.react-datepicker__day--outside-month)").click();
    }
}
