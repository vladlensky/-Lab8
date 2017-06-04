/**
 * Created by bespa on 02.06.2017.
 */
import java.util.ListResourceBundle;

/**
 * Created by SlyFox on 19.05.2017.
 */
public class Locale_ru extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                { "true", "да"},
                { "false",   "нет"},
                { "Delete",  "Удалить"},
                {"Edit",     "Изменить"},
                {"DoHust",     "Запустить фичу!!!"},
                {"ShowThoughts",  "Показать мысли"},
                {"Do",   "Сделать"},
                {"hust",     "Фишку"},
                {"AddInJson",    "Добавление в json"},
                {"Remove",   "Удалить в json"},
                {"AddPerson",    "Добавить человека"},
                {"ChooseColor",  "Выбрать цвет"},
                {"ChooseLanguage",   "Выбрать язык"},
                {"Name",     "Имя"},
                {"Age",  "Возраст"},
                {"Add",  "Добавить"},
                {"Cancel",   "Закрыть"},
                {"TroublesWithTheLaw",   "Проблемы с законом"},
                {"Play",  "Играть"},
                {"Stop",   "Остановить"},
                {"Pause","Пауза"},
                {"Resume","Продолжить"},
                {"Ok","Принять"},
                {"SetName","Имя"},
                {"MalishAndKarlson","Малыш и Карлсон"},
                {"PutHere","Добавьте человека в json:"}
        };
    }
}
