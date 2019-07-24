package by.bsu.first.entity;

/**
 * Created by Ihar_Blinou on 10/21/2015.
 */

import java.io.Serializable;

public class Abonent extends Entity {
    private int phone;
    private String lastname;

    public Abonent() {
        super();
    }

    public Abonent(int id, int phone, String lastname) {
        super(id);
        this.phone = phone;
        this.lastname = lastname;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Abonent)) {
            return false;
        }

        Abonent abonent = (Abonent) o;

        if (phone != abonent.phone) {
            return false;
        }
        return lastname.equals(abonent.lastname);

    }

    @Override
    public int hashCode() {
        int result = phone;
        result = 31 * result + lastname.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Abonent [id=" + this.getId() + ", phone=" + phone +
                ", lastname=" + lastname + "]";
    }
}
