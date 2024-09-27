package telran.interview;

import java.util.*;
import java.util.NoSuchElementException;

public class ConnectionPool extends LinkedHashMap<String, Connection> {
    int size;

    public ConnectionPool(int size) {
        this.size = size;
    }

    public void addConnection(Connection connection) {
        if (this.keySet().contains(connection.connectionID())) {
            throw new IllegalStateException();
        }
        this.put(connection.connectionID(), connection);
    }

    public Connection getConnection(String connectionID) {
        if (!this.keySet().contains(connectionID)) {
            throw new NoSuchElementException();
        }
        return this.get(connectionID);
    }
}
