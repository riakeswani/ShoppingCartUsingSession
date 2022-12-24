package models;

public class User 
{
	
	
		String name;
		long contact_no;
		String email_id;
		String password;
		public boolean isAdmin;
		public User(String name, String password) 
		{
			
			this.name = name;
			
			this.password = password;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public long getContact_no() {
			return contact_no;
		}
		public void setContact_no(long contact_no) {
			this.contact_no = contact_no;
		}
		public String getEmail_id() {
			return email_id;
		}
		public void setEmail_id(String email_id) {
			this.email_id = email_id;
		}
		
		public void setPassword(String password) {
			this.password = password;
		}
	}


