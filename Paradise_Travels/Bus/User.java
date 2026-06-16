package Bus;
import java.util.ArrayList;

public class User {
    private String userName;
	private String password;
	private String fullName;
	private String gender;
	private String contactNum;
	private String major;
	
	ArrayList <String> degrees= new ArrayList<String>();
	
	public void setName(String a)
	{
		fullName = a;
	}
	
	public void setUserName(String a)
	{
		userName = a;
	}
	
	public void setPassword(String a)
	{
		password = a;
	}
	
	public void setGender(String a)
	{
		gender = a;
	}
	
	public void setContactNum(String a)
	{
		contactNum = a;
	}
	
	public void setMajor(String a)
	{
		major = a;
	}
	
	public String getName()
	{
		return fullName;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	public String getPassword()
	{
		return password;
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public String getContactNum()
	{
		return contactNum;
	}
	
	public String getMajor()
	{
		return major;
	}
	
	public User(String a, String b)
	{
		userName = a;
		password = b;
	}
    public User(){
        
    }
}
