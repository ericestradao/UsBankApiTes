package com.example.user.usbankapitest.presenter;

import com.example.user.usbankapitest.model.ApiInterface;
import com.example.user.usbankapitest.model.ConnectApi;
import com.example.user.usbankapitest.model.ContactDetailsPojo;
import com.example.user.usbankapitest.view.ViewContract;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class Presenter  implements PresenterContractor{

    ViewContract viewContract;

    public Presenter(ViewContract viewContract) {
        this.viewContract = viewContract;
    }

    @Override
    public void callLoadDetails() {
        Retrofit retrofit = ConnectApi.getInstance().getRetrofitData();
        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        apiInterface.loadDetails().enqueue(new Callback<ContactDetailsPojo>() {
            @Override
            public void onResponse(Call<ContactDetailsPojo> call, Response<ContactDetailsPojo> response) {

                viewContract.populateData(response.body());
            }

            @Override
            public void onFailure(Call<ContactDetailsPojo> call, Throwable t) {
                viewContract.loadDetailFailed(t.getMessage());
            }
        });
    }
}
