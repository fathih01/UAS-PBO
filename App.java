import java.util.Scanner;
import java.sql.*;

public class App {
	//static Scanner scanner;
	static Connection conn;
	
    public static void main(String[] args) {
    	Scanner Input = new Scanner (System.in);
    	String pilihan;
    	boolean isLanjutkan = true;

		String url = "jdbc:mysql://localhost:3306/program";
		 
		
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");   
			conn = DriverManager.getConnection(url,"root", "" );
			System.out.println("Class Driver ditemukan!!!");
			nilai nilai = new nilai();
			
			while (isLanjutkan) {
				System.out.println("----------------------");
				System.out.println("Database Mahasiswa");
				System.out.println("----------------------");
				System.out.println("1. Lihat Data Mahasiswa");
				System.out.println("2. Tambah Data Mahasiswa");
				System.out.println("3. Ubah Data Mahasiswa");
				System.out.println("4. Hapus Data Mahasiswa");
				System.out.println("5. Cari Data Mahasiswa");
				
				System.out.print("\nPilihan anda (1/2/3/4/5): ");
				pilihan = Input.next();
			
				switch (pilihan) {
				case "1":
					nilai.lihat_data();
					break;
				case "2":
					nilai.input_data();
					break;
				case "3":
					nilai.ubah_data();
					break;
				case "4":
					nilai.hapus_data();
					break;
				case "5":
					nilai.cari_data();
					break;
				default:
					System.err.println("\nInput anda tidak ditemukan\nSilakan pilih [1-5]");
				}
				
				System.out.print("\nApakah Anda ingin melanjutkan [y/n]? ");
				pilihan = Input.next();
				isLanjutkan = pilihan.equalsIgnoreCase("y");

			}
			System.out.println("Program selesai...");
			Input.close();
		}
		catch(ClassNotFoundException ex) {
			System.err.println("Clas not found check the JAR");
			System.exit(0);
		}
		catch(SQLException e){
			System.err.println("Tidak berhasil koneksi");
			
		}
    }
}
