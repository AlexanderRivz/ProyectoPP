package com.mdpustudio.proyectobuy4you.fragments.consumidor.mainpageusuario;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ProveedorViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ProveedorViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}