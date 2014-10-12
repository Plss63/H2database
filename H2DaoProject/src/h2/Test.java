package h2;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Test {

    public static void main(String[] args) throws SQLException, IOException, ParseException {
        Menu menu = new Menu();
        menu.showmenu();
    }
}
