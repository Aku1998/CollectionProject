package CollectionProject.Object;

public enum OrganizationType {
    PUBLIC("публичная"),
    TRUST("трастовая"),
    OPEN_JOINT_STOCK_COMPANY ("открытое акционерное");

    private final String type;

    OrganizationType(String type) {
        this.type = type;
    }

    public String getOrgType() {
        return type;
    }

}
