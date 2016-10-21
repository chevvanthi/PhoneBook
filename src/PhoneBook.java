
public class PhoneBook {

	private String name;
	private String mobileNum;

	public PhoneBook(String name2, String phone) {

		this.name = name2;
		this.mobileNum = phone;
	}

	public String getName() {
		return name;
	}

	public String getNum() {
		return mobileNum;
	}
	public void setName(String name)
	{
		this.name=name;
	}
public void setNum(String mobileNum)
{
	this.mobileNum=mobileNum;
}
	public void print() {
		System.out.println(" Name :  " + name + "  Mobile Num  :  " +  mobileNum);
	}
}
