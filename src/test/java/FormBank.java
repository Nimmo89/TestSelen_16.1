import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.*;

public class FormBank {

    @Test
    void shouldTestV1() {
        open("http://localhost:9999");
        $("[data-test-id=name] input").setValue("Павел К");
        $("[data-test-id=phone] input").setValue("+79238456245");
        $("[data-test-id=agreement]").click();
        $("button").click();
        $("[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
