import java.text.SimpleDateFormat;
import java.util.Date;

public class mahasiswa implements database {

    public void waktu(){
        Date waktu = new Date();
        SimpleDateFormat tf = new SimpleDateFormat("hh:mm:ss yyyy-MM-dd");
        System.out.println(tf.format(waktu));
    } 

    public void input_data(){
        String input_data = "program inputan data mahasiswa";
        System.out.println("------------------------------");
        System.out.println(input_data.toUpperCase());
        waktu();
        System.out.println("------------------------------");
    }

    public void lihat_data(){
        String lihat_data = "program menampilkan data mahasiswa";
        System.out.println("------------------------------");
        System.out.println(lihat_data.toUpperCase());
        waktu();
        System.out.println("------------------------------");
    }

    public void ubah_data() {
        String ubah_data = "program mengubah data mahasiswa";
        System.out.println("------------------------------");
        System.out.println(ubah_data.toUpperCase());
        waktu();
        System.out.println("------------------------------");
    }

    public void cari_data(){
        String cari_data = "program mencari data mahasiswa";
        System.out.println("------------------------------");
        System.out.println(cari_data.toUpperCase());
        waktu();
        System.out.println("------------------------------");
    }

    public void hapus_data(){
        String hapus_data = "program menghapus data mahasiswa";
        System.out.println("------------------------------");
        System.out.println(hapus_data.toUpperCase());
        waktu();
        System.out.println("------------------------------");
    }
}
