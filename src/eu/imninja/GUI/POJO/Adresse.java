package eu.imninja.GUI.POJO;

public class Adresse {
    private String vname;
    private String nname;
    private String alter;
    private String strasse;
    private String plz;
    private String ort;
    private String telefonnummer;
    private String mobilenummer;
    private String email;

    public Adresse(String vname, String nname) {
        this.vname = vname;
        this.nname = nname;
    }

    public Adresse(String vname, String nname, String alter, String strasse, String plz, String ort, String telefonnummer, String mobilenummer, String email) {
        this.vname = vname;
        this.nname = nname;
        this.alter = alter;
        this.strasse = strasse;
        this.plz = plz;
        this.ort = ort;
        this.telefonnummer = telefonnummer;
        this.mobilenummer = mobilenummer;
        this.email = email;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getNname() {
        return nname;
    }

    public void setNname(String nname) {
        this.nname = nname;
    }

    public String getAlter() {
        return alter;
    }

    public void setAlter(String alter) {
        this.alter = alter;
    }

    public String getStrasse() {
        return strasse;
    }

    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    public String getMobilenummer() {
        return mobilenummer;
    }

    public void setMobilenummer(String mobilenummer) {
        this.mobilenummer = mobilenummer;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getModelString() {
        return this.vname + " " + this.nname;
    }
}
