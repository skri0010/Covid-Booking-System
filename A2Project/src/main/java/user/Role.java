package user;

/**
 * Class represent the Role
 *
 * @author Chok Ming Jie and Suchit Sudhir Krishna
 * @version 1.0
 * @see User
 * @see UserRole
 */
public class Role {

    /**
     * Constructor for the Role class
     */
    public Role() {
    }

    private Enum<UserRole> roleType;

    public Enum<UserRole> getRoleType() {
        return roleType;
    }

    public void setRoleType(Enum<UserRole> roleType) {
        this.roleType = roleType;
    }
}
