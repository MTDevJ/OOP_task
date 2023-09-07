package core.service.examination;

import core.person.stuff.medical.DoctorType;

public class XrayCheck extends Examination{

    public XrayCheck() {
        doctorType = DoctorType.RADIOLOGIST;
        appointmentDuration = 30000;
        price = 35;
    }
}
