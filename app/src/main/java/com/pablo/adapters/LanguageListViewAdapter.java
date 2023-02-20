package com.pablo.adapters;

import android.content.Context;
import android.content.res.Configuration;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.pablo.R;
import com.pablo.activities.MainActivity;
import com.pablo.models.LanguageModel;
import com.pablo.persistence.AppConfig;

import java.util.List;
import java.util.Locale;

public class LanguageListViewAdapter extends BaseAdapter {

    private Context _context;
    private final List<LanguageModel> _items;

    public LanguageListViewAdapter(@NonNull Context context, @NonNull List<LanguageModel> items) {
        _items = items;
        _context = context;
    }

    @Override
    public int getCount() {
        return _items.size();
    }

    @Override
    public Object getItem(int position) {
        LanguageModel idioma = _items.get(position);
        return idioma;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(_context);
            view = inflater.inflate(R.layout.adapter_listview_language, parent, false);
        }
        LanguageModel language = _items.get(position);
        view.setTag(language);

        TextView lblText = view.findViewById(R.id.lblText);
        lblText.setText(language.getDescription());

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageModel language = ((LanguageModel)view.getTag());
                AppConfig.LANG_CURRENT = language.getCountryCode();

                MainActivity mainActivity =(MainActivity)_context;

                //SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(mainActivity);
                Configuration config = mainActivity.getBaseContext().getResources().getConfiguration();
                if (!"".equals(AppConfig.LANG_CURRENT) && !config.locale.getLanguage().equals(AppConfig.LANG_CURRENT)) {
                    Locale locale = new Locale(AppConfig.LANG_CURRENT);
                    Locale.setDefault(locale);
                    config.locale = locale;
                    mainActivity.getBaseContext().getResources().updateConfiguration(config, mainActivity.getBaseContext().getResources().getDisplayMetrics());
                    mainActivity.recreate();
                    Log.d("CLICK: ", language.getDescription());
                }
                else{
                    Toast.makeText(mainActivity, "El lenguaje seleccionado ya está en uso", Toast.LENGTH_SHORT).show();
                }

            }
        });

        return view;
    }
}
