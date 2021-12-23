package ru.netology.manager;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileOpenManagerTest {

    private FileOpenManager manager = new FileOpenManager();


    @Test
    void shouldAddProgram() {
        manager.addNewProgram(".html", "Google Chrome");
        manager.addNewProgram(".jpg", "FotoView");

        assertEquals(2, manager.getPrograms().size());
    }

    @Test
    void shouldAddInvalidProgram() {
        manager.addNewProgram(".html", "Google Chrome");
        manager.addNewProgram(".jpg", "FotoView");

        assertThrows(RuntimeException.class, () -> {
            manager.addNewProgram(".jpg", "FotoView");
        });
    }

    @Test
    void shouldGetProgram() {
        manager.addNewProgram(".html", "Google Chrome");
        manager.addNewProgram(".jpg", "FotoView");

        String expected = "Google Chrome";
        String actual = manager.getProgram(".html");

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetInvalidProgram() {
        manager.addNewProgram(".html", "Google Chrome");

        assertThrows(RuntimeException.class, () -> {
            manager.getProgram(".JPGA");
        });
    }

}