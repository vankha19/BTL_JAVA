/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author banhg
 */
public class Score {
    private String id,fullname,hanhKiem;
    private float toan,van,anh,ly,hoa,sinh,dia,su,quocphong,tin,gdcd,thechat,dtb;

    public Score() {
    }

    public Score(String id, String fullname, String hanhKiem, float toan, float van, float anh, float ly, float hoa, float sinh, float dia, float su, float quocphong, float tin, float gdcd, float thechat, float dtb) {
        this.id = id;
        this.fullname = fullname;
        this.hanhKiem = hanhKiem;
        this.toan = toan;
        this.van = van;
        this.anh = anh;
        this.ly = ly;
        this.hoa = hoa;
        this.sinh = sinh;
        this.dia = dia;
        this.su = su;
        this.quocphong = quocphong;
        this.tin = tin;
        this.gdcd = gdcd;
        this.thechat = thechat;
        this.dtb = dtb;
    }

    public String getId() {
        return id;
    }

    public String getFullname() {
        return fullname;
    }

    public String getHanhKiem() {
        return hanhKiem;
    }

    public float getToan() {
        return toan;
    }

    public float getVan() {
        return van;
    }

    public float getAnh() {
        return anh;
    }

    public float getLy() {
        return ly;
    }

    public float getHoa() {
        return hoa;
    }

    public float getSinh() {
        return sinh;
    }

    public float getDia() {
        return dia;
    }

    public float getSu() {
        return su;
    }

    public float getQuocphong() {
        return quocphong;
    }

    public float getTin() {
        return tin;
    }

    public float getGdcd() {
        return gdcd;
    }

    public float getThechat() {
        return thechat;
    }

    public float getDtb() {
        float dtb = (this.getToan()+this.getVan()+this.getAnh()+this.getLy()+this.getHoa()+this.getSinh()+this.getDia()+this.getSu()+this.getTin()+this.getQuocphong()+this.getGdcd()+this.getThechat()) / 12 ;
        return dtb;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public void setHanhKiem(String hanhKiem) {
        this.hanhKiem = hanhKiem;
    }

    public void setToan(float toan) {
        this.toan = toan;
    }

    public void setVan(float van) {
        this.van = van;
    }

    public void setAnh(float anh) {
        this.anh = anh;
    }

    public void setLy(float ly) {
        this.ly = ly;
    }

    public void setHoa(float hoa) {
        this.hoa = hoa;
    }

    public void setSinh(float sinh) {
        this.sinh = sinh;
    }

    public void setDia(float dia) {
        this.dia = dia;
    }

    public void setSu(float su) {
        this.su = su;
    }

    public void setQuocphong(float quocphong) {
        this.quocphong = quocphong;
    }

    public void setTin(float tin) {
        this.tin = tin;
    }

    public void setGdcd(float gdcd) {
        this.gdcd = gdcd;
    }

    public void setThechat(float thechat) {
        this.thechat = thechat;
    }

    public void setDtb(float dtb) {
        this.dtb = dtb;
    }

    
    
    
}
