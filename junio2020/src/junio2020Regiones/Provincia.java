package junio2020Regiones;

public class Provincia {
	private String nombre;
	private String region;
	private double alturaMedia;

	public Provincia(String nom, String reg, double alt) {
		if (alt <= 0 || nom.equals("") || nom == null || reg.equals("") || reg == null) {
			throw new IllegalArgumentException();
		}
		nombre = nom;
		region = reg;
		alturaMedia = alt;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public double getAlturaMedia() {
		return alturaMedia;
	}

	public void setAlturaMedia(double alturaMedia) {
		this.alturaMedia = alturaMedia;
	}

	@Override
	public int hashCode() {
		return nombre.hashCode() + region.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		boolean res = false;

		if (o instanceof Provincia) {
			Provincia p = (Provincia) o;
			res = p.region.equalsIgnoreCase(this.region) && p.nombre.equalsIgnoreCase(this.nombre);
		}
		return res;
	}
	public int compareTo(Provincia p) {
		return this.nombre.compareToIgnoreCase(p.nombre);		
	}
	

}
