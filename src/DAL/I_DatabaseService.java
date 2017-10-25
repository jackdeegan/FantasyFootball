package DAL;

import java.util.List;

public interface I_DatabaseService {
    public List<String> getData();
    public void changeData(int info);
    public void deleteData(String[] info);
    public void addData(String info);
}