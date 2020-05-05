package top.womoe.model;

public class NewLog {
    private Integer id;

    private String hrNumber;

    private String hrName;

    private String message;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHrNumber() {
        return hrNumber;
    }

    public void setHrNumber(String hrNumber) {
        this.hrNumber = hrNumber;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHrName() {
        return hrName;
    }

    public void setHrName(String hrName) {
        this.hrName = hrName;
    }
}