package com.example.turistworld;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.os.StrictMode;
import android.widget.TextView;
import android.widget.Toast;

import com.example.turistworld.Objetos.RecyclerViewAdaptador;
import com.example.turistworld.Objetos.listaLugares;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class lugares extends AppCompatActivity implements SensorEventListener {
    TextView ex,ey,ez;
    Sensor sensor2;
    SensorManager sm2;

    private RecyclerView recyclerViewLugar;
    private RecyclerViewAdaptador adaptadorlugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lugares);

        recyclerViewLugar=(RecyclerView)findViewById(R.id.recyclerlugares);
        recyclerViewLugar.setLayoutManager(new LinearLayoutManager(this));


        adaptadorlugar=new RecyclerViewAdaptador(obtenerlugares());
        recyclerViewLugar.setAdapter(adaptadorlugar);

        adaptadorlugar=new RecyclerViewAdaptador(obtenerlugaresBD());
        recyclerViewLugar.setAdapter(adaptadorlugar);


        ex = (TextView) findViewById(R.id.ex);
        ey = (TextView) findViewById(R.id.ey);
        ez = (TextView) findViewById(R.id.ez);

        sm2 =(SensorManager) getSystemService(SENSOR_SERVICE);
        sensor2 = sm2.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        sm2.registerListener(this,sensor2,SensorManager.SENSOR_DELAY_NORMAL);
    }
    //conexion con bd
    public Connection conexionBD() throws SQLException {
        Connection conexion=null;
        try{
            StrictMode.ThreadPolicy policy=new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
            Class.forName("net.sourceforge.jtds.jdbc.Driver").newInstance();
            conexion= DriverManager.getConnection("jdbc:jtds:sqlserver://localhost;databaseName=Developeru;user=df;password=123;");

        }catch(Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return conexion;
    }

    public List<listaLugares> obtenerlugaresBD(){
        List<listaLugares> lugares2=new ArrayList<>();
        try{
            Statement at=conexionBD().createStatement();
            ResultSet rs=at.executeQuery("select *from lugares");
            while (rs.next()){
                lugares2.add(new listaLugares(rs.getString("Nombres"),rs.getString("Ubicacion"),R.drawable.slaja));
            }
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),e.getMessage(),Toast.LENGTH_SHORT).show();
        }
        return lugares2;

    }

    public List<listaLugares> obtenerlugares(){
       List<listaLugares> lugares=new ArrayList<>();
       lugares.add(new listaLugares("salto del laja","chile",R.drawable.slaja));
        lugares.add(new listaLugares("salto del itata","chile",R.drawable.saltoitata));
        lugares.add(new listaLugares("termas de chillan","chile",R.drawable.termachillan));
        lugares.add(new listaLugares("catedral de chillan","chile",R.drawable.catedralchillan));
        lugares.add(new listaLugares("punta lavapie","chile",R.drawable.lavapie));
        return lugares;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        ex.setText(String.valueOf(sensorEvent.values[0]));
        ey.setText(String.valueOf(sensorEvent.values[1]));
        ez.setText(String.valueOf(sensorEvent.values[2]));

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
