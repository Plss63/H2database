package h2;

import java.sql.SQLException;
import java.util.List;

public interface DeviceDao {
    
    /** Создает новую запись и соответствующий ей объект */ 
    public void create(DeviceModel deviceModel) throws SQLException; 
    /** Возвращает объект соответствующий записи с первичным ключом key или null 
     * @throws SQLException */ 
    public DeviceModel read(int key) throws SQLException; 
    /** Сохраняет состояние объекта group в базе данных */ 
    public void update(int key, DeviceModel DeviceModel) throws SQLException; 
    /** Удаляет запись об объекте из базы данных */ 
    public void delete(int key) throws SQLException; 
    /** Возвращает список объектов соответствующих всем записям в базе данных */ 
    public List<DeviceModel> getAll() throws SQLException;
    public int count() throws SQLException;

}
