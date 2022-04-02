package components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

        public void setDate(String year, String mouth, String day){
            $(".react-datepicker-popper")
                    .should(Condition.appear);

            $(".react-datepicker__month-select")
                    .selectOption(mouth);

            $(".react-datepicker__year-select")
                    .selectOption(year);

            $(".react-datepicker__day--0" + day + "")
                    .click();
        }
}
