package h2;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class EnterModel {

    private String input;
    private boolean restart;
    Scanner scanner = new Scanner(System.in);
    Check check = new Check();
    DeviceModel deviceModel = new DeviceModel();
    H2ConnectionSource connectionSource = new H2ConnectionSource();
    DeviceDao deviceDao = new DeviceDaoImpl(connectionSource);

    private void addDevice() {
        restart = true;
        while (restart) {
            System.out.println("input Device");
            input = scanner.nextLine();
            if (check.checkDevice(input) == false)
                System.out.println("Error! Lenghts of the string > 30");
            else {
                restart = false;
                deviceModel.setDevice(input);

            }

        }
    }

    private void addDispley() {
        restart = true;
        while (restart) {
            System.out.println("input number of Displey");
            input = scanner.nextLine();
            if (check.checkInt(input) == false)
                System.out.println("Error! input the number from 0-20");
            else {
                restart = false;
                deviceModel.setDispley(Integer.parseInt(input));
            }
        }
    }

    private void addCamera() {
        restart = true;
        while (restart) {
            System.out.println("input number mpixels of Camera");
            input = scanner.nextLine();
            if (check.checkInt(input) == false)
                System.out.println("Error! input the number from 0-20");
            else {
                restart = false;
                deviceModel.setCamera(Integer.parseInt(input));
            }
        }
    }

    private void addWifi() {
        restart = true;
        while (restart) {
            System.out.println("WiFi Yes or No?");
            input = scanner.nextLine();
            if (check.checkWifi(input) == false)
                System.out.println("Error! input 'YES' or 'NO'");
            else {
                deviceModel.setWifi("YES".equals(input));
                restart = false;
            }
        }
    }

    private void addDate() throws ParseException {
        restart = true;
        while (restart) {
            System.out.println("input Date in format YYYY-MM-DD");
            input = scanner.nextLine();
            if (check.checkDate(input) == false)
                System.out.println("Error input!");
            else {
                restart = false;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                long strTime = simpleDateFormat.parse(input).getTime();
                java.sql.Date date = new java.sql.Date(strTime);
                deviceModel.setDate(date);
            }
        }
    }

    private int addId() {
        restart = true;
        while (restart) {
            System.out.println("input ID");
            input = scanner.nextLine();
            if (check.checkInt(input) == false)
                System.out.println("Error! input number");
            else {
                restart = false;

            }
        }
        return Integer.parseInt(input);
    }

    public void add() throws ParseException, SQLException {
        addDevice();
        addDispley();
        addCamera();
        addWifi();
        addDate();
        deviceDao.create(deviceModel);
    }

    public void delete() throws NumberFormatException, SQLException {

        deviceDao.delete(addId());
    }

    public void search() throws NumberFormatException, SQLException {
        System.out.println(deviceDao.read(addId()));
    }

    public void update() throws ParseException, SQLException {
        addDevice();
        addDispley();
        addCamera();
        addWifi();
        addDate();
        deviceDao.update(addId(), deviceModel);
    }
}
