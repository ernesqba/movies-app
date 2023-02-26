package uah.es.moviesfrontend.model;

public class Role {

    private Integer id;
    private String authority;

    public Role() {
    }

    public Role(String idAndRole) {
        if (idAndRole != null && idAndRole.length() > 0) {
            String[] fieldPositions = idAndRole.split("-");
            this.id = Integer.parseInt(fieldPositions[0]);
            this.authority = fieldPositions[1];
        }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

    @Override
    public String toString() {
        return "" + id + "-" + this.authority;
    }

}
