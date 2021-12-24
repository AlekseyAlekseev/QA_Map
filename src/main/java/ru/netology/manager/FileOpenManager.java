package ru.netology.manager;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileOpenManager {

    private HashMap<String, String> programs = new HashMap<>();


    /**
     * Добавляет новое приложение
     * @param extension расширение файлов
     * @param name название ПО
     */
    public void addNewProgram(String extension, String name) {
        if (!programs.containsKey(extension)) {
            programs.put(extension.toLowerCase(), name);
        } else {
            throw new RuntimeException("ПО для работы с этим расширением уже есть в списке");
        }
    }


    /**
     * Возвращает название приложения, предназначенного для открытия файла с определённым расширением
     * @param extension расширение файла
     * @return возвращается название приложения
     */
    public String getProgram(String extension) {
        if (programs.containsKey(extension.toLowerCase())) {
            return programs.get(extension.toLowerCase());
        } else {
            throw new RuntimeException("Нету программы работающей с таким расширением");
        }
    }

    /**
     * Удаляет привязку приложения к определённому расширению
     * @param extension расширение файла
     */
    public void deleteProgram(String extension) {
        if (programs.containsKey(extension.toLowerCase())) {
            programs.remove(extension.toLowerCase());
        } else {
            throw new RuntimeException("Нету программы работающей с таким расширением");
        }
    }

    /**
     * @return Возвращает список всех зарегистрированных расширений
     */
    public HashSet<String> getAllExtension() {
        HashSet<String> listExtension = new HashSet<>();
        for (Map.Entry<String, String> entry : programs.entrySet()) {
            listExtension.add(entry.getKey());
        }
        return listExtension;
    }

    /**
     * @return Возвращает список всех зарегистрированных приложений
     */
    public HashSet<String> getAllProgram() {
        HashSet<String> listProgram = new HashSet<>();
        for (Map.Entry<String, String> entry : programs.entrySet()) {
            listProgram.add(entry.getValue());
        }
        return listProgram;
    }












}
