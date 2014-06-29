
import java.util.Arrays;
import java.util.Comparator;

/*This class does sorting based on multi keys 
 */
class Employee{

	public String extension;
	public String surname;
	public String givenname;
	//For making a sort stable
	public int Sequence;
	public String getExtension() {
		return extension;
	}
	public String getSurname() {
		return surname;
	}
	public String getGivenname() {
		return givenname;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public void setGivenname(String givenname) {
		this.givenname = givenname;
	}

}
public class MultiKeySort implements Comparator<Employee> {
	public int compare(Employee e1,Employee e2){
		/*
		 * Make shaky sort stable
		 */
		int ret = e1.surname.compareToIgnoreCase(e2.surname);
		
		if(ret == 0){
			//Making shakySort stable
			ret = e1.Sequence-e2.Sequence;
			//MultiKey Sorting
			//ret = e1.givenname.compareToIgnoreCase(e2.givenname);
		}
		return ret;
	}

	public void  shakySort(Employee []employees){
		Arrays.sort(employees, new MultiKeySort());
	}

	public static void main(String[] args) {
		Employee e1 = new Employee();
		e1.setExtension("4082102862");
		e1.setSurname ( "Khatri");
		e1.setGivenname ("Shweta");
		Employee e2 = new Employee();
		e2.setExtension("9176005520");
		e2.setSurname ( "Dahiya");
		e2.setGivenname ("Manav");
		Employee e3 = new Employee();
		e3.setExtension( "9215197088");
		e3.setSurname ( "Khatri");
		e3.setGivenname ("Renu");
		Employee employee[] = {e1,e2,e3};
		System.out.println("Employee details before Sorting");
		for(int i = 0 ; i < employee.length ; i ++){
			employee[i].Sequence =i;
			System.out.println("Extension:"+employee[i].getExtension()+",Surname:"+employee[i].getSurname()+",GivenName:"+employee[i].getGivenname());
		}
		MultiKeySort obj = new MultiKeySort();
		obj.shakySort(employee);
		System.out.println("Employee details after sorting");
		for(int i = 0 ; i < employee.length ; i ++){
			System.out.println("Extension:"+employee[i].getExtension()+",Surname:"+employee[i].getSurname()+",GivenName:"+employee[i].getGivenname());
		}



	}
}
