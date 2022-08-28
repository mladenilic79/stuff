package b_objectoriented;

public enum EnumObjectClass {
	
	// list of constant objects (instance fields?)
    bucky("nice", "22"),
    kelsey("cutie", "10"),
    julie("bigmistake", "12"),
    candy("different", "14"),
    erin("iwish", "16"),
	nicole("italian", "13");

	// variables that represents arguments inside objects
    private final String desc;
    private final String year;

    // constructor for enumerate objects using previously defined arguments
    EnumObjectClass(String description, String birthday) {
        desc = description;
        year = birthday;
    }

    // getters for previously defined arguments
    public String getDesc() {
        return desc;
    }
    public String getYear() {
        return year;
    }
    
}
