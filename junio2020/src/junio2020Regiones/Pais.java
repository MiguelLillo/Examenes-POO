package junio2020Regiones;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Pais {
	private Map<String, HashSet<Provincia>> provincias;

	protected Pais() {
		provincias = new HashMap<>();
	}

	public static Pais creaPais(String fich) {
		File f = new File(fich);
		Pais p = new Pais();
		while (!f.canRead()) {
			try{
				System.out.println("No se puede leer");
				Thread.sleep(500);
			}catch(InterruptedException e) {
				
			}
		}
		try (Scanner sc = new Scanner(f)) {
			sc.useDelimiter("[, ]");
			while (sc.hasNextLine()) {
				String linea = sc.nextLine();
				String[] info = linea.split(",");
				Provincia pr = new Provincia(info[0], info[1], Double.parseDouble(info[2]));
				if (p.provincias.containsKey(info[1])) {
					p.provincias.get(info[1]).add(pr);
				} else {
					HashSet<Provincia> c = new HashSet<>();
					c.add(pr);
					p.provincias.put(info[1], c);
				}

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return p;
	}

	public String[] getRegiones() {
		Set<String> c = provincias.keySet();
		String[] res = (String[]) c.toArray();
		return res;
	}

	public Set<Provincia> getProvincias() {
		Set<Provincia> c = new HashSet<>();
		for (String s : provincias.keySet()) {
			c.addAll(provincias.get(s));
		}
		return c;
	}

	public Map<Double, Set<Provincia>> provinciasPorAltura() {
		// TODO
		Map<Double, Set<Provincia>> res = new HashMap<>();
		for (String s : provincias.keySet()) {

			for (Provincia p : provincias.get(s)) {
				String sValue = (String) String.format("%.1f", p.getAlturaMedia());
				Double newValue = Double.parseDouble(sValue.replace(",", "."));

				if (res.containsKey(newValue)) {
					res.get(newValue).add(p);
				} else {
					Set<Provincia> c = new HashSet<>();
					c.add(p);
					res.put(newValue, c);
				}
			}
		}

		return res;
	}

	private Double media(Set<Provincia> s) {
		double suma = 0;
		for (Provincia p : s) {
			suma += p.getAlturaMedia();
		}
		return suma / s.size();
	}

	public Map<String, Double> mediasPorRegion() {
		HashMap<String, Double> res = new HashMap<>();
		for (String s : provincias.keySet()) {
			res.put(s, media(provincias.get(s)));
		}
		return res;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("");
		Map<String, Double> medias = mediasPorRegion();
		for (String s : provincias.keySet()) {
			sb.append(s + "->" + medias.get(s) + "\n");
			for (Provincia p : provincias.get(s)) {
				sb.append("\t" + p.getNombre() + "->" + p.getAlturaMedia() + "\n");
			}
		}
		return sb.toString();
	}

	public void presenta() {
		System.out.println(this);
	}

	public void presenta(String fich) {
		try {
			PrintWriter pw = new PrintWriter(new File(fich));
			pw.append(this.toString());
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
