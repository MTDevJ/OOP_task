package core.person.stuff.management;

public class Administrator extends ManagementStaff {

    private final ManagementType TYPE = ManagementType.ADMINISTRATOR;

    @Override
    public ManagementType getType() {
        return TYPE;
    }
}
