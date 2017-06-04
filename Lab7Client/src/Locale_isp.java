import java.util.ListResourceBundle;

/**
 * Created by bespa on 02.06.2017.
 */
public class Locale_isp extends ListResourceBundle {
    @Override
    protected Object[][] getContents() {
        return new Object[][]{
                { "true", "sí"},
                { "false",   "no"},
                { "Delete",  "Eliminar"},
                {"DoHust",     "ejecutar!!!"},
                {"Edit",     "Cambiar"},
                {"ShowThoughts",  "Mostrar los pensamientos"},
                {"Do",   "Hacer"},
                {"hust",     "Ficha"},
                {"AddInJson",    "Agregar en json"},
                {"Remove",   "Eliminar en json"},
                {"AddPerson",    "Añadir a una persona"},
                {"ChooseColor",  "Elegir el color"},
                {"ChooseLanguage",   "Seleccionar el idioma"},
                {"Name",     "El nombre de"},
                {"Age",  "La edad"},
                {"Add",  "Agregar"},
                {"Cancel",   "Cerrar"},
                {"TroublesWithTheLaw",   "Problemas con la ley"},
                {"Play",  "Jugar"},
                {"Stop",   "Parada"},
                {"Pause","Pausa"},
                {"Resume","Curriculum vitae"},
                {"Ok","Bien"},
                {"SetName","El nombre de"},
                {"MalishAndKarlson","Kid y Carlson"},
                {"PutHere","Agregar a la persona a JSON:"}
        };
    }
}
