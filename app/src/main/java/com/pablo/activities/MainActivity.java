package com.pablo.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.pablo.R;
import com.pablo.fragments.DashboardFragment;
import com.pablo.fragments.LanguageFragment;
import com.pablo.fragments.MasterClientFragment;
import com.pablo.fragments.MasterInvoiceFragment;
import com.pablo.models.UserModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private View _headerLayout;
    private TextView _userLbl;
    private DrawerLayout _drawerLayout;
    private NavigationView _navView;
    private Toolbar _toolbar;
    private FragmentManager _fragmentManager;
    private List<Fragment> _fragments = new ArrayList<>();


    //Método que se ejcuta cuando se crea una instancia del MainActivity
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Asignamos el xml que contiene los componentes del layout principal
        setContentView(R.layout.activity_main);

        //Recuperamos la Toolbar del layout en función del ID que se le ha puesto en el xml
        _toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(_toolbar);


        //Inicializamos el FragmentManager y guardamos los distintos fragment a los que tenemos
        //intención de navegar en la lista
        _fragmentManager = getSupportFragmentManager();

        _fragments.add(new DashboardFragment());
        _fragments.add(new MasterClientFragment());
        _fragments.add(new MasterInvoiceFragment());
        _fragments.add(new LanguageFragment());

        //Desplegamos el primer fragment utilizando un método
        displayFragment(0);

        //Obtenemos el usuario que se ha pasado como argumento(Bundle) desde el LoginActivity
        UserModel user = (UserModel) getIntent().getSerializableExtra("user");

        //Obtenemos los layouts por su id
        _navView = (NavigationView) findViewById(R.id.nav_view);
        _navView.setNavigationItemSelectedListener(new NavView_OnNavigationItemSelectedListener());
        _headerLayout = _navView.getHeaderView(0);

        //Inicializamos los componentes de tipo Label con los datos del usuario que se ha logueado
        _userLbl = _headerLayout.findViewById(R.id.lblUser);
        _userLbl.setText("Bienvenido/a: " + user.getUserName());

        //Implementamos el Toggle del drawer layout, es decir, que salaga el botón en la esquina
        //superior izquierda
        _drawerLayout = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                _drawerLayout,
                _toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        _drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



    }

    private void displayFragment(int position) {

        //Obtenemos el fragment de la lista en función de la posición
        Fragment fragment = _fragments.get(position);

        //Para gestionar la transacción entre fragments necesitamos crear una instancia de la clase
        //FragmentTransacion en función del fragmentManager
        FragmentTransaction transaction = _fragmentManager.beginTransaction();

        //Sustituye el fragment del el container especificado como parámetro por otro fragment que también se le
        //pasa como parámetro
        transaction.replace(R.id.content_frame, fragment);

        //Confirmamos los cambios y se ejecuta la transacción
        transaction.commit();

    }

    //Sobrecarga para que al navegar se le pase tambien un usuario como argumento al siguiente fragment
    private void displayFragment(int position,UserModel user) {

        //Obtenemos el fragment de la lista en función de la posición
        Fragment fragment = _fragments.get(position);

        //Para gestionar la transacción entre fragments necesitamos crear una instancia de la clase
        //FragmentTransacion en función del fragmentManager
        FragmentTransaction transaction = _fragmentManager.beginTransaction();

        //Sustituye el fragment del el container especificado como parámetro por otro fragment que también se le
        //pasa como parámetro
        transaction.replace(R.id.content_frame, fragment);

        //Confirmamos los cambios y se ejecuta la transacción
        transaction.commit();

    }

    private class NavView_OnNavigationItemSelectedListener implements NavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.menu_dashboard:

                    getSupportActionBar().setTitle("DASHBOARD");
                    displayFragment(0);
                    break;
                case R.id.menu_clientes:
                    displayFragment(1);
                    getSupportActionBar().setTitle("CLIENTES");
                    break;
                case R.id.menu_facturas:
                    displayFragment(2);
                    getSupportActionBar().setTitle("FACTURAS");
                    break;
                case R.id.menu_idioma:
                    displayFragment(3);
                    getSupportActionBar().setTitle("IDIOMA");
                    break;
                case R.id.menu_salir:
                    android.os.Process.killProcess(android.os.Process.myPid());
                    System.exit(1);
                    break;
            }
            _drawerLayout.closeDrawers();
            return true;
        }
    }
}
