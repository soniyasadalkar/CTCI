class CustomObject{
	String name;
	int age;
	String surname;

	CustomObject(String name, String surname, int age){
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	@Override
	public boolean equals(Object o){
		if( this == o) return true;
		if(!(o instanceof CustomObject)) return false;

		CustomObject c = (CustomObject) o;
		return c.age == age && c.name.equals(name) && c.surname.equals(surname);	
	}

	@Override 
	public int hashCode(){
		int result = 17;
		result = 31 * result + name.hashCode();
		result = 31 * result + age;
		result = 31 * result + surname.hashCode();

		return result;
	}

	public static void main(String[] args){
		CustomObject c1 = new CustomObject("soniya", "sadalkar", 25);
		CustomObject c2 = new CustomObject("soniya", "sadalkar", 25);
		CustomObject c3 = new CustomObject("Soniya", "Sadalkar", 25);

		System.out.println(c1.equals(c1));
		System.out.println(c1.equals(c2));
		System.out.println(c1.equals(c3));
	}

}
