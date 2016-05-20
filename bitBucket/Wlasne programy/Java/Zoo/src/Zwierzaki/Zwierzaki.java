package Zwierzaki;
import java.util.Date;

class Zwierzaki {
private String imieOpiekuna;
private String imieZwierzaka;
private Float masaZwierzaka;
private String rasaZwierzaka;
private Date dataUrodzenia;

//Imie Wlasciciela
public String getImieWlasciciela() {
	return imieOpiekuna;
}
public void setImieWlasciciela(String imieWlasciciela) {
	this.imieOpiekuna = imieWlasciciela;
}

//Imie Zwierzaka
public String getImieZwierzaka() {
	return imieZwierzaka;
}
public void setImieZwierzaka(String imieZwierzaka) {
this.imieZwierzaka = imieZwierzaka;
}

//Masa Zwierzaka
public void setMasaZwierzaka(Float masaZwierzaka) {
	this.masaZwierzaka = masaZwierzaka;
}
public Float getMasaZwierzaka() {
	return masaZwierzaka;
}

//Rasa Zwierzaka
public String getRasaZwierzaka() {
	return rasaZwierzaka;
}
public void setRasaZwierzaka(String rasaZwierzaka) {
	this.rasaZwierzaka = rasaZwierzaka;
}

//Data urodzenia
public Date getDataUrodzenia() {
	return dataUrodzenia;
}
public void setData(Date dataUrodzenia) {
	this.dataUrodzenia = dataUrodzenia;
}
public void getStats(String getUserInfo){
}
}
