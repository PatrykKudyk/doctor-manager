package com.dziobsoft.doctormanager.doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getList(Specialization specialization, Integer minRate);
}
