package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class cita {
    String idCita, idPaciente, idDoctor;
    String fecha = "11/11/2022", hora="9:30", motivo="Tos aguda";



    public void leerDatosCita() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        Object obj = parser.parse(new FileReader("C:/Users/luisf/IdeaProjects/Evifinal/src/main/java/org/example/citas.json"));
        JSONObject jsonObject = (JSONObject) obj;
        JSONArray jsonArray = (JSONArray) jsonObject.get("Citas");
        for (int i = 0; i<jsonArray.size();i++){
            JSONObject obj1 = (JSONObject) jsonArray.get(i);
            idCita = (String) obj1.get("Id Cita");
            idPaciente = (String) obj1.get("Id paciente");
            idDoctor = (String) obj1.get("Id doctor");
            fecha = (String) obj1.get("Fecha");
            hora = (String) obj1.get("Hora");
            motivo = (String) obj1.get("Motivo");
        }
    }

    public void escribirDatos() throws IOException, ParseException {
        JSONObject cita2 = new JSONObject();
        cita2.put("Id Cita",idCita);
        cita2.put("Id Paciente",idPaciente);
        cita2.put("Id Doctor",idDoctor);
        cita2.put("Fecha",fecha);
        cita2.put("Hora",hora);
        cita2.put("Motivo",motivo);

        JSONArray lista = new JSONArray();
        lista.add(cita2);

        System.out.println("Su cita es la número "+ idCita);
        System.out.println("Fecha: "+ fecha+" Hora: "+hora);
        System.out.println("El motivo es "+ motivo);

        try (FileWriter archivo = new FileWriter("C:/Users/luisf/IdeaProjects/Evifinal/src/main/java/org/example/citas.json",true)){
            archivo.write(lista.toJSONString());
            archivo.flush();
        }
    }
}
