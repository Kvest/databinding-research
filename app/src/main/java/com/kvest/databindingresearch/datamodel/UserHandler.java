package com.kvest.databindingresearch.datamodel;

import android.view.View;
import android.widget.EditText;

/**
 * Created by kvest on 18.01.16.
 */
public class UserHandler {
    private final User user;
    private EditText firstName;
    private EditText lastName;

    public UserHandler(User user, EditText firstName, EditText lastName) {
        this.user = user;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void onChange(View view) {
        user.setFirstName(firstName.getText().toString());
        user.setLastName(lastName.getText().toString());
    }
}
