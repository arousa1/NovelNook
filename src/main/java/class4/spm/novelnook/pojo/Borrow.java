package class4.spm.novelnook.pojo;

<<<<<<< HEAD
=======
import com.fasterxml.jackson.annotation.JsonFormat;
>>>>>>> 9ee743ec0980e42635471512ad22b43a516ac032
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

<<<<<<< HEAD
import java.sql.Date;

=======
import java.util.Date;
>>>>>>> 9ee743ec0980e42635471512ad22b43a516ac032

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
<<<<<<< HEAD

    String userid;
    String bookid;
    Date borrowtime;
    Date deadline;
    String status;


}

=======
    String borrowid;
    String userid;
    String bookid;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date   borrowtime;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date   deadline;
    String status;

    public void setBorrowid(String borrowid) {
        this.borrowid = borrowid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public void setBookid(String bookid) {
        this.bookid = bookid;
    }

    public void setBorrowtime(Date borrowtime) {
        this.borrowtime = borrowtime;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
>>>>>>> 9ee743ec0980e42635471512ad22b43a516ac032
