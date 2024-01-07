import java.sql.*;

public interface database {
    public void input_data() throws SQLException;
    public void lihat_data() throws SQLException;
    public void ubah_data() throws SQLException;
    public void cari_data() throws SQLException;
    public void hapus_data();
}
