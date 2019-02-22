package com.example.user.usbankapitest;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.usbankapitest.model.ContactDetailsPojo;
import com.example.user.usbankapitest.presenter.Presenter;
import com.example.user.usbankapitest.view.ViewContract;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewContract {

    @BindView(R.id.tv_age)
    TextView tv_age;
    @BindView(R.id.tv_city)
    TextView tv_city;
    @BindView(R.id.tv_firstName)
    TextView tv_firstName;
    @BindView(R.id.tv_lastName)
    TextView tv_lastName;
    @BindView(R.id.tv_number)
    TextView tv_number;
    @BindView(R.id.tv_phoneType)
    TextView tv_phoneType;
    @BindView(R.id.tv_state)
    TextView tv_state;
    @BindView(R.id.tv_streetAdd)
    TextView tv_streetAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Presenter presenter = new Presenter(this);
        presenter.callLoadDetails();

    }

    @Override
    public void populateData(ContactDetailsPojo contactDetailsPojo) {
        tv_city.setText(contactDetailsPojo.getAddress().getCity());
        tv_age.setText(contactDetailsPojo.getAge().toString());
        tv_firstName.setText(contactDetailsPojo.getFirstName());
        tv_lastName.setText(contactDetailsPojo.getLastName());
        tv_number.setText(contactDetailsPojo.getPhoneNumber().get(0).getNumber());
        tv_phoneType.setText(contactDetailsPojo.getPhoneNumber().get(0).getType());
        tv_state.setText(contactDetailsPojo.getAddress().getState());
        tv_streetAdd.setText(contactDetailsPojo.getAddress().getStreetAddress());
    }

    @Override
    public void loadDetailFailed(String errorMessage) {
        //Toast.makeText(this, errorMessage, Toast.LENGTH_LONG).show();
        //do this in a snackbar
        final CoordinatorLayout coordinatorLayout = findViewById(R.id.coordinatorLayout);
//
//        Snackbar snackbar = Snackbar
//                .make(coordinatorLayout, errorMessage, Snackbar.LENGTH_INDEFINITE);
//        snackbar.show();

        Snackbar snackbar = Snackbar
                .make(coordinatorLayout, errorMessage, Snackbar.LENGTH_LONG)
                .setAction("UNDO", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar snackbar1 = Snackbar.make(coordinatorLayout, "Activate WIFI", Snackbar.LENGTH_SHORT);
                        snackbar1.show();
                    }
                });

        snackbar.show();

    }
}
