package components;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class ResultModal {

    public ResultModal checkTableRow(String label, String value) {
        $(".table")
                .shouldHave(Condition.text(label), Condition.text(value));
        return this;
    }
}