import java.util.ListResourceBundle;

/**
 * Created by bespa on 02.06.2017.
 */
public class Locale_isl extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                { "true", "Já"},
                { "false",   "enga"},
                { "Delete",  "Til að fjarlægja"},
                {"Edit",     "Til að breyta"},
                {"DoHust",     "Запустить фичу!!!"},
                {"ShowThoughts",  "Sýna hugsanir"},
                {"Do",   "Til að gera"},
                {"hust",     "Flís"},
                {"AddInJson",    "Bæta í json"},
                {"Remove",   "Fjarlægja json"},
                {"AddPerson",    "Til að bæta mann"},
                {"ChooseColor",  "Veldu lit"},
                {"ChooseLanguage",   "Til að velja tungumál"},
                {"Name",     "Nafnið"},
                {"Age",  "Aldri"},
                {"Add",  "Bæta við"},
                {"Cancel",   "Nálægt"},
                {"TroublesWithTheLaw",   "í vandræðum með lögum"},
                {"Play",  "Spila"},
                {"Stop",   "Остановить"},
                {"Pause","Hlé"},
                {"Resume","Ný"},
                {"Ok","allt í lagi"},
                {"SetName","Nafnið"},
                {"MalishAndKarlson","Малыш и Карлсон"},
                {"PutHere","Добавьте человека в json:"}
        };
    }
}
