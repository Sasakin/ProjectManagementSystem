package project.dao;

import java.util.List;

/**
 * Created by Student on 19.11.2016.
 */
public interface AbstructDao {
    public void add(Object object);
    public void update(Object object);
    public void remove(int id);
    public void getById(int id);
    public List<Object> getList();
}
