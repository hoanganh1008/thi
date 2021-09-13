package model;

public class Contact {
    public String numberId;
    public String groupOfCOntact;
    public String name;
    public String sex;
    public String address;
    public String dateOfBirth;
    public String email;

    public Contact(String numberId, String groupOfCOntact, String name, String sex, String address, String dateOfBirth, String email) {
        this.numberId = numberId;
        this.groupOfCOntact = groupOfCOntact;
        this.name = name;
        this.sex = sex;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
    }

    public String getNumberId() {
        return numberId;
    }

    public void setNumberId(String numberId) {
        this.numberId = numberId;
    }

    public String getGroupOfCOntact() {
        return groupOfCOntact;
    }

    public void setGroupOfCOntact(String groupOfCOntact) {
        this.groupOfCOntact = groupOfCOntact;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "numberId='" + numberId + '\'' +
                ", groupOfCOntact='" + groupOfCOntact + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
