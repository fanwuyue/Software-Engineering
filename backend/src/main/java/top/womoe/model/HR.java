package top.womoe.model;

public class HR {
    private Integer id;

    private String hrUsername;

    private String hrPassword;

    private String hrToken;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHrUsername() {
        return hrUsername;
    }

    public void setHrUsername(String hrUsername) {
        this.hrUsername = hrUsername;
    }

    public String getHrPassword() {
        return hrPassword;
    }

    public void setHrPassword(String hrPassword) {
        this.hrPassword = hrPassword;
    }

    public String getHrToken() {
        return hrToken;
    }

    public void setHrToken(String hrToken) {
        this.hrToken = hrToken;
    }
}