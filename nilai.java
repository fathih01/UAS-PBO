import java.util.InputMismatchException;
import java.util.Scanner;

import java.sql.*;

public class nilai extends mahasiswa {
    String nama_mhs;
    Integer nim;
    Integer kelas;
    Integer kuis1;
    Integer kuis2;
    Integer uts;
    Integer uas;
    Integer nilai_akhir;
    String predikat;
    String keterangan;

    Scanner input = new Scanner(System.in);
    static Connection conn;
    
    @Override
    public void input_data() {
    String url = "jdbc:mysql://localhost:3306/program";
    try{
        super.input_data();

        //nama
        System.out.println("Masukkan Nama Mahasiswa : ");
        nama_mhs = input.nextLine();

        //nim
        System.out.println("Masukkan NIM Mahasiswa: ");
        nim = input.nextInt();

        //kelas
        System.out.print("Masukkan Kelas Mahasiswa : ");
        kelas = input.nextInt();

        //nilai kuis1
        System.out.print("Masukkan Nilai Kuis 1 : ");
        kuis1 = input.nextInt();

        //nilai uts
        System.out.print("Masukkan Nilai UTS : ");
        uts = input.nextInt();

        //nilai kuis 2
        System.out.print("Masukkan Nilai Kuis 2 : ");
        kuis2 = input.nextInt();

        //nilai uas
        System.out.print("Masukkan Nilai UAS : ");
        uas = input.nextInt();

        //nilai akhir
        nilai_akhir = ((kuis1+uts+kuis2+uas)/4);

        //predikat
        if(nilai_akhir >= 0 && nilai_akhir <=50){
            predikat = "E";
        }
        else if (nilai_akhir > 51 && nilai_akhir <=55){
            predikat = "D";
        }
        else if (nilai_akhir > 56 && nilai_akhir <=60){
            predikat = "C";
        }
        else if (nilai_akhir > 61 && nilai_akhir <=65){
            predikat = "C+";
        }
        else if (nilai_akhir > 66 && nilai_akhir <=70){
            predikat = "B-";
        }
        else if (nilai_akhir > 71 && nilai_akhir <=75){
            predikat = "B";
        }
        else if (nilai_akhir > 76 && nilai_akhir <=80){
            predikat = "B+";
        }
        else if (nilai_akhir > 81 && nilai_akhir <=85){
           predikat = "A-";
        }
        else if (nilai_akhir > 86 && nilai_akhir <=100){
           predikat = "A";
        }
        else{
            System.out.println("EROR!!");
        }

        //keterangan
        if(predikat=="A"){
            keterangan="Lulus";
        }
        else if (predikat=="A-"){
            keterangan="Lulus";
        }
        else if (predikat=="B+"){
            keterangan="Lulus";
        }
        else if (predikat=="B"){
            keterangan="Lulus";
        }
        else if (predikat=="B-"){
            keterangan="Lulus";
        }
        else if (predikat=="C+"){
            keterangan="Lulus";
        }
        else if (predikat=="C"){
            keterangan="Lulus";
        }
        else if (predikat=="D"){
            keterangan="Tidak Lulus";
        }
        else if (predikat=="E"){
            keterangan="Tidak Lulus";
        }
        else{
            System.out.println("EROR!!");
        }

        String sql = "INSERT INTO nilaipbo (nama_mhs, nim, kelas, kuis1, uts, kuis2, uas, nilai_akhir, predikat, keterangan) VALUES ('"+nama_mhs+"','"+nim+"','"+kelas+"','"+kuis1+"','"+uts+"','"+kuis2+"','"+uas+"','"+nilai_akhir+"','"+predikat+"','"+keterangan+"')";
        conn = DriverManager.getConnection(url,"root","");
        Statement statement = conn.createStatement();
        statement.execute(sql);
        System.out.println("Berhasil input data!!");
    }
    catch (SQLException e) {
        System.err.println("Terjadi kesalahan input data");
    } 
    catch (InputMismatchException e) {
        System.err.println("Inputan harus berupa angka");
       }
    }

    @Override
    public void lihat_data(){
        super.lihat_data();
        String url = "jdbc:mysql://localhost:3306/program";
        try{
        String sql ="SELECT * FROM nilaipbo";
        conn = DriverManager.getConnection(url,"root","");
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(sql);

        while(result.next()){
            System.out.print("\nNama Mahasiswa\t: ");
            System.out.print(result.getString("nama_mhs"));
            System.out.print("\nNIM\t\t: ");
            System.out.print(result.getInt("nim"));
            System.out.print("\nKelas\t\t: ");
            System.out.print(result.getInt("kelas"));
            System.out.print("\nNilai Kuis 1\t: ");
            System.out.print(result.getInt("kuis1"));
            System.out.print("\nNilai UTS\t: ");
            System.out.print(result.getInt("uts"));
            System.out.print("\nNilai Kuis 2\t: ");
            System.out.print(result.getInt("kuis2"));
			System.out.print("\nNilai Akhir\t: ");
            System.out.print(result.getInt("nilai_akhir"));
            System.out.print("\nPredikat\t: ");
            System.out.print(result.getString("predikat"));
            System.out.print("\nKeterangan\t: ");
            System.out.print(result.getString("keterangan"));
            System.out.print("\n");

        }
      }
      catch (SQLException e) {
        System.err.println("Terjadi kesalahan");
    } 
    catch (InputMismatchException e) {
        System.err.println("Program Eror");
       }
    }

    @Override
    public void hapus_data(){
        super.hapus_data();
        String url = "jdbc:mysql://localhost:3306/program";
        try{
            lihat_data();
            System.out.print("\nMasukan NIM yang datanya akan di Hapus : ");
            Integer nim = Integer.parseInt(input.nextLine());
            
            String sql = "DELETE FROM nilaipbo WHERE nim = "+ nim;
            conn = DriverManager.getConnection(url,"root","");
            Statement statement = conn.createStatement();
            //ResultSet result = statement.executeQuery(sql);
            
            if(statement.executeUpdate(sql) > 0){
                System.out.println("Berhasil menghapus data NIM "+nim+"");
            }
       }
        catch(SQLException e){
            System.out.println("Terjadi kesalahan dalam menghapus data");
        }
        catch(Exception e){
            System.out.println("masukan data yang benar");
        }
      }

    
    @Override
    public void cari_data(){
        super.cari_data();
        String url = "jdbc:mysql://localhost:3306/program";
        try{
        System.out.print("Masukkan NIM yang ingin dilihat : ");    
        Integer keyword = Integer.parseInt(input.nextLine());
    
        conn = DriverManager.getConnection(url,"root","");
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM nilaipbo WHERE nim LIKE '%"+keyword+"%'";
        ResultSet result = statement.executeQuery(sql);   

        while(result.next()){
            System.out.print("\nNama Mahasiswa\t: ");
            System.out.print(result.getString("nama_mhs"));
            System.out.print("\nNIM\t: ");
            System.out.print(result.getInt("nim"));
            System.out.print("\nKelas\t: ");
            System.out.print(result.getInt("kelas"));
            System.out.print("\nNilai Kuis 1\t: ");
            System.out.print(result.getInt("kuis1"));
            System.out.print("\nNilai UTS\t: ");
            System.out.print(result.getInt("uts"));
            System.out.print("\nNilai Kuis 2\t: ");
            System.out.print(result.getInt("kuis2"));
			System.out.print("\nNilai Akhir\t: ");
            System.out.print(result.getInt("nilai_akhir"));
            System.out.print("\nPredikat\t: ");
            System.out.print(result.getString("predikat"));
            System.out.print("\nKeterangan\t: ");
            System.out.print(result.getString("keterangan"));
            System.out.print("\n");
        }
      }
      catch (SQLException e) {
        System.err.println("Terjadi kesalahan");
      } 
      catch (InputMismatchException e) {
        System.err.println("Program Eror");
      }
    }
    
    @Override  
    public void ubah_data(){
        super.ubah_data();
        try {
            lihat_data();
            String url = "jdbc:mysql://localhost:3306/program";
            System.out.print("\nMasukkan NIM Mahasiswa yang datanya akan di ubah : ");
            Integer nim = Integer.parseInt(input.nextLine());
            String sql = "SELECT * FROM nilaipbo WHERE nim = " +nim;
            conn = DriverManager.getConnection(url,"root","");
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            if(result.next()){
                
                System.out.print("Masukkan Nama Mahasiswa ["+result.getString("nama_mhs")+"]\t: ");
                String nama_mhs = input.nextLine();

                sql = "UPDATE nilaipbo SET nama_mhs='"+nama_mhs+"' WHERE nim='"+nim+"'";

                //System.out.println(sql);
    
                if(statement.executeUpdate(sql) > 0){
                    System.out.println("Berhasil memperbaharui data");
                }
            }
            statement.close();        
        } 
        catch (SQLException e) {
            System.err.println("Terjadi kesalahan dalam mengedit data");
            System.err.println(e.getMessage());
        }
       }
    }

