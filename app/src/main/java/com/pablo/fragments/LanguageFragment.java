package com.pablo.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.pablo.R;
import com.pablo.adapters.LanguageListViewAdapter;
import com.pablo.models.LanguageModel;
import com.pablo.persistence.IDAOLanguage;

import java.util.List;

public class LanguageFragment extends Fragment {


    private View _view;
    private FragmentActivity _context;
    private ListView _listView;
    private LanguageListViewAdapter _adapter;

    public LanguageFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        _view = inflater.inflate(R.layout.fragment_language, container, false);
        return _view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        _context = getActivity();
        _listView = (ListView) _view.findViewById(R.id.listView);
        //ArrayList<ModelIdioma> idiomas = _idaoIdioma.getAll();

        List<LanguageModel> languages = IDAOLanguage.getInstance().getAll();

        _adapter = new LanguageListViewAdapter(_context, languages);
        _listView.setAdapter(_adapter);

    }
}