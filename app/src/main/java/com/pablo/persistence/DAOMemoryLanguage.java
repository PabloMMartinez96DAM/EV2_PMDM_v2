package com.pablo.persistence;

import com.pablo.models.LanguageModel;


import java.util.ArrayList;

public class DAOMemoryLanguage extends IDAOLanguage {


    @Override
    public ArrayList<LanguageModel> getAll() {
        return DataMemory.getInstance().datosIdiomas;
    }
}
