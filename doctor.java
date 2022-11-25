package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class doctor {
    String idDoctor;
    String nomCompleto, especialidad;

    public void leerDatosDoc() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("C:/Users/luisf/IdeaProjects/Evifinal/src/main/java/org/example/doctores.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray) jsonObject.get("Doctor");
        for (int i = 0; i<jsonArray.size();i++){
            JSONObject obj1 = (JSONObject) jsonArray.get(i);
            idDoctor = (String) obj1.get("Id doctor");
            nomCompleto = (String) obj1.get("Nombre");
            especialidad = (String) obj1.get("Especialidad");
        }
    }

}
