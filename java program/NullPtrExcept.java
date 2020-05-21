import java.util.Scanner;
import java.io.*;
/**
 * @author Or Shemesh
 * 
 */
public class NullPtrExcept {
	/**
	 * The problem in this function
	 * 1.null pointer exception is not fixed problrem
	 * 2.catching NullPointerException adds significantly more performance overhead 
	 * than simply adding the necessary null checks.
	 * 3.t is difficult or impossible to determine 
	 * which expression is responsible for the exception because the 
	 * NullPointerException catch block handles any NullPointerException
	 * @param getfile
	 */
	public static void UseExceotion(String getfile)  {
		try {
			File file = new File(getfile);
			File[] files =file.listFiles();
			BufferedReader br;
			br = new BufferedReader(new FileReader(files[0]));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} 
		catch (java.lang.NullPointerException exception){
			System.out.println("you have a problem");}
		catch (IOException e) {}
	}
	/**
	 * Do not use the null value in any instance where an object is required, 
	 * including the following cases:
	 * Calling the instance method of a null object
	 * Accessing or modifying the field of a null object
	 * Taking the length of null as if it were an array
	 * Accessing or modifying the elements of null as if it were an array
	 * Throwing null as if it were a Throwable value
	 * @param getfolder
	 */
	public static void NonUseExceotion(String getfolder)  {

		File file = new File(getfolder);
		System.out.println("Files are:");
		File[] files =file.listFiles();
		if(files.length>0&&file!=null) {
			for (int i = 0; i < files.length; i++) { 
				System.out.println(files[i].getName()); 
			}
		}
	} 
	public static void main(String[] args) {
		System.out.println("Tap 1 for a first program , or 2 for a second : ");
		Scanner get_number = new Scanner(System.in); 
		int whichProgram= get_number.nextInt();
		if(whichProgram==1) {
			System.out.println("let Name a file : ");
			Scanner get_name_file = new Scanner(System.in); 
			String name = get_name_file.nextLine(); 
			System.out.println();
			UseExceotion(name);
		}else if(whichProgram==2) {
			System.out.println("let Name a folder : ");
			Scanner get_name_folder = new Scanner(System.in);  
			String name = get_name_folder.nextLine(); 
			NonUseExceotion(name);
		}

	}    
}
