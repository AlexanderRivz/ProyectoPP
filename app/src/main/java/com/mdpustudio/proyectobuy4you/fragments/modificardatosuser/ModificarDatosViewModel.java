package com.mdpustudio.proyectobuy4you.fragments.modificardatosuser;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ModificarDatosViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ModificarDatosViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}