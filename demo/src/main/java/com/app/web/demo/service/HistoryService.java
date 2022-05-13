package com.app.web.demo.service;
import java.util.List;
import com.app.web.demo.entity.History;

public interface HistoryService {
    public List<History> allList();
    public List<History> getListHighway(int id);
    public List<History> getListTrafficPolice(long id);
    public History saveHistory(History history);
}
