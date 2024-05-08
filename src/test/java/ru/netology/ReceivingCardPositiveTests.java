package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ReceivingCardPositiveTests {
    @BeforeEach
    void setUp() {
        open("http://localhost:9999");
    }

    @Test
    public void shouldBeOk() {
        //Кириллица,заглавные и строчные буквы,пробелы в поле "Фамилия,имя", + и цифры в поле "Телефон", согласие выставлено.
        $("[data-test-id=name] input").setValue("Вася Пупкин");
        $("[data-test-id=phone] input").setValue("+79602958784");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=order-success").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время."));

    }
    @Test
    public void shouldBeOk1() {
        //Кириллица,заглавные и строчные буквы,пробелы и дефис в поле "Фамилия,имя", + и цифры в поле "Телефон", согласие выставлено.
        $("[data-test-id=name] input").setValue("Вася Пупкин-Сидоров");
        $("[data-test-id=phone] input").setValue("+79602958784");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=order-success").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время."));

    }
    @Test
    public void shouldBeOk2() {
        //Кириллица,заглавные буквы и строчные буквы,наличие "й", пробелы и дефис в поле "Фамилия,имя", + и цифры в поле "Телефон", согласие выставлено.
        $("[data-test-id=name] input").setValue("Василий Пупкин-Сидоров");
        $("[data-test-id=phone] input").setValue("+79602958784");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=order-success").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время."));

    }
    @Test
    public void shouldBeOk4() {
        //Кириллица,заглавные буквы,пробелы в поле "Фамилия,имя", + и цифры в поле "Телефон", согласие выставлено.
        $("[data-test-id=name] input").setValue("ВАСЯ ПУПКИН");
        $("[data-test-id=phone] input").setValue("+79602958784");
        $("[data-test-id=agreement]").click();
        $(".button").click();
        $("[data-test-id=order-success").shouldHave(Condition.exactText("Ваша заявка успешно отправлена! " +
                "Наш менеджер свяжется с вами в ближайшее время."));

    }
}
