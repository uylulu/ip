package duke;  //same package as the class being tested

import org.junit.jupiter.api.Test;

import uy.ToDos;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ToDosTest {
    @Test
    public void testToDoCreation() {
        ToDos todo = new ToDos("Read book");
        assertEquals(todo.toString(), "[T][] Read book");
    }
}
