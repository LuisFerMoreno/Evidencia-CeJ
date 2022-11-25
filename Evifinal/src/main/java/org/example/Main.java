package org.example;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;



public class Main {
    static paciente paciente = new paciente();
    static cita cita = new cita();
    static doctor doctor = new doctor();

    public static void main(String[] args) throws IOException, ParseException {
        Scanner scan = new Scanner(System.in);
        paciente.leerDatosPaciente();
        cita.leerDatosCita();
        doctor.leerDatosDoc();
        String x, tipoUsuario = null, result1, motivo, hora, fecha;
        String result;
        int idPaciente, idCita, idDoctor;
        System.out.println("¿Usted ya se encuentra registrado?");
        x = scan.nextLine();
        if (x.equals("Si")){
            System.out.println("¿Qué tipo de usuario es usted?");
            tipoUsuario = scan.nextLine();
            if (tipoUsuario.equals("Paciente")){

                System.out.println("Por favor ingrese su id de paciente");
                idPaciente = scan.nextInt();

                if (idPaciente == Integer.parseInt(paciente.idPaciente)){
                    System.out.println("Bienvenido "+ paciente.nomCompleto);
                }else {
                    System.out.println("Sus datos no están disponibles");
                    System.exit(1);
                }
                scan.nextLine();
                System.out.println("¿Cuenta con una cita?");
                result = scan.nextLine();


                if (result.equals("Si")){

                    System.out.println("Por favor ingrese la id de su cita");
                    idCita = scan.nextInt();

                    if (idCita == Integer.parseInt(cita.idCita)){

                        System.out.println("Su cita contiene los siguientes datos");
                        System.out.println("Fecha: "+cita.fecha+" Hora: "+cita.hora);
                        System.out.println("El motivo de su cita es: "+cita.motivo);
                        if (Integer.parseInt(cita.idDoctor) == Integer.parseInt(doctor.idDoctor)){
                            System.out.println("Con el doctor: "+ doctor.nomCompleto);
                            System.out.println("Con la especialidad en: "+ doctor.especialidad);
                        }
                    }
                }else if (result.equals("No")){
                    System.out.println("¿Desea crear una?");
                    result1 = scan.nextLine();
                    if (result1.equals("Si")){
                        System.out.println("Por favor ingrese la fecha de su cita en el siguiente formato DD/MM/AA");
                        fecha = scan.nextLine();
                        System.out.println("Por favor ingrese la hora de su cita");
                        hora = scan.nextLine();
                        System.out.println("Para finalizar, por favor ingrese el motivo de su cita");
                        motivo = scan.nextLine();

                        int numCita;
                        numCita = Integer.parseInt(cita.idCita);
                        numCita++;
                        cita.idCita = String.valueOf(numCita);
                        cita.fecha = fecha;
                        cita.hora = hora;
                        cita.motivo = motivo;

                        cita.escribirDatos();
                    }
                }
            }
            if (tipoUsuario.equals("Doctor")) {

                System.out.println("Por favor ingrese su id de doctor");
                idDoctor = scan.nextInt();
                if (idDoctor == Integer.parseInt(doctor.idDoctor)){
                    System.out.println("Bienvenido doctor "+ doctor.nomCompleto);
                    scan.nextLine();
                    System.out.println("¿Usted cuenta con una cita?");
                    result1 = scan.nextLine();
                    if (result1.equals("Si")){
                        System.out.println("Por favor digite el id de la cita");
                        idCita = scan.nextInt();
                        if (idCita == Integer.parseInt(cita.idCita)){
                            System.out.println("Su cita es el "+cita.fecha+" a las "+cita.hora);
                            System.out.println("Con el siguiente motivo: "+cita.motivo);
                            if (Integer.parseInt(paciente.idPaciente) == Integer.parseInt(cita.idPaciente)){
                                System.out.println("Con el paciente: "+ paciente.nomCompleto);
                            }
                        }
                    }
                }
            }
        }
    }
}