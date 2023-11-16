package ru.netology.web.data.Page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.web.data.DataHelper;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private final SelenideElement transferButton = $(byText("Пополнить"));
    private final SelenideElement amountInput = $(".money-input input");
    private final SelenideElement fromInput = $(".card-input input");
    private final SelenideElement transferHead = $("h1").shouldHave(Condition.exactText("Пополнение карты"));
    public TransferPage() {
        transferHead.shouldBe(visible);
    }
    public DashboardPage transfer(String amount, DataHelper.CardInfo cardInfo) {
        amountInput.setValue(amount);
        fromInput.setValue(cardInfo.getCardNumber());
        transferButton.click();
        return new DashboardPage();
    }
}
