package Model;

public class NhanVien {
	private int id;
	private String name;
	private int age;
	private String address;
	private String position;
	private String description;
	private String username;
	private String password;
	private int type;

	public NhanVien() {

	}

	public NhanVien(int id, String name, int age, String address, String position, String description, String username,
			String password, int type) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.position = position;
		this.description = description;
		this.username = username;
		this.password = password;
		this.type = type;
	}

	public NhanVien(String name, int age, String address, String position, String description, String username,
			String password, int type) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.position = position;
		this.description = description;
		this.username = username;
		this.password = password;
		this.type = type;
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

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
