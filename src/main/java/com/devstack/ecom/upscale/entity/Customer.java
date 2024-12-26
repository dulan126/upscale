package entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "customer")

public class Customer {
    @Id
    @Column(name = "property_id", nullable = false, length = 80 )
    private String propertyId;

    @Column(name = "name", nullable = false, length = 45 )
    private String name;

    @Column(name = "email", nullable = false, length = 100, unique = true )
    private String email;

    @Column(name = "phone", nullable = false, length = 20 )
    private String phone;

    @Column(name = "address", nullable = false, length = 8255 )
    private String address;

    @Column(name = "is_active", columnDefinition = "TINYINT")
    private boolean isActive;

}
