import junio2020Regiones.*;

import java.util.Map;
import java.util.Set;

public class MainRegiones {

	public static void main(String[] args) {
		Pais p=Pais.creaPais("regiones.txt");
		p.presenta();
		p.presenta("salida.txt");
		Map<Double,Set<Provincia>> porAltura=p.provinciasPorAltura();
		for(Double d:porAltura.keySet()) {
			System.out.println(d);
			for(Provincia pr:porAltura.get(d)) {
				System.out.println("\t"+pr.getNombre());
			}
		}
		
	}

}
