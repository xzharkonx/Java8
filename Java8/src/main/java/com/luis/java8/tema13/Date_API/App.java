package com.luis.java8.tema13.Date_API;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class App {

	public void verificar (int version) {
		// Va a verificar 2 fechas, si una está antes o despues de la otra.
		if (version == 7) {
			Calendar fecha1 = Calendar.getInstance();
			Calendar fecha2 = Calendar.getInstance();
			// Aquí empieza el mes desde el 0 como un array
			fecha1.set(1991, 0, 21);
			System.out.println(fecha1.after(fecha2));
			
		} else if (version == 8) {
			
			// FECHA.
			
			// En la version 1.8 esto a mejorado.
			// Aquí vemos que empieza desde el més 1
			LocalDate fecha1 = LocalDate.of(1991, 01, 21);
			// Colocamos que sea este instante de tiempo.
			LocalDate fecha2 = LocalDate.now();
			
			// Si queremos verificar si una está despues o antes de otra.
			System.out.println(fecha1.isAfter(fecha2));
			System.out.println(fecha1.isBefore(fecha2));
			
			// TIEMPO.
			
			// Así como hemos trabajado con LocalDate podemos trabajar con tiempos
			// esto lo haremos con LocalTime.
			
			// Si una hora esta antes o despues de la otra.
			
			// En esta ocación depende de horas en formato de 24
			// Las 22 hrs, con 30 min y 50 seg.
			LocalTime tiempo1 = LocalTime.of(22, 20, 50);
			LocalTime tiempo2 = LocalTime.now();
			
			System.out.println(tiempo1.isAfter(tiempo2));
			System.out.println(tiempo1.isBefore(tiempo2));
			
			// FECHA Y TIEMPO.
			
			// Si nosotros queremos mezclar la fecha y el tiempo va a ser muy simple
			// también utilizando LocalDateTime.
			
			LocalDateTime fechaTiempo1 = LocalDateTime.of(1991, 1, 21, 22, 20, 50);
			LocalDateTime fechaTiempo2 = LocalDateTime.now();
			
			System.out.println(fechaTiempo1.isAfter(fechaTiempo2));
			System.out.println(fechaTiempo1.isBefore(fechaTiempo2));
			
		}
	}
	
	// currentTimeMillis / Medir el tiempo.
	public void medirTiempo(int version) throws InterruptedException {
		// Mediremos el tiempo que toma hacer algo.
		
		if (version == 7) {
			long ini = System.currentTimeMillis();
			Thread.sleep(1000);
			long fin = System.currentTimeMillis();
			System.out.println(fin - ini);
		} else if (version == 8){
			// En esta versión 1.8 va avariar un poco para que sea más amigable.
			Instant ini = Instant.now();
			Thread.sleep(1000);
			Instant fin = Instant.now();
			
			// La diferiencia sería un periodo de tiempo.
			System.out.println(Duration.between(ini, fin));
			
			// Esta diferiencia podemos convertirla a horas minutos y segundos.
			// System.out.println(Duration.between(ini, fin).toDays());
			// System.out.println(Duration.between(ini, fin).toHours());
			// System.out.println(Duration.between(ini, fin).toMinutes());
			System.out.println(Duration.between(ini, fin).toMillis()); // Convertimos a milisegundos.
		}
	}
	
	// Calendar, comparación del tiempo que hay entre 2 fechas.
	public void periodoEntreFechas(int version) {
		// Para calcular cuantos años, días o minutos puede haber
		// entre una fecha y otra.
		if (version == 7) {
			// Aquí tenemos que tener 2 Calendar
			Calendar nacimiento = Calendar.getInstance();
			Calendar actual = Calendar.getInstance();
			
			// Indicamos los valores.
			nacimiento.set(1993, 0, 16);
			actual.set(2020, 11, 12);
			
			// Para contar los años
			int anios = 0;
			
			while(nacimiento.before(actual)) {
				nacimiento.add(Calendar.YEAR, 1);
				if(nacimiento.before(actual)) {
					anios++;
				}
			}
			
			// Mostramos los años.
			System.out.println(anios);
			
		} else if(version == 8) {
			// Nos apoyamos de nuevo en nuestra Clase LocalDate
			LocalDate nacimiento = LocalDate.of(1993, 1, 16);
			LocalDate actual = LocalDate.now();
			
			// Como hacemos la diferiencia entre uno y otro.
			// Nos apoyamos de una Clase llamada Period.
			// Pero este método devuelve un tipo de dato Period.
			Period periodo = Period.between(nacimiento, actual);
			// Mostramos los tiempos

			System.out.println("Han transcurrido " + periodo.getYears() + " años y " + periodo.getMonths() + " meses y "
				+ periodo.getDays() + " días, desde " + nacimiento + " hasta " + actual);
			
		}
	}
	
	// Conversión
	public void convertir(int version) throws ParseException{
		// Mayormente cuando tenemos en la JDK 1.7 datos de tipo fecha pero
		// en String, teníamos que apoyarnos en un formateador mayormente en un
		// SimpleDateFormat, haciamos el método parse o el método format
		if (version == 7) {
			
			// Método parse, para obtener un Date a partir de un String.
			String fecha = "21/01/1991";
			DateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
			Date fechaConvertida = formateador.parse(fecha);
			System.out.println(fechaConvertida);
			
			// Método format, para obtener a partir de un Date, un String con un formato en particular.
			Date fechaActual = Calendar.getInstance().getTime();
			formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss a");
			String fechaCadena = formateador.format(fechaActual);
			System.out.println(fechaCadena);
			
		} else if (version == 8){
			// Aquí podemos apoyarnos de las Clases DateTime, LocalTime o DateTimeFormatter
			
			String fecha = "16/01/1993";
			// Necesito que a travez de esa cadena de texto obtenga un valor LocalDate
			// Así convertiremos la fecha. Si lo hacemos así nos dará error, para ello nos apoyamos
			// de un formateador. E indicamos el patrón.
			DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			// Y le pasamos el formateador.
			LocalDate fechaLocal = LocalDate.parse(fecha, formateador);
			System.out.println(fechaLocal);
			
			// Pero si yo quiero imprimirlo en el formato inicial haría lo siguiente.
			System.out.println(formateador.format(fechaLocal));
			
			// También lo podríamos hacer de forma corrida, ya dependerá nuestro gusto.
			// Declaro una nueva instancia del formateador 
			formateador = DateTimeFormatter.ofPattern("ddMMyyyy");
			System.out.println(formateador.format(fechaLocal));
		}
	}
	
	public static void main(String[] args) {
		App app = new App();
		
		try {
			
			// Va a verificar 2 fechas, si una está antes o despues de la otra.
			// app.verificar(8);
			
			// Vemos la nueva forma de medir los tiempos.
			// Vemos que sale PT (Convensión que utiliza la Clase Instant) 1s de Un Segundo.
			// app.medirTiempo(8);
			
			// Calendar, comparación del tiempo que hay entre 2 fechas.
			// app.periodoEntreFechas(8);
			
			// Conversión.
			// Método parse, para obtener un Date a partir de un String.
			// Método format, para obtener a partir de un Date, un String con un formato en particular.
			// JDK 1.8, podríamos modificar el formato en que mostramos la fecha.
			app.convertir(8);
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
