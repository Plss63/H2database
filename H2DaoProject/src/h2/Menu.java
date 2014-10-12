package h2;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

public class Menu {
    EnterModel enterModel = new EnterModel();
    H2ConnectionSource connectionSource = new H2ConnectionSource();
    DeviceDao deviceDao = new DeviceDaoImpl(connectionSource);
    private char inputch, ignore;

    public void showmenu() throws IOException, SQLException, ParseException {
        for (;;) {
            do {
                System.out.println("Input 1 for add");
                System.out.println("Input 2 for delete");
                System.out.println("Input 3 for search");
                System.out.println("Input 4 for show all");
                System.out.println("Input 5 for update");
                System.out.println("Input 0 for exit");

                inputch = (char) System.in.read();

                do {
                    ignore = (char) System.in.read();
                } while (ignore != '\n');
            } while (inputch < '0' | inputch > '5');

            if (inputch == '0')
                break;
            switch (inputch) {
            case '1':
                enterModel.add();
                break;
            case '2':
                enterModel.delete();
                break;
            case '3':
                enterModel.search();
                break;
            case '4':
                for(DeviceModel device: deviceDao.getAll()) System.out.println(device);
                System.out.println("Count = " + deviceDao.count());
                break;
            case '5':
                enterModel.update();
                break;
            }

        }
    }
}
