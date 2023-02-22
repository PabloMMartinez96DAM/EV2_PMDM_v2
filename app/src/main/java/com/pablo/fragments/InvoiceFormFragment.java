package com.pablo.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pablo.R;

//Fragment para crear nuevas facturas
public class InvoiceFormFragment extends Fragment {
    public InvoiceFormFragment() {
        // Required empty public constructor
    }
    public static InvoiceFormFragment newInstance(String param1, String param2) {
        InvoiceFormFragment fragment = new InvoiceFormFragment();
        Bundle args = new Bundle();

        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invoice_form, container, false);
    }
}