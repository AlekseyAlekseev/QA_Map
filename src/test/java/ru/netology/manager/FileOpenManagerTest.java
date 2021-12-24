package ru.netology.manager;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

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
    void shouldGetProgramUpperCase() {
        manager.addNewProgram(".html", "Google Chrome");
        manager.addNewProgram(".jpg", "FotoView");

        String expected = "Google Chrome";
        String actual = manager.getProgram(".HTML");

        assertEquals(expected, actual);
    }

    @Test
    void shouldGetInvalidProgram() {
        manager.addNewProgram(".html", "Google Chrome");

        assertThrows(RuntimeException.class, () -> {
            manager.getProgram(".JPGA");
        });
    }

    @Test
    void shouldDeleteProgram() {
        manager.addNewProgram(".jpg", "FotoView");

        manager.deleteProgram(".jpg");

        assertEquals(0, manager.getPrograms().size());
    }

    @Test
    void shouldDeleteInvalidProgram() {
        manager.addNewProgram(".jpg", "FotoView");

        assertThrows(RuntimeException.class, () -> {
            manager.deleteProgram(".html");
        });
    }

    @Test
    void shouldGetAllExtension() {
        manager.addNewProgram(".html", "Google Chrome");
        manager.addNewProgram(".jpg", "FotoView");
        manager.addNewProgram(".txt", "Notepad++");
        manager.addNewProgram(".png", "FotoView");

        HashSet<String> expected = new HashSet<>(List.of(".html", ".jpg", ".txt", ".png"));
        HashSet<String> actual = manager.getAllExtension();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    void shouldGetAllProgram() {
        manager.addNewProgram(".html", "Google Chrome");
        manager.addNewProgram(".jpg", "FotoView");
        manager.addNewProgram(".txt", "Notepad++");
        manager.addNewProgram(".dat", "Notepad++");

        HashSet<String> expected = new HashSet<>(List.of("Google Chrome", "FotoView", "Notepad++"));
        HashSet<String> actual = manager.getAllProgram();

        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}