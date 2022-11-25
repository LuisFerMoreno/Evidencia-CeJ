package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
public class paciente {
    String idPaciente;
    String nomCompleto;
    public void leerDatosPaciente() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("C:/Users/luisf/IdeaProjects/Evifinal/src/main/java/org/example/pacientes.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray) jsonObject.get("Pacientes");
        for (int i = 0; i<jsonArray.size();i++){
            JSONObject obj1 = (JSONObject) jsonArray.get(i);
            idPaciente = (String) obj1.get("Id paciente");
            nomCompleto = (String) obj1.get("Nombre del paciente");
        }
    }
}
