package b_objectoriented;

// can be stored inside other class for convenience
public enum EnumSimpleClass {

	// list of constants
	PENDING, ACTIVE, INACTIVE, DELETED;

	// enum to string
	public String toString() {
		switch (this) {
		case ACTIVE:
			return "Guitar";
		case DELETED:
			return "Banjo";
		case INACTIVE:
			return "Dobro";
		case PENDING:
			return "Fiddle";
		default:
			return "Unspecified";
		}
	}

}
