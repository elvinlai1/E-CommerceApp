package com.example.e_commerceapp;

import android.widget.EditText;

public class Transaction {

    String fn, ln, em, pn, pc, prov, order;
    Double total;

    public Transaction(String fn, String ln, String em, String pn, String pc, String prov, String o, Double t) {
        this.fn = fn;
        this.ln = ln;
        this.em = em;
        this.pn = pn;
        this.pc = pc;
        this.prov = prov;
        this.order = o;
        this.total = t;
    }

    public String getFn() {
        return fn;
    }

    public void setFn(String fn) {
        this.fn = fn;
    }

    public String getLn() {
        return ln;
    }

    public void setLn(String ln) {
        this.ln = ln;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getPc() {
        return pc;
    }

    public void setPc(String pc) {
        this.pc = pc;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }


}
