package me.rishabhvenu.aseplugin.database.mysql;

import com.google.common.collect.Maps;
import java.util.Map;

public class Table {
    private final String name;

    private final Map<String, Map<DataType, String[]>> columns;

    public Table(String name) {
        this.name = name;
        this.columns = Maps.newHashMap();
    }

    public Table addColumn(String column, DataType type, String... params) {
        Map<DataType, String[]> data = Maps.newHashMap();
        data.put(type, params);
        this.columns.put(column, data);
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Map<DataType, String[]>> getColumns() {
        return this.columns;
    }
}
