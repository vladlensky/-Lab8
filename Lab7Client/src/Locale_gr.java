import java.util.ListResourceBundle;

/**
 * Created by bespa on 02.06.2017.
 */
public class Locale_gr extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                { "true", "ναι"},
                { "false",   "όχι"},
                { "Delete",  "Διαγραφή"},
                {"Edit",     "Αλλαγή"},
                {"DoHust",     "μπορείτε να εκτελέσετε!!!"},
                {"ShowThoughts",  "Εμφάνιση σκέψεις"},
                {"Do",   "Να"},
                {"hust",     "Μάρκα"},
                {"AddInJson",    "Προσθήκη σε json"},
                {"Remove",   "Διαγραφή σε json"},
                {"AddPerson",    "Προσθήκη ατόμου"},
                {"ChooseColor",  "Επιλέξτε το χρώμα"},
                {"ChooseLanguage",   "Να επιλέξετε τη γλώσσα της"},
                {"Name",     "Όνομα"},
                {"Age",  "Ηλικία"},
                {"Add",  "Προσθέσετε"},
                {"Cancel",   "να Κλείσει"},
                {"TroublesWithTheLaw",   "Προβλήματα με το νόμο"},
                {"Play",  "Παίξτε"},
                {"Stop",   "Σταμάτα"},
                {"Pause","Παύση"},
                {"Resume","Βιογραφικό"},
                {"Ok","εντάξει"},
                {"SetName","Όνομα"},
                {"MalishAndKarlson","Παιδί και Carlson"},
                {"PutHere","Προσθέστε το άτομο σε JSON:"}
        };
    }
}