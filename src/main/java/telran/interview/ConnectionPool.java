package telran.interview;

import java.util.*;

public class ConnectionPool extends LinkedHashMap<String, Connection> {
    int size;
    LinkedHashMap<String, Connection> map;

    public ConnectionPool(int size) {
        this.size = size;
        map = new LinkedHashMap<String, Connection>(10, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Connection> eldestEntry) {
                return size() > size;
            }
        };
    }

    public int getSize() {
        return size;
    }

    public LinkedHashMap<String, Connection> getMap() {
        return map;
    }

    public void addConnection(Connection connection) {
        if (map.containsValue(connection)) {
            throw new IllegalStateException();
        }
        map.putIfAbsent(connection.connectionID(), connection);
    }

    public Connection getConnection(String connectionID) {
        if (!map.containsKey(connectionID)) {
            throw new NoSuchElementException();
        }
        return map.get(connectionID);
    }
}
