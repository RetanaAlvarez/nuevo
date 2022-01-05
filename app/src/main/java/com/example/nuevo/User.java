package com.example.nuevo;

public class User {
    
    private String email, pwd, nombre,apellidoP,apellidosM,telefono,edad,no_de_seguro,numerodecontrol;

    public String getEmail() { return email; }

    public String getApellidoP() { return apellidoP; }

    public void setApellidoP(String apellidoP) { this.apellidoP = apellidoP; }

    public String getApellidosM() { return apellidosM; }

    public void setApellidosM(String apellidosM) { this.apellidosM = apellidosM; }

    public void setEmail(String email) { this.email = email;}

    public String getNumerodecontrol() { return numerodecontrol; }

    public void setNumerodecontrol(String numerodecontrol) { this.numerodecontrol = numerodecontrol; }

    public String getPwd() {
        return pwd;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNo_de_seguro() {
        return no_de_seguro;
    }

    public void setNo_de_seguro(String no_de_seguro) {
        this.no_de_seguro = no_de_seguro;
    }

    public void setPwd(String pwd) { this.pwd = pwd; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }
}
