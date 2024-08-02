package org.juannn;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        save();
        read();
    }

    /**
     * Reads JSON data from a file named "person.json" and prints its contents.
     */
    private static void read() {

        JSONParser jsonParser = new JSONParser();

        try (FileReader fileReader = new FileReader("person.json")) {
            // Parses the JSON file and converts it to a JSONArray object
            Object obj = jsonParser.parse(fileReader);

            JSONArray persons = (JSONArray) obj;

            // Prints the contents of the file
            System.out.println("File content:" + persons);

        } catch (FileNotFoundException e) {
            System.err.println("File not found: person.json");
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("Error reading file: person.json");
            e.printStackTrace();
        } catch (ParseException e) {
            System.err.println("Error parsing JSON content.");
            e.printStackTrace();
        }
    }

    /**
     * Saves JSON data to a file named "person.json".
     */
    private static void save() {
        // Creates the first person JSON object
        JSONObject person = new JSONObject();
        person.put("Name", "Juan");
        person.put("Second name", "Diaz");
        person.put("Age", "18");

        // Creates a JSON array of contacts
        JSONArray contacts = new JSONArray();
        contacts.add("contact 1");
        contacts.add("contact 2");
        contacts.add("contact 3");
        contacts.add("contact 4");
        contacts.add("contact 5");

        person.put("contacts", contacts);

        // Creates the second person JSON object
        JSONObject person2 = new JSONObject();
        person2.put("Name", "Rafa");
        person2.put("Second name", "Diaz");
        person2.put("Age", "14");
        person2.put("contacts", contacts);

        // Creates a JSON array to hold both person objects
        JSONArray persons = new JSONArray();
        persons.add(person);
        persons.add(person2);

        // Writes the JSON array to a file named "person.json"
        try (FileWriter fileWriter = new FileWriter("person.json")) {
            System.out.println("Saved person");
            fileWriter.write(persons.toJSONString());
            fileWriter.flush();

        } catch (IOException e) {
            System.err.println("Error writing to file: person.json");
            e.printStackTrace();
        }
    }
}
