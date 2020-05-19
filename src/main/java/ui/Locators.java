package ui;

public class Locators {
    //Селектор для Тип тендера
    public static final String tenderTypeFilter = "//select[@name='tendertype']";
    //Option для Тип тендера со значением Запрос котировок
    public static final String tenderTypeOpntion = "//select/option[text()='запрос котировок']";
    //Кнопка Показать
    public static final String sendForm = "//button[@name='send_form']";
    //Первый результат поиска
    public static final String firstResult = "//tbody/tr[1]/td[@align='left']/a[2]";
    //Кнопка Общая информация в Тендере
    public static final String generalInformation = "//a[text()='Общая информация']";
    //Строка Вид конкурса
    public static final String tenderTypeString = "//table[1]/tbody/tr[1]/td[2]/p";
}
