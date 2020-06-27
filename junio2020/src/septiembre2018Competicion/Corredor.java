package septiembre2018Competicion;

public class Corredor implements Comparable<Corredor> {
	private String nombre;
	private int categoria;
	private int marca;
	private String genero;

	public Corredor(String nom, int cat, int m, String gen) {
		if (cat < 1 || cat > 5) {
			throw new CompeticionException("Categoria incorrecta");
		}
		if (m < 0) {
			throw new CompeticionException("Marca menor que 0");
		}
		if (!gen.equalsIgnoreCase("varon") && !gen.equalsIgnoreCase("mujer")) {
			throw new CompeticionException("Genero incorrecto");
		}
		nombre = nom;
		categoria = cat;
		marca = m;
		genero = gen;
	}

	public Corredor(String nom, String genero) {
		this(nom, 1, 0, genero);
	}

	public String getNombre() {
		return nombre;
	}

	public int getCategoria() {
		return categoria;
	}

	public int getMarca() {
		return marca;
	}

	public String getGenero() {
		return genero;
	}

	public void setCategoria(int cat) {
		if (cat < 1 || cat > 5) {
			throw new CompeticionException("Categoria incorrecta");
		}
		this.categoria = cat;
	}

	public void setMarca(int m) {
		if (m < 0) {
			throw new CompeticionException("Marca menor que 0");
		}
		this.marca = m;
	}

	public String toString() {
		return nombre + ":" + genero + ":" + categoria + ":" + marca;
	}

	public boolean equals(Object o) {
		boolean res = false;
		if (o instanceof Corredor) {
			Corredor c = (Corredor) o;
			res = this.nombre.equalsIgnoreCase(c.getNombre()) && this.categoria == c.getCategoria()
					&& this.marca == c.getMarca();
		}
		return res;
	}

	@Override
	public int hashCode() {
		return nombre.hashCode() + marca * categoria;
	}

	public int compareTo(Corredor c) {
		int res = categoria - c.getCategoria();
		if (res == 0) {
			res = -(marca - c.getMarca());
			if (res == 0) {
				res = nombre.compareToIgnoreCase(c.getNombre());
			}
		}

		return res;
	}
}
