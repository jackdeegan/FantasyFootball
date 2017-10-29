package DAL;

import java.util.*;

public interface I_DatabaseService {
    public List<String> getData();
    public String[] getRowData(int id);
    public void addData(String info);
    public void changeData(String changedRow);
    public void deleteData(int id);
}
