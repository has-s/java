import java.io.*;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVParser;
import com.opencsv.exceptions.CsvException;

import java.util.ArrayList;
import java.util.List;


/**
 * Класс, отвечающий за чтение данных из CSV файла и создание списка людей.
 * CSV файл содержит информацию о людях, их личных данных и отделах.
 * Данный класс использует библиотеку OpenCSV для обработки CSV данных.
 */
public class Main {
    public static void main(String[] args){
        String csvFilePath = "src/main/resources/foreign_names.csv";

        List<Person> peopleList = new ArrayList<>();

        CSVParser csvParser = new CSVParserBuilder().withSeparator(';').build();
        try(CSVReader reader = new CSVReaderBuilder(
                new FileReader(csvFilePath))
                .withCSVParser(csvParser)
                .withSkipLines(1) // пропускаем первую строку, где хранится информация о записях
                .build())
        {
            // Считываем все записи из scv-файла
            List<String[]> records = reader.readAll();

            // Генерируем id подразделения
            int departmentIdCounter = 1;

            // Iterate through each record and create Person objects
            for (String[] record : records) {
                // Извлекаем данные из записи
                int id = Integer.parseInt(record[0]);
                String name = record[1];
                String gender = record[2];
                String birthDate = record[3];
                String departmentName = record[4];
                double salary = Double.parseDouble(record[5]);

                // Создаем объект типа Department
                Department department = new Department(departmentIdCounter++, departmentName);

                // Создаем объект типа Person и добавляем его в список
                Person person = new Person(id, name, gender, department, salary, birthDate);
                peopleList.add(person);
            }


        } catch (IOException | CsvException e) {
            e.printStackTrace();
        }

        for (Person person : peopleList)
            System.out.println(person);
    }
}