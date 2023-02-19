package com.pablo.persistence;

import com.pablo.models.LanguageModel;


import java.util.ArrayList;

public abstract class IDAOLanguage {

    public abstract ArrayList<LanguageModel> getAll();

    public static IDAOLanguage GetInstance()
    {
        if (AppConfig.Modo == "MEMORY")
        {
            return new DAOMemoryLanguage();
        }
        if (AppConfig.Modo == "FIREASE")
        {
            //return new DAOFirebaseIdioma();
        }
        if (AppConfig.Modo == "SQLITE")
        {
            //return new DAOSQLiteIdioma();
        }
        return null;
    }
}
