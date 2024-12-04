package org.genbank.LoanAPI.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
//@AllArgsConstructor

@Embeddable
public class Name implements Serializable {

    private static final long serialVersionUID = 1L;

    @Nonnull
    private String firstName;
    @Nonnull
    private String middleName;
    @Nonnull
    private String lastName;
    public Name(String firstName, String middleName, String lastName) {
        super();
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

   @Override
    public String toString() {
        return "Name [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, middleName);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Name other = (Name) obj;
        return Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
                && Objects.equals(middleName, other.middleName);
    }



}
