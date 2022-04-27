package passwordManager;

import java.io.Serializable;

public class Entry implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private String username;
	private String password;
	private String URL;
	
	/**
	 * Constructor, creates entry and sets fields to default values.
	 */
	public Entry() {
		title = "New Entry";
		username = "Example Username";
		password = GeneratorPanel.generateStrongPassword();
		URL = "example.com";
	}
	
	/**
	 * sets all fields to null value
	 */
	public void deleteEntry() {
		title = null;
		username = null;
		password = null;
		URL = null;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getURL() {
		return URL;
	}
	public void setURL(String url) {
		this.URL = url;
	}
}
