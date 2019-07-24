package by.bsu.first.manager;

import java.util.ResourceBundle;
public class PropertyManager {
    private  ResourceBundle resourceBundle;
    // класс извлекает информацию из файла
    public PropertyManager(String path, String filename) {
        resourceBundle = ResourceBundle.getBundle(path +"."+filename);
    }
    public String getProperty(String key) {
        return resourceBundle.getString(key);
    }
}
