package Database;

import java.util.ArrayList;

import Model.NhanVien;

public abstract class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DB db=new DB();
		NhanVien nv=db.checkUser("a", "a");
		System.out.println(nv);
	}

}
