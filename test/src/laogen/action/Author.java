package laogen.action;

public class Author {
	private long AuthorID;
	private String Name;
	private long Age;
	private String Country;
	
	public void setAuthorID(long temp){
		AuthorID=temp;
	}
	public long getAuthorID(){
		return AuthorID;
	}
	public void setName(String temp){
		Name=temp;
	}
	public String getName(){
		return Name;
	}
	public void setAge(long temp){
		Age=temp;
	}
	public long getAge(){
		return Age;
	}
	public void setCountry(String temp){
		Country=temp;
	}
	public String getCountry(){
		return Country;
	}
}
