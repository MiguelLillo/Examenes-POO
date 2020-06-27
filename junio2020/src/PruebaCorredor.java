import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import septiembre2018Competicion.CompeticionException;
import septiembre2018Competicion.Corredor;
public class PruebaCorredor {

	public static void main(String[] args) {
		try {
			Corredor corredor1=new Corredor("Mar Diaz",1,7480,"mujer");
			Corredor corredor2=new Corredor("MAR DIAZ",1,7480,"Mujer");
			Corredor corredor3=new Corredor("Elena Isla",1,7890,"Mujer");
			corredor3.setMarca(8500);
			System.out.println("Corredor 1= "+corredor1);
			System.out.println("Corredor 2= "+corredor2);
			System.out.println("Corredor 3= "+corredor3);
			if(corredor1.equals(corredor2)) {
				System.out.println("Los corredores 1 y 2 son iguales");
			}
			Set<Corredor> c=new TreeSet<>();
			c.add(corredor1);
			c.add(corredor2);
			c.add(corredor3);
			Iterator<Corredor> it=c.iterator();
			System.out.print("Contenido del conjunto:\n[");
			while(it.hasNext()) {
				System.out.print(it.next());
				if(it.hasNext()) {
					System.out.print(", ");
				}
			}
			System.out.print("]");
			
			
			
			
		}catch(CompeticionException e) {
			System.out.println(e.getMessage());
		}
	}

}
