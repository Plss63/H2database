package h2;

import java.util.Date;

public class DeviceModel {
    private int Id;
    private String device;
    private int displey;
    private int camera;
    private boolean wifi;
    private Date date;
    
    
    public int getId() {
        return Id;
        
    }
    public void setId(int iD) {
        Id = iD;
    }
    public String getDevice() {
        return device;
    }
    public void setDevice(String device) {
        this.device = device;
    }
    
    public int getDispley() {
        return displey;
    }
    
    public void setDispley(int displey) {
        this.displey = displey;
    }
    
    public int getCamera() {
        return camera;
    }
    
    public void setCamera(int camera) {
        this.camera = camera;
    }
    
    public boolean hasWifi() {
        return wifi;
    }
    
    public void setWifi(boolean wifi) {
        this.wifi = wifi;
    }
    
    public Date getDate() {
        return date;
    }
    
    public void setDate(Date date) {
        this.date = date;
    }
    
    @Override
    public String toString() {
        String str = getId() + " " + getDevice() + " " + getDispley() + " " + getCamera() + " " + hasWifi() + " " + getDate();
        return str;
    }
    

    
}
