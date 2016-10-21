import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBookTest {

	static TreeMap<String, PhoneBook> phBook;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	public static void showMenu() {
		System.out.println("1. View all phonebook entries");
		System.out.println("2. Add to phonebook");
		System.out.println("3. Remove from phonebook");
		System.out.println("4. search contact");
		System.out.println("5. update");
		System.out.println("6. Exit");
	}

	static String phone;

	public static void phoneMeth() throws IOException {

		System.out.println("Enter phone number :");

		phone = br.readLine();
		if (phone.length() != 10) {
			System.out.println("mobile number is invalid ");
			phoneMeth();
		}
	}

	public static void addToPhoneBook() {

		if (phBook == null)

			phBook = new TreeMap<String, PhoneBook>();
		try {

			String name;

			System.out.println("Enter name:");
			name = br.readLine();

			if (name.equals("")) {
				System.out.println(" invalid name");
				addToPhoneBook();
			}

			if (phBook.containsKey(name)) {
				System.out.println("The name is already present please enter another name");
				addToPhoneBook();
			}
			phoneMeth();

			
			PhoneBook st = new PhoneBook(name, phone);
			phBook.put(name, st);

			PhoneBookTest.showMenu();
			PhoneBookTest.choice();

		} catch (IOException e) {
		}
	}

	public static void viewAll() {

		System.out.println("------------------------");
		System.out.println("  Mobile number     Name");
		System.out.println("------------------------");
		if (phBook != null) {
			for (Entry<String, PhoneBook> e : phBook.entrySet()) {

				System.out.println("  " + e.getValue().getNum() + "          " + e.getKey());

			}

		}
		showMenu();
		choice();
	}

	public static void deleteFromPhonebook() {

		if (phBook != null) {
			int si = phBook.size();
			try {

				System.out.println("Name:");
				String key = br.readLine();
				phBook.remove(key);
				if (phBook.size() < si) {
					System.out.println("The entry has been deleted.");
				} else {
					System.out.println("Wrong name");
				}
				viewAll();
				showMenu();
				choice();
			} catch (IOException ie) {
			}

		}
	}

	public static void searchByName() {

		if (phBook != null) {
			try {

				System.out.println("Search by name:");
				String key = br.readLine();
				PhoneBook c = phBook.get(key);
				if (c != null)
					c.print();

				else {
					System.out.println(" No contact is found ");
				}

			} catch (IOException ie) {
			}

		}
		showMenu();
		choice();
	}

	public static void update() {

		Scanner scan = new Scanner(System.in);
		String cname;

		System.out.println("Enter the name ");
		cname = scan.next();
		if (!(phBook.containsKey(cname))) {
			System.out.println("No name found");
			update();
		}

		System.out.println("Enter the number to be updated");
		String cnum = scan.next();
		PhoneBook b = phBook.get(cname);
		if (b != null) {
			b.setNum(cnum);
			phBook.put(cname, b);
		}

		viewAll();
		showMenu();
		choice();
	}

	public static void choice() {

		System.out.println("Enter your choice:");
		Scanner sc = new Scanner(System.in);
		int ch;
		ch = sc.nextInt();

		switch (ch) {
		case 1:
			viewAll();
			break;

		case 2:
			addToPhoneBook();
			break;
		case 3:
			deleteFromPhonebook();
			break;
		case 4:
			searchByName();
			break;
		case 5:
			update();
			break;
		case 6:
			System.exit(0);
			break;
		default:
			System.out.println("Invalid choice");
		}

	}

	public static void main(String[] args) {

		showMenu();
		choice();
	}

}
