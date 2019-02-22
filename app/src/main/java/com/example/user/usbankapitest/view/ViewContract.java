package com.example.user.usbankapitest.view;

import com.example.user.usbankapitest.model.ContactDetailsPojo;

public interface ViewContract {
    void populateData(ContactDetailsPojo contactDetailsPojo);
//    void populateData(String firstName,
//                      String lastName,)
    void loadDetailFailed(String errorMessage);
}
