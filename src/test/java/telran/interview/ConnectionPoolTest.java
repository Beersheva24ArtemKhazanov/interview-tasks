package telran.interview;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConnectionPoolTest {
    // TODO
    // Tests should contain reflecting your understanding what should be done
    String[] connectionKeys = { "lm", "yt", "fe", "df", "ds" };
    Connection[] connectionArray = Arrays.stream(connectionKeys).map(Connection::new).toArray(Connection[]::new);
    ConnectionPool connectionPool;

    @BeforeEach
    public void setUpConnetionPool() {
        connectionPool = new ConnectionPool(5);
        Arrays.stream(connectionArray).forEach(connectionPool::addConnection);
    }

    @Test
    void setUpConnetionPoolTest() {
        assertArrayEquals(connectionKeys, connectionPool.getMap().keySet().toArray(String[]::new));
    }

    @Test
    void addConnectionTest() {
        String[] expected = { "yt", "fe", "df", "ds", "bh" };
        Connection connection = new Connection("bh");
        connectionPool.addConnection(connection);
        assertArrayEquals(expected, connectionPool.getMap().keySet().toArray(String[]::new));
        assertThrowsExactly(IllegalStateException.class, () -> connectionPool.addConnection(connection));
    }

    @Test
    void getConnectionTest() {
        Connection expected = connectionArray[0];
        assertEquals(expected, connectionPool.getConnection("lm"));
        assertThrowsExactly(NoSuchElementException.class, () -> connectionPool.getConnection("cx"));
    }
}
